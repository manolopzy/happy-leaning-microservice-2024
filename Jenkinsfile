//Any commands listed here can be run locally to verify their correctness
pipeline {
    agent any
    stages {
        stage('Clone') {
			//Even there is only one step, it must be surrounded by "steps" in a newer version of Jenkins
			steps {
				git 'https://github.com/manolopzy/happy-leaning-microservice-2024.git'
			}
        }
        stage('Build') {
			steps {
				//sh 'mvn clean package'
				//sh is for linux shell, bat is for Windows known as batch command file
				bat 'mvn clean install -Dmaven.test.skip=true'
			}
        }
        stage('Test') {
			steps {
				bat 'mvn test'
			}
        }
        //stage('Package') {
            //steps {
			//	sh 'mvn package'
			//}
        //}
        
        
        //stage('Build and Push Docker Images') {
	      //steps {
			//"spring-boot-app1" is the service name defined in your docker-compose file
	        //sh 'docker compose build spring-boot-app1'
	        //sh 'docker tag spring-boot-app1:<version> <your-docker-hub-username>/spring-boot-app1:<version>'
	        //sh 'docker push <your-docker-hub-username>/spring-boot-app1:<version>'
	
	        //sh 'docker compose build spring-boot-app2'
	        //sh 'docker tag spring-boot-app2:<version> <your-docker-hub-username>/spring-boot-app2:<version>'
	        //sh 'docker push <your-docker-hub-username>/spring-boot-app2:<version>'
	      //}
    	//}
    	
    	stage('Deploy') {
            // Replace with your deployment script
            // For example, to deploy to Docker:
            // sh 'docker compose build'
        	// sh 'docker tag spring-boot-app:<version> <your-docker-hub-username>/spring-boot-app:<version>'
        	// sh 'docker push <your-docker-hub-username>/spring-boot-app:<version>'
        	steps {
				 bat 'docker compose build'
			}
        }
    }
}