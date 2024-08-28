package happylearning.arithmeticservice;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Profile;

import happylearning.arithmeticservice.entity.ArithmeticOperation;
import happylearning.arithmeticservice.service.ArithmeticService;
import happylearning.arithmeticservice.service.RandomGeneratorService;
/**
 * This class must be create inside the test package, 
 * otherwise, the above import commands will not be 
 * resolved.
 * 
 * Control+Shift+O to auto import the needed classes
 * @author tanku
 *
 */
//@RunWith(SpringRunner.class)
@SpringBootTest
@ConditionalOnProperty("test.run.integration") //The class will only be loaded by Spring when property test.run.integration is defined and not false.
@Profile("integrationtest") //The class will only be loaded by Spring when profile integrationtest is active.

public class MultiplicationServiceTest {
	/**
	 * The @MockBean annotation tells Spring to inject a 
	 * mock of the RandomGeneratorService bean, instead of 
	 * searching for a suitable implementation of the 
	 * interface (which doesn’t exist yet).
	 * BDD Behavior driven development
	 * TDD Test driven development
	 */
	@MockBean
	private RandomGeneratorService randomGeneratorService;
	@Autowired
	private ArithmeticService arithmeticService;
	static String[] operators = {"+", "-", "×", "÷"};
	@Test
	public void createRandomMultiplicationTest() {
		// given (our mocked Random Generator service 
		//will return first 50, then 30)
		given(randomGeneratorService.randomMultiplicationFactor()).
		willReturn(50, 30);
		String operator = operators[new Random().nextInt(0, operators.length)];
		operator = "×";
		// when
		ArithmeticOperation operation = arithmeticService.createRandomExpression(operator);
		// then
		assertThat(operation.getFactorA()).isEqualTo(50);
		assertThat(operation.getFactorB()).isEqualTo(30);
		//assertThat(multiplication.getResult()).isEqualTo(1500);
	}
}
