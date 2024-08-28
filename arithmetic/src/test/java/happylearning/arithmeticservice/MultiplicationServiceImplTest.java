package happylearning.arithmeticservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import happylearning.arithmeticservice.entity.ArithmeticOperation;
import happylearning.arithmeticservice.service.RandomGeneratorService;
import happylearning.arithmeticservice.service.impl.ArithmeticServiceImpl;

public class MultiplicationServiceImplTest {
	private ArithmeticServiceImpl arithmaticServiceImpl;
	@Mock
	private RandomGeneratorService randomGeneratorService;

	static String operator = "*";
	@BeforeEach
	public void init() {
		// With this call to initialize Mocks
		// and tell Mockito to process the annotations
		MockitoAnnotations.openMocks(this);
		arithmaticServiceImpl = new ArithmeticServiceImpl(randomGeneratorService);
	}

	@Test
	public void createRandomMultiplicationTest() {
		// given (our mocked Random Generator service will return first 50, then 30)
		given(randomGeneratorService.randomMultiplicationFactor()).willReturn(50, 30);

		// when
		ArithmeticOperation operation = arithmaticServiceImpl.createRandomExpression(operator);
		// assert
		assertThat(operation.getFactorA()).isEqualTo(50);
		assertThat(operation.getFactorB()).isEqualTo(30);
		//assertThat(multiplication.getResult()).isEqualTo(1500);
	}

//	@Test
//	public void checkCorrectAttemptTest() {
//		// given
//		ArithmeticOperation operation = new ArithmeticOperation(50, 60, operator);
//		User user = new User();
//		user.setAlias("john_doe");
//		ArithmeticAttempt attempt = new ArithmeticAttempt(user, operation, 3000, false);
//		// when
//		boolean attemptResult = arithmaticServiceImpl.checkAttempt(attempt);
//		// assert
//		assertThat(attemptResult).isTrue();
//	}

//	@Test
//	public void checkWrongAttemptTest() {
//		// given
//		ArithmeticOperation operation = new ArithmeticOperation(50, 60, operator);
//		User user = new User();
//		user.setAlias("john_doe");
//		ArithmeticAttempt attempt = new ArithmeticAttempt(user, operation, 3010, false);
//		// when
//		boolean attemptResult = arithmaticServiceImpl.checkAttempt(attempt);
//		// assert
//		assertThat(attemptResult).isFalse();
//	}
}
