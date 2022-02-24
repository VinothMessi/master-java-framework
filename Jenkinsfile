pipeline {
    agent any
    stages {
        stage('Check the software versions') {
            steps {
                sh 'java --version'
                sh 'mvn --version'
                sh 'docker version'
            }
        }
    }
}