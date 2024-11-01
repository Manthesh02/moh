def call() {
    return [
        activeChoice(
            name: 'SITES', 
            description: 'Select the Sites (multiple selections allowed)', 
            script: ''' 
                return ["MHHTP:10.5.43.89", "LGHJP:10.5.43.93", "RGHPJ:10.5.43.94"]
            '''
        ),
        activeChoice(
            name: 'SERVICES', 
            description: 'Select the Services (multiple selections allowed)', 
            script: ''' 
                return ["word-report", "dataset-setup", "scm-integration"]
            '''
        ),
        string(
            name: 'VERSION', 
            defaultValue: '1.0.0', 
            description: 'Specify the Version to deploy'
        )
    ]
}
