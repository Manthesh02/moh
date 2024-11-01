@Library('moh') _  // Use the correct shared library name

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
                    '''return ${moh.fetchParams().sites}''',
                    true
                )
            ]
        )
        activeChoice(
            name: 'SERVICE',
            description: 'Select the Service',
            choiceType: 'PT_CHECKBOX',
            script: [
                $class: 'org.biouno.unochoice.model.GroovyScript',
                script: new org.jenkinsci.plugins.scriptsecurity.sandbox.groovy.SecureGroovyScript(
                    '''return ${moh.fetchParams().services}''',
                    true
                )
            ]
        )
        string(
            name: 'VERSION',
            defaultValue: moh.fetchParams().version,
            description: 'Specify the Version to deploy'
        )
    }

    stages {
        stage('Display Parameters') {
            steps {
                script {
                    echo "Selected Sites: ${params.SITE}"
                    echo "Selected Services: ${params.SERVICE}"
                    echo "Version: ${params.VERSION}"
                }
            }
        }

        stage('Pull Docker Image') {
            steps {
                script {
                    def services = params.SERVICE.tokenize(',')
                    services.each { service ->
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

        stage('Copy and Update') {
            steps {
                script {
                    def sites = params.SITE.tokenize(',')
                    def updateStages = [:]
                    for (site in sites) {
                        site = site.trim()
                        if (site) {
                            def (namespace, ip) = site.split(':')
                            updateStages["Update on ${ip}"] = {
                                echo "Updating on ${ip} in namespace ${namespace}..."
                                withCredentials([usernamePassword(credentialsId: 'your-ssh-credentials-id', passwordVariable: 'ssh_pass', usernameVariable: 'ssh_user')]) {
                                    sh """
                                        docker save oasissys/${params.SERVICE}:${params.VERSION} | sshpass -p "\$ssh_pass" ssh -o StrictHostKeyChecking=no "\$ssh_user@${ip}" 'cat > /tmp/${params.SERVICE}.tar && \
                                        docker load -i /tmp/${params.SERVICE}.tar && \
                                        kubectl set image deployment/${params.SERVICE} ${params.SERVICE}=oasissys/${params.SERVICE}:${params.VERSION} -n ${namespace} && \
                                        rm -f /tmp/${params.SERVICE}.tar'
                                    """
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
