pipeline {
    agent any

    stages {
        stage('Hello World') {
            steps {
                script {
                    // Print "Hello, World!" to the console
                    echo 'Hello, World!'
                }
            }
        }
    }
}