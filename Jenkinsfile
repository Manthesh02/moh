pipeline {
    agent any
    stages {
        stage('Prepare') {
            steps {
                script {
                    // Load properties from the file
                    def props = readProperties(file: 'sites.properties')
                    // Fetch the SITE variable from properties
                    def siteList = props.SITE?.tokenize(',')?.collect { it.trim() } ?: ['No Sites Available']
                    // Save it to an environment variable
                    env.SITE_VALUES = siteList.join(',') // Join them back into a string for convenience
                    echo "Loaded SITE_VALUES: ${env.SITE_VALUES}" // Debugging line
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
                    // This Groovy script retrieves the environment variable and splits it into a list
                    return (env.SITE_VALUES ? env.SITE_VALUES.tokenize(',') : ['No Sites Available']).collect { it.trim() }
                    ''',
                    true
                )
            ],
            choiceType: 'PT_CHECKBOX' // Change to checkboxes if needed
        )
    }
}
