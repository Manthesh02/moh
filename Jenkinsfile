@Library('moh') _  // Load the shared library

pipeline {
    agent any
    parameters {
        moh()  // Call the shared parameters defined in moh.groovy
    }
    stages {
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
