pipeline {
    agent any
    parameters {
        choice(name: 'TEST_PARAM', choices: 'Option1\nOption2\nOption3', description: 'Select an option')
    }
    stages {
        stage('Test Stage') {
            steps {
                script {
                    // Print the selected option
                    echo "Selected Option: ${params.TEST_PARAM}"
                }
            }
        }
    }
}
