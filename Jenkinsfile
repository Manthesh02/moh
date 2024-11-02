@Library('moh') _

def sharedParams = moh.fetchParams()

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
            defaultValue: sharedParams.version,
            description: 'Specify the Version to deploy'
        )
    }

    stages {
        stage('Display Parameters') {
            steps {
                script {
                    echo "Selected Sites: ${params.SITE.join(', ')}"
                    echo "Selected Services: ${params.SERVICE.join(', ')}"
                    echo "Version: ${params.VERSION}"
                }
            }
        }
        // Additional stages can be added here...
    }
}
