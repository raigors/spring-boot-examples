package com.github.spring.boot.jackson.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 * TODO
 * <p>
 * create in 2021/5/13 4:45 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@SpringBootTest
@AutoConfigureMockMvc
class JsonPropertyControllerTest {


    @Resource
    private MockMvc mockMvc;

    @Test
    void getJsonProperty() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/property")
                .contentType(MediaType.APPLICATION_JSON)
                .content(getData2()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.subName").value("test_name"))
                .andExpect(jsonPath("$.note").value("meta data"))
                .andExpect(jsonPath("$.pass").value("test_pass2"))
                .andReturn()
                .getResponse()
                .getContentAsString();
    }

    private String getData2() {
        return "{\"subName\":\"test_name\",\"note\":\"meta data\",\"pass2\": \"test_pass2\"}";
    }

}