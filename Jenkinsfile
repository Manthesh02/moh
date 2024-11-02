@Library('moh') _ // Load the shared library

pipeline {
    agent any

    parameters {
        activeChoice(
            name: 'TEST_SITE',
            description: 'Select the Test Site',
            choiceType: 'PT_CHECKBOX',
            script: [
                $class: 'org.biouno.unochoice.model.GroovyScript',
                script: new org.jenkinsci.plugins.scriptsecurity.sandbox.groovy.SecureGroovyScript(
                    '''return moh.fetchSites()''',
                    true
                )
            ]
        )
        activeChoice(
            name: 'TEST_SERVICE',
            description: 'Select the Test Service',
            choiceType: 'PT_CHECKBOX',
            script: [
                $class: 'org.biouno.unochoice.model.GroovyScript',
                script: new org.jenkinsci.plugins.scriptsecurity.sandbox.groovy.SecureGroovyScript(
                    '''return moh.fetchServices()''',
                    true
                )
            ]
        )
        string(
            name: 'TEST_VERSION',
            defaultValue: '', // Initialize as empty, we will set it in a script block
            description: 'Specify the Test Version'
        )
    }

    stages {
        stage('Initialize') {
            steps {
                script {
                    // Fetch the default version from the library and set it as an environment variable
                    env.TEST_VERSION = moh.fetchVersion()
                }
            }
        }

        stage('Display Parameters') {
            steps {
                script {
                    echo "Selected Test Sites: ${params.TEST_SITE?.join(', ') ?: 'None selected'}"
                    echo "Selected Test Services: ${params.TEST_SERVICE?.join(', ') ?: 'None selected'}"
                    echo "Test Version: ${env.TEST_VERSION}"
                }
            }
        }
    }
}
