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
        stage('Print Parameters') {
            steps {
                script {
                    echo "Selected Sites: ${params.SITE?.join(', ') ?: 'None selected'}"
                    echo "Selected Services: ${params.SERVICE?.join(', ') ?: 'None selected'}"
                    echo "Version: ${params.VERSION}"
                }
            }
        }
    }
}
