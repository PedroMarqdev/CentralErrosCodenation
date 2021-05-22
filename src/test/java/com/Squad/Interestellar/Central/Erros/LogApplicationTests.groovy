package com.Squad.Interestellar.Central.Erros

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import spock.lang.Specification
import static com.Squad.Interestellar.Central.Erros.AcessTokenMethod.obtainAccessToken
import static com.Squad.Interestellar.Central.Erros.UserApllicationTests.asJsonString;
@SpringBootTest
@AutoConfigureMockMvc
class LogApplicationTests extends Specification{

    String authorization
    @Autowired
    MockMvc mockMvc
    def setup() {
        String auth = obtainAccessToken("alguem@email.com", "12345", mockMvc)
        authorization = auth
    }

    def "Given a successful log, should return OK"() {
        given: "post request with successful log"
        mockMvc.perform(MockMvcRequestBuilders.post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(usuario)));
    }
}
