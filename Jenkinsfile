pipeline {
    agent any
    stages {
        stage('Prepare') {
            steps {
                script {
                    // Read the properties file
                    def propsContent = readFile 'sites.properties'
                    def propsMap = [:]
                    
                    // Parse the properties into a map
                    propsContent.split('\n').each { line ->
                        def (key, value) = line.split('=')
                        propsMap[key.trim()] = value.trim()
                    }
                    
                    // Set the SITE environment variable
                    env.SITE = propsMap.SITE
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
