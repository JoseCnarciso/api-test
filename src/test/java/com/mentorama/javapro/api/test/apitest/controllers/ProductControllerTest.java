package com.mentorama.javapro.api.test.apitest.controllers;

import com.mentorama.javapro.api.test.apitest.dtos.ProductDTO;
import com.mentorama.javapro.api.test.apitest.models.Product;
import com.mentorama.javapro.api.test.apitest.services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProductControllerTest {

    public static final Integer ID = 12;
    public static final String PRODUCT_NAME = "Machado de combate";
    public static final int QUANTITY = 3;
    public static final double MAX_DISCOUNT = 20.0;
    public static final double PRICE = 350.0;

    Product product;
    ProductDTO dto;

    @InjectMocks
    private ProductController controller;
    @InjectMocks
    private ProductService service;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startProduct();
    }

    @Test
    void add() {
    }

    @Test
    void update() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void delete() {
    }

    private void startProduct() {
        product = new Product(ID, PRODUCT_NAME, QUANTITY, MAX_DISCOUNT, PRICE);
        dto = new ProductDTO(ID, PRODUCT_NAME, QUANTITY, PRICE);
    }
}