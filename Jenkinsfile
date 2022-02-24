pipeline {
    agent any
    stages {
        stage('Check the software versions') {
            steps {
                echo 'Checking all the software versions installed in jenkins master'
                sh 'java --version'
                sh 'mvn --version'
                sh 'git --version'
                sh 'docker version'
                echo 'Checked all the software versions in jenkins master'
            }
        }
    }
}