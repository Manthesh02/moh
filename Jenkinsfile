@Library('moh') _  // Load the shared library

pipeline {
    agent any
    stages {
        stage('Define Parameters') {
            steps {
                script {
                    // Call the shared parameters
                    def paramsDef = moh()

                    // Set parameters dynamically
                    properties([
                        parameters(paramsDef)
                    ])
                }
            }
        }
        stage('Display Selected Parameters') {
            steps {
                script {
                    // Join selected values for display
                    def selectedSites = params.SITES.join(', ')
                    def selectedServices = params.SERVICES.join(', ')

                    echo "Selected Sites: ${selectedSites}"
                    echo "Selected Services: ${selectedServices}"
                    echo "Version: ${params.VERSION}"
                }
            }
        }
    }
}
