pipeline {
    agent any
    stages {
        stage('Check the software versions') {
            steps {
                echo 'Checking all the software versions installed in the jenkins master'
                sh 'java --version'
                sh 'mvn --version'
                sh 'git --version'
                sh 'docker version'
            }
        }
    }
}