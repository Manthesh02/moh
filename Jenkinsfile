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
                    '''return moh.getSiteMappings()''',
                    true
                )
            ]
        )
        activeChoice(
            name: 'SERVICE',
            description: 'Select the Service to update',
            choiceType: 'PT_CHECKBOX',
            script: [
                $class: 'org.biouno.unochoice.model.GroovyScript',
                script: new org.jenkinsci.plugins.scriptsecurity.sandbox.groovy.SecureGroovyScript(
                    '''return moh.getServiceList()''',
                    true
                )
            ]
        )
        string(
            name: 'VERSION',
            defaultValue: '1.0.0',
            description: 'Specify the Version to deploy'
        )
    }

    stages {
        stage('Update Services') {
            steps {
                script {
                    // Get selected sites and services
                    def selectedSites = params.SITE ?: []
                    def selectedServices = params.SERVICE ?: []

                    // Iterate over each selected site
                    selectedSites.each { site ->
                        def (namespace, ip) = site.split(':')
                        echo "Connecting to ${namespace} at ${ip}"

                        // Iterate over each selected service
                        selectedServices.each { service ->
                            echo "Updating ${service} on ${namespace} with version ${params.VERSION}"
                            // Add logic to connect and perform the update, e.g. using SSH
                        }
                    }
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
