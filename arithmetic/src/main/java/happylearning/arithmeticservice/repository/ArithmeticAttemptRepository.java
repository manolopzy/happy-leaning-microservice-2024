package happylearning.arithmeticservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import happylearning.arithmeticservice.entity.ArithmeticAttempt;
/**
 * In order to use Querydsl for mongo database, the following 
 * dependencies and plugin need to be added to maven pom file
 * 
 * <groupId>com.querydsl</groupId>
 * <artifactId>querydsl-mongodb</artifactId>
 * <groupId>com.querydsl</groupId>
 * <artifactId>querydsl-apt</artifactId>
 * plugin:
 * org.springframework.data.mongodb.repository.support.MongoAnnotationProcessor
 * @author tanku
 *
 */
public interface ArithmeticAttemptRepository extends MongoRepository<ArithmeticAttempt, String>, QuerydslPredicateExecutor<ArithmeticAttempt>{
	public ArithmeticAttempt findByUserAlias(String alias);
	
	public List<ArithmeticAttempt> findByCorrect(boolean correct);
	
	//public List<ArithmeticAttempt> findByCreatedAtStartingWith(String regexp);
	
	
	
}
