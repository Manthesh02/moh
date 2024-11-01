// vars/moh.groovy
def call() {
    return [
        choice(name: 'TEST_PARAM', choices: 'Option1\nOption2\nOption3', description: 'Select an option')
    ]
}
