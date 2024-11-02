@Library('moh') _ 

pipeline {
    agent any

    parameters {
        activeChoiceParam(
            name: 'SITE',
            description: 'Select the Site (namespace:IP)',
            type: 'CHECKBOX',
            groovyScript: [
                script: '''return Moh.fetchSites()''',
                fallbackScript: 'return ["No sites available"]'
            ]
        )
        activeChoiceParam(
            name: 'SERVICE',
            description: 'Select the Service',
            type: 'CHECKBOX',
            groovyScript: [
                script: '''return Moh.fetchServices()''',
                fallbackScript: 'return ["No services available"]'
            ]
        )
        string(
            name: 'VERSION',
            defaultValue: '1.0.0',
            description: 'Specify the Version to deploy'
        )
    }

    stages {
        stage('Display Parameters') {
            steps {
                script {
                    echo "Selected Sites: ${params.SITE?.join(', ') ?: 'None selected'}"
                    echo "Selected Services: ${params.SERVICE?.join(', ') ?: 'None selected'}"
                    echo "Version: ${params.VERSION}"
                }
            }
        }

        stage('Pull Docker Image') {
            steps {
                script {
                    def services = params.SERVICE?.tokenize(',') ?: []
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
                    def sites = params.SITE?.tokenize(',') ?: []
                    def updateStages = [:]
                    for (site in sites) {
                        site = site.trim()
                        if (site) {
                            def (namespace, ip) = site.split(':')
                            updateStages["Update on ${ip}"] = {
                                echo "Updating on ${ip} in namespace ${namespace}..."
                                def services = params.SERVICE.tokenize(',')
                                services.each { service ->
                                    withCredentials([usernamePassword(credentialsId: 'your-ssh-credentials-id', passwordVariable: 'ssh_pass', usernameVariable: 'ssh_user')]) {
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
