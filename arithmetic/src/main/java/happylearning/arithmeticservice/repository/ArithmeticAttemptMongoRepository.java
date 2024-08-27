
package happylearning.arithmeticservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import happylearning.arithmeticservice.entity.ArithmeticAttempt;

/**
 * @author [Manolo Peng]
 * Aug 27, 2024
 */
public interface ArithmeticAttemptMongoRepository extends MongoRepository<ArithmeticAttempt, String>{

}


