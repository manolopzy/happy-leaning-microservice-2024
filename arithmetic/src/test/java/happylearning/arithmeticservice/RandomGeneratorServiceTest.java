package happylearning.arithmeticservice;



import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import happylearning.arithmeticservice.service.RandomGeneratorService;
import happylearning.arithmeticservice.service.impl.RandomGeneratorServiceImpl;
/**

@InjectMocks
private SomeManager someManager;

// Create the mock object and set its behavior
@Mock
private SomeDependency dependency;

// Initialize the mock object and inject it into SomeManager
MockitoAnnotations.initMocks(this);

// Test SomeManager with the injected mock object

In summary, @Mock creates a mock object, while @InjectMocks injects the mock object into a test class, allowing you to test the class’s behavior with controlled dependencies.
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest

public class RandomGeneratorServiceTest {

	private RandomGeneratorServiceImpl randomGeneratorService = new RandomGeneratorServiceImpl();
	
	@Test
	public void generateRandomFactorIsBetweenExpectedLimits() {
		// when a good sample of randomly generated factors is generated
		List<Integer> randomFactors = IntStream.range(0, 1000)
		.map(i -> randomGeneratorService.
				randomMultiplicationFactor())
		.boxed().collect(Collectors.toList());
		// then all of them should be between 11 and 100
		// because we want a middle-complexity calculation
		assertThat(randomFactors).isSubsetOf(IntStream.range(RandomGeneratorServiceImpl.MINIMUM_FACTOR, RandomGeneratorServiceImpl.MAXIMUM_FACTOR + 1).boxed().collect(Collectors.toList()).toArray(new Integer[0]));
	}
}
