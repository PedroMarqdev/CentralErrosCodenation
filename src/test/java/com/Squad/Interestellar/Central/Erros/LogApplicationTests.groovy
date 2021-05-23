package com.Squad.Interestellar.Central.Erros

import br.com.six2six.fixturefactory.Fixture
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader
import com.Squad.Interestellar.Central.Erros.entity.EventLog
import com.Squad.Interestellar.Central.Erros.service.impl.EventLogService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.security.oauth2.common.util.JacksonJsonParser
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.ResultActions
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
import spock.lang.Specification
import static com.Squad.Interestellar.Central.Erros.UserApllicationTests.asJsonString
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class LogApplicationTests extends Specification{

    private String token

    private EventLogService eventLogService

    @Autowired
    private MockMvc mockMvc

    def setupSpec() {
        FixtureFactoryLoader.loadTemplates("fixtures")
    }
    def setup() {
        String auth = obtainAccessToken("alguem@email.com", "12345")
        token = auth
    }

    def "Given a successful log with authorization, should return OK"() {
        given: "A successful log"
        EventLog eventLog = Fixture.from(EventLog).gimme("log-valid")
        when: "Do a post req to endpoint"
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/loggers").header("Authorization", "Bearer " + token)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(eventLog))).andReturn()
        then: "Get a OK Status"
        result.getResponse().getStatus().toString() == "201"
    }
    def "Given a successful log with authorization without level, should return BAD REQUEST"() {
        given: "A log without level"
        String withoutLevelJson = '{"description": "dados corrompidos", "source": "192.168.0.101", "quantity": 3, "eventLog":"asa", "date": "27-04-2020 12:30"}'
        when: "Do a post req to endpoint"
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/loggers").header("Authorization", "Bearer " + token)
                .contentType(MediaType.APPLICATION_JSON)
                .content(withoutLevelJson)).andReturn()
        then: "Get a BAD REQUEST Status"
        result.getResponse().getStatus().toString() == "400"
    }
    def "Given a successful log with authorization without description, should return BAD REQUEST"() {
        given: "A log without description"
        EventLog eventLog = Fixture.from(EventLog).gimme("log-without-description")
        when: "Do a post req to endpoint"
            MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/loggers").header("Authorization", "Bearer " + token)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(asJsonString(eventLog))).andReturn()
        then: "Get a BAD REQUEST Status"
        result.getResponse().getStatus().toString() == "400"
    }
    def "Given a successful log with authorization without eventLog, should return BAD REQUEST"() {
        given: "A log without eventLog"
        EventLog eventLog = Fixture.from(EventLog).gimme("log-without-eventLog")
        when: "Do a post req to endpoint"
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/loggers").header("Authorization", "Bearer " + token)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(eventLog))).andReturn()
        then: "Get a BAD REQUEST Status"
        result.getResponse().getStatus().toString() == "400"
    }
    def "Given a successful log with authorization without source, should return BAD REQUEST"() {
        given: "A log without source"
        EventLog eventLog = Fixture.from(EventLog).gimme("log-without-source")
        when: "Do a post req to endpoint"
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/loggers").header("Authorization", "Bearer " + token)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(eventLog))).andReturn()
        then: "Get a BAD REQUEST Status"
        result.getResponse().getStatus().toString() == "400"
    }
    def "Given a successful log with authorization without quantity, should return BAD REQUEST"() {
        given: "A log whithout quantity"
        EventLog eventLog = Fixture.from(EventLog).gimme("log-without-quantity")
        when: "Do a post req to endpoint"
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/loggers").header("Authorization", "Bearer " + token)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(eventLog))).andReturn()
        then: "Get a BAD REQUEST Status"
        result.getResponse().getStatus().toString() == "400"
    }
    def "Given a successful log with authorization without date, should return BAD REQUEST"() {
        given: "A log without Date"
        String withoutDateJson = '{"level": "ERROR", "description": "dados corrompidos", "source": "192.168.0.101", "quantity": 3, "eventLog":"asa"}'
        when: "Do a post req to endpoint"
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/loggers").header("Authorization", "Bearer " + token)
                .contentType(MediaType.APPLICATION_JSON)
                .content(withoutDateJson)).andReturn()
        then: "Get a BAD REQUEST Status"
        result.getResponse().getStatus().toString() == "400"
    }

    String obtainAccessToken(final String username, final String password) throws Exception {
        final MultiValueMap<String, String> params = new LinkedMultiValueMap()
        params.add("grant_type", "password")
        params.add("username", username)
        params.add("password", password)
        final ResultActions result = mockMvc
                .perform(MockMvcRequestBuilders.post("/oauth/token").params(params)
                        .with(SecurityMockMvcRequestPostProcessors.httpBasic("client_id", "client_secret"))
                        .accept("application/json;charset=UTF-8"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
        final String resultString = result.andReturn().getResponse().getContentAsString()
        final JacksonJsonParser jsonParser = new JacksonJsonParser()
        return jsonParser.parseMap(resultString).get("access_token").toString()
    }
}
