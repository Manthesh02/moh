@Library('moh') _

pipeline {
    agent any
    parameters {
        activeChoiceParam(
            name: 'TEST_PARAM',
            type: 'CHECKBOX',
            description: 'Select an option',
            groovyScript: [
                script: 'return ["Option1", "Option2", "Option3"]'
            ]
        )
    }
    stages {
        stage('Parameter Check') {
            steps {
                script {
                    // Log the selected parameter
                    echo "Selected Option: ${params.TEST_PARAM}"
                }
            }
        }
    }
}
