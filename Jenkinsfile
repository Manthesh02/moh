pipeline {
    agent any

    stages {
        stage('Prepare') {
            steps {
                script {
                    // Defining the active choice parameter within a script block
                    def sites = new ActiveChoicesParameter(
                        name: 'SITE',
                        type: 'PT_CHECKBOX',
                        description: 'Select the Site (namespace:IP)',
                        choiceType: 'CHECKBOX',
                        script: [
                            'return ["Site1", "Site2", "Site3"]'
                        ]
                    )
                    
                    // Using the parameter in your pipeline
                    echo "Selected Site: ${params.SITE}" // Access the Active Choice parameter
                }
            }
        }
    }
}
