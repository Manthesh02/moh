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
                        // Ignore empty lines or lines that don't contain '='
                        if (line.trim()) {
                            def parts = line.split('=')
                            if (parts.length == 2) { // Ensure there are exactly 2 parts
                                def key = parts[0].trim()
                                def value = parts[1].trim()
                                propsMap[key] = value
                            } else {
                                echo "Skipping invalid line: ${line}"
                            }
                        }
                    }
                    
                    // Set the SITE environment variable
                    env.SITE = propsMap.get('SITE', '')
                    echo "Loaded SITE: ${env.SITE}"
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
            choiceType: 'PT_CHECKBOX'
        )
    }
}
