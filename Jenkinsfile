pipeline {
    agent any
    stages {
        stage('Cloning') {
            steps {
                echo 'Cloning GitHub repository...'
                git branch: 'main', url: 'https://github.com/VinothMessi/master-java-framework.git'
                echo 'Repository cloned successfully...'
            }
        }
    }
}