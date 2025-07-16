package com.example.springbootfirst.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.greaterThan;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Test
    @WithMockUser(username = "vikas", roles = "USER")
    public void testGetEmployee() throws Exception {
        mockMvc.perform(get("/employee"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", greaterThan(0)));
    }

    @Test
    @WithMockUser(username = "vikas", roles = "USER")
    public void testPostEmployee() throws Exception {
        String employeeJson = "{\"name\":\"Vikas\",\"email\":\"vikas@example.com\",\"password\":\"1234\",\"userName\":\"vikas123\"}";

        mockMvc.perform(post("/employee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(employeeJson))
                .andExpect(status().isOk()) // Expecting status OK (200)
                .andExpect(content().string("Employee added successfully"));
    }
}
