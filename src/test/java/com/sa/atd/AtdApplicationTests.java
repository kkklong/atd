package com.sa.atd;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sa.atd.model.entity.UserInfo;
import net.minidev.json.JSONUtil;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.WebApplicationContext;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
class AtdApplicationTests {

    @Test
    void contextLoads() {
    }
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;

    UserInfo userInfo;
    @Before("")
    public void setup(){
        //01 mockMvc = MockMvcBuilders.standaloneSetup(new HelloWorldController()).build();
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testAttendance() throws Exception {

//        this.mockMvc.perform(post("/atd/clockin")).andDo(print())
//                .andExpect(status().isOk()).andExpect((ResultMatcher) content()
//                        .contentType("application/json;charset=UTF-8"))
//                .andExpect((ResultMatcher) jsonPath("$.uid").value(1000));

//        this.mockMvc.perform(post("/atd/clockin").content("{\"uid\":1000}")).andDo(print())
//                .andExpect(status().isOk()).andExpect((ResultMatcher) content()
//                        .contentType("application/json;charset=UTF-8"));
//                .andExpect((ResultMatcher) jsonPath("$.uid").value(1000));
        this.mockMvc.perform(post("/atd/clockin", 1)
                .param("uid", String.valueOf(1000L))).andDo(print()).andExpect(status().isOk());
    }
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
