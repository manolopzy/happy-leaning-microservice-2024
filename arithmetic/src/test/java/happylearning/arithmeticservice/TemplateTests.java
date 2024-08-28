
package happylearning.arithmeticservice;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;

import happylearning.arithmeticservice.entity.ArithmeticAttempt;
import happylearning.arithmeticservice.entity.ArithmeticOperation;
import happylearning.arithmeticservice.entity.User;

/**
 * @author [Manolo Peng] Aug 27, 2024
 * 
 * 
-------Working with mongo template
1 Regular expressions
$regex returns all records suitable for the regex for a specified field
which works similarly to startingWith and endingWith operations.
For example, let's look for all users that have names starting with A.

Query query = new Query();
query.addCriteria(Criteria.where("name").regex("^A"));
List<User> users = mongoTemplate.find(query, User.class);

All users having name ending with "c"
Query query = new Query();
query.addCriteria(Criteria.where("name").regex("c$"));
List<User> users = mongoTemplate.find(query, User.class);
2, less than and greater than
Query query = new Query();
query.addCriteria(Criteria.where("age").lt(40).gt(6));
List<User> users = mongoTemplate.find(query,User.class);

3, sorting
Query query = new Query();
query.with(Sort.by(Sort.Direction.ASC, "level"));
List<User> users = mongoTemplate.find(query,User.class);

4, pageable
Finding the first two pages
final Pageable pageableRequest = PageRequest.of(0, 2);
Query query = new Query();
query.with(pageableRequest);

---------working with mongo repository
1, findByX
List<User> findByName(String name);

2, StartingWith and endingWith
List<User> findByNameStartingWith(String regexp);

List<User> findByNameEndingWith(String regexp);

3, Between
List<User> findByAgeBetween(int ageGT, int ageLT);

4, Like and OrderBy
finding all users whose name contains "M" then ordered by age ...
List<User> users = userRepository.findByNameLikeOrderByAgeAsc("M");

-----------Json document queries
1, using "find by" type of methods
"?0" will be replaced by the parameter passed by
@Query("{ 'name' : ?0 }")
List<User> findUsersByName(String name);
2, using regular expressions
@Query("{ 'name' : { $regex: ?0 } }")
List<User> findUsersByRegexpName(String regexp);
List<User> users = userRepository.findUsersByRegexpName("^A");
List<User> users = userRepository.findUsersByRegexpName("c$");
3, between: greater than and less than 
Method definition
@Query("{ 'age' : { $gt: ?0, $lt: ?1 } }")
List<User> findUsersByAgeBetween(int ageGT, int ageLT);
Example of invocation
List<User> users = userRepository.findUsersByAgeBetween(30, 40);

---------------Q-classes
<dependency>
    <groupId>com.querydsl</groupId>
    <artifactId>querydsl-mongodb</artifactId>
    <version>5.1.0</version>
</dependency>
<dependency>
    <groupId>com.querydsl</groupId>
    <artifactId>querydsl-apt</artifactId>
    <version>5.1.0</version>
</dependency>

<plugin>    
    <groupId>com.mysema.maven</groupId>
    <artifactId>apt-maven-plugin</artifactId>
    <version>1.1.3</version>
    <executions>
        <execution>
            <goals>
                <goal>process</goal>
            </goals>
            <configuration>
                <outputDirectory>target/generated-sources/java</outputDirectory>
                <processor>
                  org.springframework.data.mongodb.repository.support.MongoAnnotationProcessor
                </processor>
            </configuration>
        </execution>
     </executions>
</plugin>

public interface UserRepository extends 
  MongoRepository<User, String>, QuerydslPredicateExecutor<User>
  
QUser qUser = new QUser("user");
Predicate predicate = qUser.name.eq("Eric");
List<User> users = (List<User>) userRepository.findAll(predicate);



GreaterThan	findByAgeGreaterThan(int age)	{"age" : {"$gt" : age}}
LessThan	findByAgeLessThan(int age)	{"age" : {"$lt" : age}}
Between	findByAgeBetween(int from, int to)	{"age" : {"$gt" : from, "$lt" : to}}
IsNotNull, NotNull	findByFirstnameNotNull()	{"age" : {"$ne" : null}}
IsNull, Null	findByFirstnameNull()	{"age" : null}
Like	findByFirstnameLike(String name)	{"age" : age} ( age as regex)
Regex	findByFirstnameRegex(String firstname)	{"firstname" : {"$regex" : firstname }}
(No keyword)	findByFirstname(String name)	{"age" : name}
Not	findByFirstnameNot(String name)	{"age" : {"$ne" : name}}
Near	findByLocationNear(Point point)	{"location" : {"$near" : [x,y]}}
Within	findByLocationWithin(Circle circle)	{"location" : {"$within" : {"$center" : [ [x, y], distance]}}}
Within	findByLocationWithin(Box box)	{"location" : {"$within" : {"$box" : [ [x1, y1], x2, y2]}}}True
IsTrue, True	findByActiveIsTrue()	{"active" : true}
IsFalse, False	findByActiveIsFalse()	{"active" : false}
Exists	findByLocationExists(boolean exists)	{"location" : {"$exists" : exists }}



@BeforeEach and @BeforeAll are the JUnit 5 equivalents of @Before and @BeforeClass in JUnit 4
 */
//@RunWith(SpringRunner.class) used for Junit4
//This annotation already contains @ExtendWith(SpringExtension.class)
@DataMongoTest 
//excluding embedded mongo database in which case you have to configure a real data base
//@DataMongoTest(excludeAutoConfiguration = EmbeddedMongoAutoConfiguration.class)
//For integration test, loading the whole spring context
//@SpringBootTest
//@ExtendWith(SpringExtension.class)

@ConditionalOnProperty("test.run.integration") //The class will only be loaded by Spring when property test.run.integration is defined and not false.
@Profile("integrationtest") //The class will only be loaded by Spring when profile integrationtest is active.
public class TemplateTests {
	@Autowired
	private MongoTemplate mongoTemplate;
	private ArithmeticAttempt attempt1;
	private ArithmeticAttempt attempt2;
    @AfterEach
    void clean() {
    	mongoTemplate.remove(attempt1);
    	mongoTemplate.remove(attempt2);
    }

    @BeforeEach
    void setup() throws Exception {
    	 attempt1 = mongoTemplate.save(new ArithmeticAttempt(new User("123", "manolo"), new ArithmeticOperation(1, 2, "-"), -1, true));
    	 attempt2 = mongoTemplate.save(new ArithmeticAttempt(new User("123", "manolo"), new ArithmeticOperation(1, 3, "-"), -2, true));
    }
	@Test
	public void testFindAll() {
		// Given
		// Initialize your test data

		// When
		// List<MyDocument> documents = mongoTemplate.findAll(MyDocument.class);

		// Then
		// Assert your expected results

		// mongoTemplate.findAll(null)
	}

	@DisplayName("old style documents creation and query through mongo template")
	@Test
	public void test() {
		// given
		DBObject objectToSave = BasicDBObjectBuilder.start().add("name", "Manolo").get();

		// when
		mongoTemplate.save(objectToSave, "testCollection");

		// then
		assertThat(mongoTemplate.findAll(DBObject.class, "testCollection")).extracting("name").containsOnly("Manolo");
	}
	
	@DisplayName("queries with mongo template")
	@Test
	public void testQueies(@Autowired MongoTemplate mongoTemplate) {
		Query query = new Query();
		query.addCriteria(Criteria.where("correct").is(true));
		List<ArithmeticAttempt> attempts = mongoTemplate.find(query, ArithmeticAttempt.class);
		assertThat(attempts).hasSizeGreaterThan(1);
		//assertThat(attempts).hasSizeGreaterThan(2);
		
//		query = new Query();
//		query.addCriteria(Criteria.where("name").regex("c$"));
//		attempts = mongoTemplate.find(query, ArithmeticAttempt.class);
//		
//		query = new Query();
//		query.addCriteria(Criteria.where("age").lt(40).gt(6));
//		attempts = mongoTemplate.find(query,ArithmeticAttempt.class);
//		
//		assertThat(mongoTemplate.findAll(DBObject.class, "testCollection")).extracting("name").containsOnly("Manolo");
	}
	@DisplayName("query using sub document properties")
	@Test
	public void testSubDocumentQueies(@Autowired MongoTemplate mongoTemplate) {
		Query query = new Query();
		query.addCriteria(Criteria.where("user.alias").is("manolo"));
		Iterable<ArithmeticAttempt> result = mongoTemplate.find(query, ArithmeticAttempt.class);
		assertThat(result).hasSizeGreaterThan(1);
//		query = new Query();
//		query.addCriteria(Criteria.where("name").regex("c$"));
//		attempts = mongoTemplate.find(query, ArithmeticAttempt.class);
//		
//		query = new Query();
//		query.addCriteria(Criteria.where("age").lt(40).gt(6));
//		attempts = mongoTemplate.find(query,ArithmeticAttempt.class);
//		
//		assertThat(mongoTemplate.findAll(DBObject.class, "testCollection")).extracting("name").containsOnly("Manolo");
	}
}
