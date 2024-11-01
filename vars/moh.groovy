// vars/moh.groovy
def call() {
    return [
        activeChoiceParam(
            name: 'TEST_PARAM',
            type: 'CHECKBOX',
            description: 'Select the option',
            groovyScript: [
                script: 'return ["Option1", "Option2", "Option3"]'
            ]
        )
    ]
}
