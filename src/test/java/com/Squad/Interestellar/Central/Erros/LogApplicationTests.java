package com.Squad.Interestellar.Central.Erros;

import com.Squad.Interestellar.Central.Erros.dto.UserDTO;
import com.Squad.Interestellar.Central.Erros.entity.User;
import com.Squad.Interestellar.Central.Erros.service.impl.EventLogService;
import com.Squad.Interestellar.Central.Erros.service.impl.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.web.JsonPath;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.common.util.JacksonJsonParser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static com.Squad.Interestellar.Central.Erros.UserApllicationTests.asJsonString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LogApplicationTests {

		@Autowired
		private MockMvc mockMvc;


		@Test
		public void verifyWithAuthTokenExists() throws Exception {
				final User usuario = new User();
				usuario.setName("Pedro");
				usuario.setLogin("juninhoo@gmail.com");
				usuario.setPassword("0251984");
				mockMvc.perform(
												MockMvcRequestBuilders.post("/users")
																				.contentType(MediaType.APPLICATION_JSON)
																				.content(asJsonString(usuario)));
				final String token = obtainAccessToken(usuario.getLogin(), usuario.getPassword());
				Assert.assertNotNull(token);
		}

		@Test
		public void acessWithoutToken() throws Exception {
				mockMvc.perform(
												MockMvcRequestBuilders.get("/loggers")).andExpect(status().isUnauthorized());
		}


		private String obtainAccessToken(final String username, final String password) throws Exception {
				final MultiValueMap<String, String> params = new LinkedMultiValueMap();
				params.add("grant_type", "password");
				params.add("username", username);
				params.add("password", password);
				final ResultActions result = this.mockMvc.perform(MockMvcRequestBuilders.post("/oauth/token").
												params(params).with(SecurityMockMvcRequestPostProcessors.httpBasic("client_id", "client_secret")).
												accept("application/json;charset=UTF-8")).andExpect(MockMvcResultMatchers.status().isOk()).
												andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"));
				final String resultString = result.andReturn().getResponse().getContentAsString();
				final JacksonJsonParser jsonParser = new JacksonJsonParser();
				return jsonParser.parseMap(resultString).get("access_token").toString();
		}
}


