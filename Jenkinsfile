@Library('moh') _

pipeline {
    agent any
    parameters {
        choice(name: 'TEST_PARAM', choices: 'Option1\nOption2\nOption3', description: 'Select an option')
    }
    stages {
        stage('Test Stage') {
            steps {
                script {
                    // Print the selected options
                    echo "Selected Option: ${params.TEST_PARAM}"
                }
            }
        }
    }
}
