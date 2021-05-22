package com.Squad.Interestellar.Central.Erros;

import org.springframework.security.oauth2.common.util.JacksonJsonParser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class AcessTokenMethod {
 public static String obtainAccessToken(final String username, final String password, final MockMvc mockMvc) throws Exception {
	final MultiValueMap<String, String> params = new LinkedMultiValueMap();
	params.add("grant_type", "password");
	params.add("username", username);
	params.add("password", password);
	final ResultActions result = mockMvc
			.perform(MockMvcRequestBuilders.post("/oauth/token").params(params)
					.with(SecurityMockMvcRequestPostProcessors.httpBasic("client_id", "client_secret"))
					.accept("application/json;charset=UTF-8"))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"));
	final String resultString = result.andReturn().getResponse().getContentAsString();
	final JacksonJsonParser jsonParser = new JacksonJsonParser();
	return jsonParser.parseMap(resultString).get("access_token").toString();
 }
}
