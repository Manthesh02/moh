def call() {
    return [
        activeChoice(
            name: 'SITE',
            type: 'PT_CHECKBOX',
            description: 'Select the Site (namespace:IP)',
            choiceType: 'CHECKBOX',
            script: [
                classpath: [],
                fallbackScript: [
                    classpath: [],
                    script: 'return ["MHHTP:10.5.43.89", "LGHJP:10.5.43.93", ...]' // Complete this list as necessary
                ],
                script: 'return ["MHHTP:10.5.43.89", "LGHJP:10.5.43.93", ...]' // Complete this list as necessary
            ]
        ),
        activeChoice(
            name: 'SERVICE',
            type: 'PT_CHECKBOX',
            description: 'Select the Service',
            choiceType: 'CHECKBOX',
            script: [
                classpath: [],
                fallbackScript: [
                    classpath: [],
                    script: 'return ["word-report", "dataset-setup", ...]' // Complete this list as necessary
                ],
                script: 'return ["word-report", "dataset-setup", ...]' // Complete this list as necessary
            ]
        ),
        string(name: 'VERSION', defaultValue: '1.0.0', description: 'Specify the Version to deploy')
    ]
}
