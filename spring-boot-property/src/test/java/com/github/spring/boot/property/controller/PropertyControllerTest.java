package com.github.spring.boot.property.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * TODO
 * <p>
 * create in 2021/4/20 11:25 上午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@ActiveProfiles("junit")
@AutoConfigureMockMvc
@SpringBootTest
class PropertyControllerTest {

    @Resource
    private MockMvc mockMvc;

    @Test
    void getMap() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/map"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.aaa").value("111-test"))
                .andReturn()
                .getResponse()
                .getContentAsString();
    }

    @Test
    void getList() {
    }

    @Test
    void getConfigProperty() {
    }
}