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
            defaultValue: moh.fetchVersion(), // Fetch the default version from the library
            description: 'Specify the Test Version'
        )
    }

    stages {
        stage('Display Parameters') {
            steps {
                script {
                    echo "Selected Test Sites: ${params.TEST_SITE?.join(', ') ?: 'None selected'}"
                    echo "Selected Test Services: ${params.TEST_SERVICE?.join(', ') ?: 'None selected'}"
                    echo "Test Version: ${params.TEST_VERSION}"
                }
            }
        }
    }
}
