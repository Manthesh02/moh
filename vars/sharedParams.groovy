def call() {
    return [
        string(name: 'SERVICE', defaultValue: 'example-service', description: 'Select the Service'),
        string(name: 'VERSION', defaultValue: '1.0.0', description: 'Specify the Version to deploy'),
        booleanParam(name: 'RUN_TESTS', defaultValue: false, description: 'Run Tests?')
    ]
}
