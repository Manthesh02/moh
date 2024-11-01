@Library('moh') _

pipeline {
    agent any

    parameters {
        choice(name: 'SERVICE', choices: ['service1', 'service2', 'service3'], description: 'Select a service')
        string(name: 'VERSION', defaultValue: '1.0.0', description: 'Specify the version to deploy')
        booleanParam(name: 'RUN_TESTS', defaultValue: true, description: 'Run tests after deployment')
    }

    stages {
        stage('Parameter Check') {
            steps {
                script {
                    echo "Selected Service: ${params.SERVICE}"
                    echo "Version: ${params.VERSION}"
                    echo "Run Tests: ${params.RUN_TESTS}"
                }
            }
        }
    }
}
