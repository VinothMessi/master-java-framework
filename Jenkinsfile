pipeline {
    agent any
    stages {
        stage('Build the project') {
            steps {
                echo 'Packaging the source code...'
                sh 'mavn clean package'
                echo 'Packaged the source code successfully...'
            }
        }
    }
}