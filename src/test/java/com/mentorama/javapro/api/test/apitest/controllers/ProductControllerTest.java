package com.mentorama.javapro.api.test.apitest.controllers;


import com.mentorama.javapro.api.test.apitest.repositories.IProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
;


@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    private IProductRepository repository;

    @Autowired
    private MockMvc mockMvc;







//    @Test
//    public void shouldAddNewProduct() throws Exception {
//        String requestBody = "{\"id\":\"10\",\"productName\":Monitor,\"maxDiscount\":2,\"quantity\":5,\"price\":1500.00}";
//
//
//        mockMvc.perform(MockMvcRequestBuilders
//                        .post("/product")
//                        .content(requestBody)
//                        .contentType("application/json"))
//                .andExpect(status().isCreated());
//    }
}
