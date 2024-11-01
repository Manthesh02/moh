pipeline {
    agent any
    options { skipDefaultCheckout() }
    stages {
        stage('Setup Parameters') {
            steps {
                script {
                    properties([
                        parameters([
                            activeChoiceParam(
                                name: 'SITE',
                                type: 'CHECKBOX',
                                description: 'Select the Site (namespace:IP)',
                                groovyScript: [
                                    script: 'return ["MHHTP:10.5.43.89", "LGHJP:10.5.43.93", "RGHPJ:10.5.43.94"]'
                                ]
                            ),
                            activeChoiceParam(
                                name: 'SERVICE',
                                type: 'CHECKBOX',
                                description: 'Select the Service',
                                groovyScript: [
                                    script: 'return ["word-report", "dataset-setup", "scm-integration", "nphies-clinical-service", "dataset-processing", "active-mq", "medical-extensions", "release-notes-service", "security-service", "message-broker", "email-service", "word-documents", "oasis-app-service"]'
                                ]
                            ),
                            string(name: 'VERSION', defaultValue: '1.0.0', description: 'Specify the Version to deploy')
                        ])
                    ])
                }
            }
        }
        stage('Parameter Check') {
            steps {
                script {
                    echo "Selected Sites: ${params.SITE}"
                    echo "Selected Services: ${params.SERVICE}"
                    echo "Version: ${params.VERSION}"
                }
            }
        }
        stage('Update Service') {
            steps {
                script {
                    def sites = params.SITE.split(',')
                    def services = params.SERVICE.split(',')
                    sites.each { site ->
                        def siteDetails = site.split(':')
                        def namespace = siteDetails[0]
                        def ip = siteDetails[1]

                        services.each { service ->
                            println "Connecting to site with namespace: ${namespace} and IP: ${ip}"
                            println "Updating service: ${service} to version: ${params.VERSION}"

                            sh """
                                sshpass -p '${credentials('ssh-credentials').password}' ssh -o StrictHostKeyChecking=no ${credentials('ssh-credentials').username}@${ip} "
                                namespace=${namespace} &&
                                docker pull oasissys/${service}:${params.VERSION} &&
                                kubectl set image deployment/${service} ${service}=oasissys/${service}:${params.VERSION} -n ${namespace}
                            """
                        }
                    }
                }
            }
        }
    }
}
