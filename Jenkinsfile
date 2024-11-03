pipeline {
    agent any

    parameters {
        activeChoice(
            name: 'SITE',
            description: 'Select the Site (namespace:IP)',
            choiceType: 'PT_CHECKBOX',
            script: [
                $class: 'org.biouno.unochoice.model.GroovyScript',
                script: new org.jenkinsci.plugins.scriptsecurity.sandbox.groovy.SecureGroovyScript(
                    '''return [
                        'MHHTP:10.5.43.89', 'LGHJP:10.5.43.93', 'RGHPJ:10.5.43.94',
                        'ATHJ:10.5.43.95', 'KAAHJ:10.5.43.74', 'MHHB:10.5.43.75',
                        'AZMHP:10.5.43.79', 'JEHP:10.5.43.92', 'PANAH:10.5.43.92',
                        'CHTP:10.5.43.92', 'KABHP:10.5.43.89', 'MCHN:10.5.43.88',
                        'AYRH:10.5.43.87', 'SARAT:10.5.43.87', 'MAHANI:10.5.43.83',
                        'JIPCP:10.5.43.81', 'SBSHP:10.5.43.86', 'QBMHP:10.5.43.86',
                        'KHP:10.5.43.86', 'MSHP:10.5.43.86', 'THP:10.5.43.86',
                        'MUWHP:10.5.43.86', 'QHP:10.5.43.86', 'RHP:10.5.43.86',
                        'JPSHP:10.5.43.78', 'KAHTP:10.5.43.90', 'MCHKP:10.5.43.85',
                        'AGHP:10.5.43.84', 'MGHP:10.5.43.84', 'HHP:10.5.43.84',
                        'MHP:10.5.43.84', 'PAH:10.5.43.84', 'PRPB:10.5.43.84',
                        'GHP:10.5.43.84', 'dvlp:192.168.55.22'
                    ]''',
                    true
                )
            ]
        )
        choice(
            name: 'SERVICE',
            description: 'Select the Service',
            choices: [
                'word-report', 'dataset-setup', 'scm-integration',
                'nphies-clinical-service', 'dataset-processing', 'active-mq',
                'medical-extensions', 'release-notes-service',
                'security-service', 'message-broker', 'email-service',
                'word-documents', 'oasis-app-service'
            ]
        )
        string(
            name: 'VERSION',
            defaultValue: '1.0.0',
            description: 'Specify the Version to deploy'
        )
    }

    stages {
        stage('Pull Docker Images') {
            steps {
                script {
                    def sites = params.SITE?.tokenize(',') ?: []
                    def service = params.SERVICE

                    if (!sites || !service) {
                        error "Please select at least one Site and one Service."
                    }

                    echo "Selected Sites: ${sites.join(', ')}"
                    echo "Selected Service: ${service}"
                    echo "Version: ${params.VERSION}"

                    sites.each { site ->
                        echo "Pulling image: oasissys/${service}:${params.VERSION}"
                        sh "docker pull oasissys/${service}:${params.VERSION}"
                        def imageCheck = sh(script: "docker images -q oasissys/${service}:${params.VERSION}", returnStdout: true).trim()
                        if (!imageCheck) {
                            error "Image oasissys/${service}:${params.VERSION} not found."
                        }
                    }
                }
            }
        }

        stage('Copy and Update Services') {
            steps {
                script {
                    def sites = params.SITE?.tokenize(',') ?: []
                    def updateStages = [:]
                    for (site in sites) {
                        site = site.trim()
                        if (site) {
                            def (namespace, ip) = site.split(':')
                            updateStages["Update on ${ip}"] = {
                                echo "Updating on ${ip} in namespace ${namespace}..."
                                withCredentials([usernamePassword(credentialsId: 'ssh', passwordVariable: 'ssh_pass', usernameVariable: 'ssh_user')]) {
                                    def currentImage = sh(script: """
                                        sshpass -p "\$ssh_pass" ssh -o StrictHostKeyChecking=no "\$ssh_user@${ip}" "kubectl get deployment ${service} -n ${namespace} -o=jsonpath={..image}"
                                    """, returnStdout: true).trim()

                                    if (currentImage.contains("oasissys/${service}:${params.VERSION}")) {
                                        echo "Deployment already using image: oasissys/${service}:${params.VERSION}. Skipping update."
                                    } else {
                                        sh """
                                            docker save oasissys/${service}:${params.VERSION} | sshpass -p "\$ssh_pass" ssh -o StrictHostKeyChecking=no "\$ssh_user@${ip}" 'cat > /tmp/${service}.tar && \
                                            docker load -i /tmp/${service}.tar && \
                                            kubectl set image deployment/${service} ${service}=oasissys/${service}:${params.VERSION} -n ${namespace} && \
                                            rm -f /tmp/${service}.tar'
                                        """
                                    }
                                }
                            }
                        } else {
                            echo "Skipping empty IP entry."
                        }
                    }
                    parallel updateStages
                }
            }
        }
    }

    post {
        success {
            echo "Update completed successfully."
        }
        failure {
            echo "Update failed."
        }
    }
}
