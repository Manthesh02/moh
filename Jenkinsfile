pipeline {
    agent any

    parameters {
        activeChoice(name: 'SITE', 
                     description: 'Select the Site', 
                     choiceType: 'PT_SINGLE_SELECT', 
                     script: [
                         $class: 'GroovyScript',
                         script: '''
                             return ["Site1", "Site2", "Site3"]
                         ''',
                         fallbackScript: '''
                             return ["No Site Available"]
                         '''
                     ])
    }

    stages {
        stage('Display Selected Site') {
            steps {
                script {
                    echo "Selected Site: ${params.SITE}" // Access the parameter
                }
            }
        }
    }
}
