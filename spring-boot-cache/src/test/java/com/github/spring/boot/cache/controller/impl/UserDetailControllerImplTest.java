package com.github.spring.boot.cache.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.spring.boot.cache.pojo.dto.UserCreateDTO;
import com.github.spring.boot.cache.pojo.entity.UserDetailDO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
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
 * create in 2021/2/7 6:36 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@AutoConfigureMockMvc
@ActiveProfiles("junit")
@SpringBootTest
class UserDetailControllerImplTest {

    @Resource
    private MockMvc mockMvc;

    @Resource
    private ObjectMapper objectMapper;

    @DisplayName("按照条件查找用户")
    @Test
    void listUsers() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("200"))
                .andReturn()
                .getResponse()
                .getContentAsString();
    }

    @DisplayName("创建一个用户")
    @Test
    void create() throws Exception {
        String name = "name1";
        String phone = "phone1";
        int age = 11;
        UserCreateDTO user = UserCreateDTO.builder().name(name).phone(phone).age(age).build();
        mockMvc.perform(MockMvcRequestBuilders.post("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.name").value(name))
                .andReturn()
                .getResponse()
                .getContentAsString();

    }

    @DisplayName("更新一个用户")
    @Test
    void update() throws Exception {
        long id = 1;
        String name = "name1";
        String phone = "phone1";
        int age = 11;
        UserDetailDO user = UserDetailDO.builder().id(id).name(name).phone(phone).age(age).build();
        mockMvc.perform(MockMvcRequestBuilders.put("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.name").value(name))
                .andReturn()
                .getResponse()
                .getContentAsString();
    }

    @DisplayName("删除一个用户")
    @Test
    void delete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/user/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
    }

    @DisplayName("删除所有用户")
    @Test
    void deleteAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/users/all")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
    }
}