
package happylearning.arithmeticservice;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

import happylearning.arithmeticservice.entity.ArithmeticAttempt;
import happylearning.arithmeticservice.repository.ArithmeticAttemptRepository;
import happylearning.arithmeticservice.service.ArithmeticService;

/**
 * @author [Manolo Peng]
 * Aug 27, 2024
 */
@SpringBootTest
@ConditionalOnProperty("test.run.integration") //The class will only be loaded by Spring when property test.run.integration is defined and not false.
@Profile("integrationtest") //The class will only be loaded by Spring when profile integrationtest is active.

public class ServiceTests {
	
	@Autowired
	private ArithmeticService service;
	@Autowired
	private ArithmeticAttemptRepository repository;
	/**
	 * This method must be static
	 * It runs before all other tests and corresponds to @BeforeClass in Junit4
	 */
	@BeforeAll
    public static void setUp(){
		
    }
	
	@Test
	void getArithmeticAttempts() {
		Iterable<ArithmeticAttempt> arithmeticAttempts = service.getArithmeticAttempts("manolo");
		assertThat(service.getArithmeticAttempts("manolo")).isNotEmpty();
		assertThat(arithmeticAttempts).hasSizeGreaterThan(1);
	}
}


