@Library('moh') _

pipeline {
    agent any
    parameters {
        activeChoiceParam(
            name: 'TEST_PARAM',
            type: 'CHECKBOX',
            description: 'Select the option',
            groovyScript: [
                script: 'return ["Option1", "Option2", "Option3"]'
            ]
        )
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
