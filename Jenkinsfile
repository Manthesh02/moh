pipeline {
    agent any
    stages {
        stage('Fetch Namespaces') {
            steps {
                script {
                    // Command to fetch namespaces (replace this with the actual command you need)
                    def namespaces = sh(script: "your-command-to-fetch-namespaces", returnStdout: true).trim()

                    // Save to properties file
                    writeFile file: 'sites.properties', text: "SITE=${namespaces}"
                    echo "Fetched and saved namespaces: ${namespaces}"
                }
            }
        }
        stage('Prepare') {
            steps {
                script {
                    // Load properties from the file
                    def props = readProperties(file: 'sites.properties')
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
