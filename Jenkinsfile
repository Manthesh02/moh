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
                    'return moh.fetchParams().sites',  // Removed extra quotes
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
                    'return moh.fetchParams().services',  // Removed extra quotes
                    true
                )
            ]
        )
        string(
            name: 'VERSION',
            defaultValue: moh.fetchParams().version,
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
