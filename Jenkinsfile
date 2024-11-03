pipeline {
    agent any
    stages {
        stage('Prepare') {
            steps {
                script {
                    // Load properties from the file
                    def propsFile = readFile('sites.properties')
                    def props = [:]
                    propsFile.split('\n').each { line ->
                        def (key, value) = line.split('=')
                        props[key.trim()] = value.trim()
                    }
                    env.SITE = props.SITE // Assuming 'SITE' is the key in your properties file
                    echo "Loaded SITE: ${env.SITE}" // Debugging line
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
            choiceType: 'PT_CHECKBOX' // Change to checkboxes
        )
    }
}
