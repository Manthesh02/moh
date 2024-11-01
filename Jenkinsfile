pipeline {
    agent any

    stages {
        stage('Parameters') {
            steps {
                script {
                    properties([
                        parameters([
                            [
                                $class: 'CascadeChoiceParameter',
                                name: 'SITE',
                                description: 'Select the Site',
                                choiceType: 'PT_SINGLE_SELECT',
                                script: [
                                    $class: 'GroovyScript',
                                    script: 'return ["Site1", "Site2", "Site3"]'
                                ]
                            ]
                        ])
                    ])
                }
            }
        }
        stage('Display Selected Site') {
            steps {
                script {
                    echo "Selected Site: ${params.SITE}" // Access the parameter
                }
            }
        }
    }
}
