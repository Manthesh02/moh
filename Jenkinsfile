@Library('moh') _

pipeline {
    agent any
    parameters moh()
    stages {
        stage('Parameter Check') {
            steps {
                script {
                    // Log the selected parameters
                    echo "Selected Sites: ${params.SITE}"
                    echo "Selected Services: ${params.SERVICE}"
                    echo "Version: ${params.VERSION}"
                }
            }
        }
    }
}
