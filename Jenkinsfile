@Library('moh') _

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
                    '''return new groovy.util.Eval().getSiteMappings()''',
                    true
                )
            ]
        )
        choice(
            name: 'SERVICE',
            description: 'Select the Service',
            choices: getServiceChoices()
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

                    // Pull the image only once
                    echo "Pulling image: oasissys/${service}:${params.VERSION}"
                    sh "docker pull oasissys/${service}:${params.VERSION}"
                    def imageCheck = sh(script: "docker images -q oasissys/${service}:${params.VERSION}", returnStdout: true).trim()
                    if (!imageCheck) {
                        error "Image oasissys/${service}:${params.VERSION} not found."
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

// Define a function to get service choices
def getServiceChoices() {
    return moh.getServiceList() // Call your shared library method here
}
