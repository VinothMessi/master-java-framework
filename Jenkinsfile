pipeline {
    agent any
    stages {
        stage('Maven Packaging') {
            steps {
                echo 'Packaging the source code...'
                sh 'mvn clean package'
                echo 'Packaged the source code successfully...'
            }
        }
        stage('SonarQube Analysis') {
            steps {
                echo 'Static code analysis using sonarqube...'
                withSonarQubeEnv('sonarqube') {
                  sh 'mvn sonar:sonar -Dsonar.projectKey=master-java-framework -Dsonar.sources=. -Dsonar.test.inclusions=src/test/java/**'
                }
                echo 'Source code analyzed successfully...'
            }
        }
    }
}