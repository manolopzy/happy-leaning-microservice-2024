
package happylearning.arithmeticservice;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import happylearning.arithmeticservice.entity.ArithmeticAttempt;
import happylearning.arithmeticservice.repository.ArithmeticAttemptRepository;
import happylearning.arithmeticservice.service.ArithmeticService;

/**
 * @author [Manolo Peng]
 * Aug 27, 2024
 */
@SpringBootTest
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


