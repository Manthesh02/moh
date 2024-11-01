@Library('moh') _  // Load the shared library

pipeline {
    agent any

    parameters {
        // Declare parameters directly; call the shared library method in the parameters block
        activeChoice(name: 'SITE', 
                     type: 'PT_CHECKBOX', 
                     description: 'Select the Site (namespace:IP)', 
                     choiceType: 'CHECKBOX', 
                     script: [
                         """return ['Site1', 'Site2', 'Site3']"""
                     ])
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
