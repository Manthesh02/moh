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
                    '''return ["MHHTP:10.5.43.89", "LGHJP:10.5.43.93"]''', // Static test
                    true
                )
            ]
        )
    }

    stages {
        stage('Display Parameters') {
            steps {
                script {
                    echo "Selected Site: ${params.SITE?.join(', ') ?: 'None selected'}"
                }
            }
        }
    }
}
