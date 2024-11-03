pipeline {
    agent any
    stages {
        stage('Prepare') {
            steps {
                script {
                    // Attempt to read the properties file
                    try {
                        def propsFile = readFile('/path/in/container/sites.properties')
                        echo "Properties File Content: ${propsFile}" // Print the entire content

                        // Extract the SITE variable
                        def siteLine = propsFile.split('\n').find { it.startsWith('SITE=') }
                        if (siteLine) {
                            env.SITE = siteLine.split('=', 2)[1].trim()
                        } else {
                            error "SITE not found in properties file."
                        }
                        echo "Loaded SITE: ${env.SITE}"
                    } catch (Exception e) {
                        error "Error reading properties file: ${e.message}"
                    }
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
