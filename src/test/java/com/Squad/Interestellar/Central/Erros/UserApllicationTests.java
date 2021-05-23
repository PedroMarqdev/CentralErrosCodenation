package com.Squad.Interestellar.Central.Erros;

import com.Squad.Interestellar.Central.Erros.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserApllicationTests {

 @Autowired
 private MockMvc mockMvc;

 static String asJsonString(final Object obj) {
	try {
	 ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
	 LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.now(), ZoneOffset.UTC);
	 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
	 String formatedHour = localDateTime.format(formatter);
	 String json = ow.writeValueAsString(obj);
	 String dateJson = '"' + "date" + '"' + " : null";
	 String newDateJson = '"' + "date" + '"' + " : " + '"' + formatedHour + '"';
	 json = json.replace(dateJson, newDateJson);
	 return json;
	} catch (final Exception e) {
	 throw new RuntimeException(e);
	}
 }

 @Test
 public void tryRegisterWithoutLogin() throws Exception {
	final User usuario = new User();
	usuario.setPassword("12345");
	usuario.setName("pedro");
	mockMvc.perform(MockMvcRequestBuilders.post("/users")
			.contentType(MediaType.APPLICATION_JSON)
			.content(asJsonString(usuario)))
			.andExpect(status().isBadRequest());
 }

 @Test
 public void tryRegisterWithoutPasssword() throws Exception {
	final User usuario = new User();
	usuario.setLogin("juninho@gmail.com");
	usuario.setName("pedro");
	mockMvc.perform(MockMvcRequestBuilders.post("/users")
			.contentType(MediaType.APPLICATION_JSON)
			.content(asJsonString(usuario)))
			.andExpect(status().isBadRequest());
 }

 @Test
 public void tryRegisterWithoutName() throws Exception {
	final User usuario = new User();
	usuario.setLogin("juninho@gmail.com");
	usuario.setPassword("0251984");
	mockMvc.perform(MockMvcRequestBuilders
			.post("/users")
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
	mockMvc.perform(MockMvcRequestBuilders.post("/users")
			.contentType(MediaType.APPLICATION_JSON)
			.content(asJsonString(usuario)));
 }
}

