@Library('moh') _

pipeline {
    agent any
    parameters moh()
    stages {
        stage('Test Stage') {
            steps {
                script {
                    // Print the selected options
                    echo "Selected Sites: ${params.SITE}"
                    echo "Selected Services: ${params.SERVICE}"
                    echo "Version: ${params.VERSION}"
                }
            }
        }
    }
}
