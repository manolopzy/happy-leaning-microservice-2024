package happylearning.arithmeticservice;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import happylearning.arithmeticservice.entity.ArithmeticAttempt;
import happylearning.arithmeticservice.entity.QArithmeticAttempt;
import happylearning.arithmeticservice.repository.ArithmeticAttemptRepository;

@SpringBootTest
@ConditionalOnProperty("test.run.integration") //The class will only be loaded by Spring when property test.run.integration is defined and not false.
@Profile("integrationtest") //The class will only be loaded by Spring when profile integrationtest is active.

//@RunWith(SpringRunner.class)
public class ArithmeticAttemptRepositoryTest {

	@Autowired
	private ArithmeticAttemptRepository attemptsRepository;
	
	@Test
	public void readFirstPageTest() {
		//load the first page, no less than fifteen records
		Page<ArithmeticAttempt> attempts = 
				attemptsRepository.findAll(PageRequest.of(0, 15));
		assertThat(attempts.isFirst()).isTrue();
	}
	
	@Test
	public void findByNameTest() {
		QArithmeticAttempt qQuery = new QArithmeticAttempt("arithmeticAttempt");
		Iterable<ArithmeticAttempt> result = attemptsRepository.findAll(qQuery.user.alias.eq("manolopzy"));
		result.forEach(attempt -> {assertThat(attempt.getUser().getAlias()).isEqualTo("manolopzy");});
		
	}
}
