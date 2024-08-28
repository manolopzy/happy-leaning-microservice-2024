package happylearning.arithmeticservice;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import happylearning.arithmeticservice.controller.ArithmeticController;
import happylearning.arithmeticservice.entity.ArithmeticOperation;
import happylearning.arithmeticservice.service.ArithmeticService;

//@RunWith(SpringRunner.class)
//@ExtendWith(SpringExtension.class)
@WebMvcTest(ArithmeticController.class)
@ConditionalOnProperty("test.run.integration") //The class will only be loaded by Spring when property test.run.integration is defined and not false.
@Profile("integrationtest") //The class will only be loaded by Spring when profile integrationtest is active.

public class MultiplicationControllerTest {

	@MockBean
	private ArithmeticService arithmeticService;
	@Autowired
	private MockMvc mvc;
	// This object will be magically initialized by the initFields method below.
	private JacksonTester<ArithmeticOperation> json;

	//@Before used in Junit4
	@BeforeEach
	public void setup() {
		JacksonTester.initFields(this, new ObjectMapper());
	}

	@Test
	public void getRandomMultiplicationTest() throws Exception {
		String operator = "×";
		// given
		given(arithmeticService.createRandomExpression(operator)).willReturn(new ArithmeticOperation(70, 20, operator));
		// when
		MockHttpServletResponse response = mvc.perform(MockMvcRequestBuilders.get("/arithmetic/random").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();
		// then
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
		assertThat(response.getContentAsString()).isEqualTo(json.write(new ArithmeticOperation(70, 20, operator)).getJson());
	}
}
