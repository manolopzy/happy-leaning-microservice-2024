
package happylearning.configserver;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * @author [Manolo Peng]
 * Aug 26, 2024
 */
@SpringBootTest
@AutoConfigureMockMvc
public class ConfigServerTest {

	@Autowired
    private MockMvc mockMvc;

    @Test
    public void getsAllRides() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/happy-learning-gateway/dev").with(httpBasic("user", "111111"))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }
}


