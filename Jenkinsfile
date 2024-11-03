pipeline {
    agent any
    stages {
        stage('Prepare') {
            steps {
                script {
                    // Load properties from the sites.properties file
                    def props = readProperties file: 'sites.properties'
                    env.SITE = props.SITE
                }
            }
        }
    }
    parameters {
        activeChoice(
            name: 'SITE',
            description: 'Select the Site (namespace:IP)',
            script: [
                $class: 'org.biouno.unochoice.model.GroovyScript',
                script: new org.jenkinsci.plugins.scriptsecurity.sandbox.groovy.SecureGroovyScript(
                    '''
                    return (env.SITE ? env.SITE.tokenize(',') : []).collect { it.trim() }
                    ''',
                    true
                )
            ],
            choiceType: 'PT_CHECKBOX' // Change to checkbox
        )
    }
}
