package com.Squad.Interestellar.Central.Erros;

import com.Squad.Interestellar.Central.Erros.controller.UserController;
import com.Squad.Interestellar.Central.Erros.entity.User;
import com.Squad.Interestellar.Central.Erros.service.impl.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserApllicationTests {

		@Autowired
		private MockMvc mockMvc;


@Test
		public void tryRegisterWithoutLogin() throws Exception {
						final User usuario = new User();
						usuario.setPassword("12345");
						usuario.setName("pedro");
				mockMvc.perform(
												MockMvcRequestBuilders.post("/users")
																				.contentType(MediaType.APPLICATION_JSON)
																				.content(asJsonString(usuario)))
												.andExpect(status().isBadRequest());
				}
		@Test
		public void tryRegisterWithoutPasssword() throws Exception {
				final User usuario = new User();
				usuario.setLogin("juninho@gmail.com");
				usuario.setName("pedro");
			mockMvc.perform(
												MockMvcRequestBuilders.post("/users")
																				.contentType(MediaType.APPLICATION_JSON)
																				.content(asJsonString(usuario)))
												.andExpect(status().isBadRequest());

		}
		@Test
		public void tryRegisterWithoutName() throws Exception {
				final User usuario = new User();
				usuario.setLogin("juninho@gmail.com");
				usuario.setPassword("0251984");
				mockMvc.perform(
												MockMvcRequestBuilders.post("/users")
																				.contentType(MediaType.APPLICATION_JSON)
																				.content(asJsonString(usuario)))
												.andExpect(status().isBadRequest());

		}
		@Test
		public void tryRegisterSucessfullUser() throws Exception {
				final User usuario = new User();
				usuario.setName("Pedro");
				usuario.setLogin("juninho@gmail.com");
				usuario.setPassword("0251984");
				mockMvc.perform(
												MockMvcRequestBuilders.post("/users")
																				.contentType(MediaType.APPLICATION_JSON)
																				.content(asJsonString(usuario)));
		}



		public static String asJsonString(final Object obj) {
				try {
						return new ObjectMapper().writeValueAsString(obj);
				} catch (final Exception e) {
						throw new RuntimeException(e);
				}
		}
}

