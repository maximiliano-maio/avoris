package com.example.exercise.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.util.List;

import com.example.exercise.entities.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
public class ProductControllerIntegTests {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void whenGetProductsByCategory_thenReturnListProducts() throws Exception {
       MvcResult result = mockMvc.perform(get("/api/{category}", "sport").secure(true)).andReturn();
       List<Product> products = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<List<Product>>(){});
       assertThat(products).hasSize(2);
    }

    @Test
    public void whenSaveProduct_thenReturnInt1() throws Exception {
        Product product = new Product(11L,"testProduct","test", "small", 10, "USD", "red");
        byte[] content = objectMapper.writeValueAsBytes(product);
        MvcResult result = mockMvc
            .perform(post("/admin/save")
            .contentType(MediaType.APPLICATION_JSON)
            .content(content)
            .secure(true))
                .andReturn();
        int status = Integer.parseInt( result.getResponse().getContentAsString() );
        assertThat(status).isEqualTo(1);
    }

    
}