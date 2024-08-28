package happylearning.arithmeticservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

@SpringBootTest
@ConditionalOnProperty("test.run.integration") //The class will only be loaded by Spring when property test.run.integration is defined and not false.
@Profile("integrationtest") //The class will only be loaded by Spring when profile integrationtest is active.

class ArithmeticApplicationTests {

	@Test
	void contextLoads() {
	}

}
