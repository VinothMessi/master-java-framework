pipeline {
    agent any
    stages {
        stage('Maven Packaging') {
            steps {
                echo 'Packaging the source code...'
                sh 'mvn clean package -DskipTests'
                echo 'Packaged the source code successfully...'
            }
        }
        stage('SonarQube Analysis') {
            steps {
                echo 'Static code analysis using sonarqube...'
                withSonarQubeEnv('sonarqube') {
                  sh 'mvn clean compile sonar:sonar -Dsonar.projectKey=master-java-framework -Dsonar.test.inclusions=**/*test*/**'
                }
                echo 'Source code analyzed successfully...'
            }
        }
    }
}