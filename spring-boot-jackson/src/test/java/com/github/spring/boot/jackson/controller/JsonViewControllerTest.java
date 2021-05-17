package com.github.spring.boot.jackson.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * TODO
 * <p>
 * create in 2021/5/13 4:58 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@SpringBootTest
@AutoConfigureMockMvc
class JsonViewControllerTest {

    @Resource
    private MockMvc mockMvc;

    @Test
    void getSimple() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/simple"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.simple").value("Message:Simple"))
                .andExpect(jsonPath("$.detail").doesNotExist())
                .andReturn()
                .getResponse()
                .getContentAsString();
    }

    @Test
    void getDetail() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/detail"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.simple").value("Message:Simple"))
                .andExpect(jsonPath("$.detail").value("Message:Detail"))
                .andReturn()
                .getResponse()
                .getContentAsString();
    }
}