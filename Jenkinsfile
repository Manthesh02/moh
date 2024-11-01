@Library('moh') _  // Make sure the library name matches

pipeline {
    agent any

    parameters {
        // Load the Active Choice parameter from the moh shared library
        moh()
        string(name: 'VERSION', defaultValue: '1.0.0', description: 'Specify the Version to deploy')
    }

    stages {
        stage('Display Selected Site') {
            steps {
                script {
                    echo "Selected Site: ${params.SITE}" // Access the Active Choice parameter
                    echo "Version: ${params.VERSION}"
                }
            }
        }
    }
}
