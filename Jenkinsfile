pipeline {
    agent { label 'windows_slave' }
    stages {
        stage('Maven Packaging') {
            steps {
                echo 'Packaging the source code...'
                bat 'mvn clean package -DskipTests'
                echo 'Packaged the source code successfully...'
            }
        }
        stage('SonarQube Analysis') {
            steps {
                echo 'Static code analysis using sonarqube...'
                withSonarQubeEnv('sonarqube') {
                  bat 'mvn clean compile sonar:sonar -Dsonar.projectKey=master-java-framework -Dsonar.test.inclusions=**/*test*/**'
                }
                echo 'Source code analyzed successfully...'
            }
        }
        stage('Test Execution') {
            steps {
                echo 'Executing the sanity test cases...'
                bat 'mvn test -Dbrowser=chrome'
                echo 'Test execution completed successfully...'
            }
        }
    }
}