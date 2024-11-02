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
                    'return moh.fetchSites()',
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
                    'return moh.fetchServices()',
                    true
                )
            ]
        )
        string(
            name: 'VERSION',
            defaultValue: '1.0.0', // You can set a static default or leave it blank
            description: 'Specify the Version to deploy'
        )
    }

    stages {
        stage('Initialize') {
            steps {
                script {
                    // Fetch the default version from the library
                    def defaultVersion = moh.fetchVersion()
                    echo "Default Version: ${defaultVersion}"
                }
            }
        }
        
        stage('Display Parameters') {
            steps {
                script {
                    echo "Selected Sites: ${params.SITE?.join(', ') ?: 'None selected'}"
                    echo "Selected Services: ${params.SERVICE?.join(', ') ?: 'None selected'}"
                    echo "Version: ${params.VERSION}"
                }
            }
        }
    }
    
    post {
        success {
            echo "Build completed successfully."
        }
        failure {
            echo "Build failed."
        }
    }
}
