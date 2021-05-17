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

/**
 * TODO
 * <p>
 * create in 2021/5/13 4:04 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@SpringBootTest
@AutoConfigureMockMvc
class NgnixConfigControllerTest {

    @Resource
    private MockMvc mockMvc;

    @Test
    void nginxConf()throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/nginx/conf")
                .contentType(MediaType.APPLICATION_JSON)
                .content(getData2()))
                .andDo(print())
                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.startDate").value("2021-05-11"))
//                .andExpect(jsonPath("$.endDate").value("2021-05-12"))
//                .andExpect(jsonPath("$.endDate").value("2021-05-12 00:00:00"))
                .andReturn()
                .getResponse()
                .getContentAsString();
    }

    private String getData2() {
        return "{\"version\":11,\"nginxConf\":\"nginx meta data\"}";
    }

}