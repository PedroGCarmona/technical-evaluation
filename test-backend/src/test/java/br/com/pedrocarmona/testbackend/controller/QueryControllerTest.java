package br.com.pedrocarmona.testbackend.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class QueryControllerTest {
    
    @Autowired
    MockMvc mockMvc;

    @Test
    public void shouldReturn200OK() throws Exception{
        String searchParam = "";
        mockMvc.perform(MockMvcRequestBuilders.get("/").param("searchParam", searchParam)).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void shouldReturn400BadRequest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

}
