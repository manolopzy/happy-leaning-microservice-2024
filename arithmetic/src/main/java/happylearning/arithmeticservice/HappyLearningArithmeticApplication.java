package happylearning.arithmeticservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class HappyLearningArithmeticApplication {

	public static void main(String[] args) {
		SpringApplication.run(HappyLearningArithmeticApplication.class, args);
	}

}
