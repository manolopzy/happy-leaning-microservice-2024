pipeline {
    agent any
    stages {
        stage('Clone') {
            git 'https://github.com/manolopzy/happy-leaning-microservice-2024.git'
        }
        stage('Build') {
            sh 'mvn clean package'
        }
        stage('Test') {
            sh 'mvn test'
        }
        stage('Package') {
            sh 'mvn package'
        }
        stage('Deploy') {
            // Replace with your deployment script
            // For example, to deploy to Docker:
            // sh 'docker compose build'
        	// sh 'docker tag spring-boot-app:<version> <your-docker-hub-username>/spring-boot-app:<version>'
        	// sh 'docker push <your-docker-hub-username>/spring-boot-app:<version>'
            sh 'docker compose build'
        }
    }
}