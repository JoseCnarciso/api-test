package com.mentorama.javapro.api.test.apitest.controllers;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldAddNewProduct() throws Exception {
        String requestBody = "{\"productName\":\"tv\",\"price\":5000.00,\"maxDiscount\":0.2,\"quantity\":5}";

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/products")
                        .content(requestBody)
                        .contentType("application/json"))
                .andExpect(status().isCreated());
    }
}
