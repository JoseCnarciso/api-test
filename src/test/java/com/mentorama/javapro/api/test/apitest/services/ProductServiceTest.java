package com.mentorama.javapro.api.test.apitest.services;

import com.mentorama.javapro.api.test.apitest.dtos.ProductDTO;
import com.mentorama.javapro.api.test.apitest.models.Product;
import com.mentorama.javapro.api.test.apitest.repositories.IProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class ProductServiceTest {

    public static final Integer ID = 12;
    public static final String PRODUCT_NAME = "Machado de combate";
    public static final int QUANTITY = 3;
    public static final double MAX_DISCOUNT = 20.0;
    public static final double PRICE = 350.0;
    @InjectMocks
    private ProductService service;

    @Mock
    private IProductRepository repository;


    Product product;
    private ProductDTO dto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startProduct();
    }


    @Test
    void saveProduct() {
    }

    @Test
    void findById() {
        when(repository.findById(anyInt())).thenReturn(Optional.ofNullable(product));
        Product response = service.findById(ID);

        assertNotNull(response);
        assertEquals(product.getId(),response.getId());
        assertEquals(ID,response.getId());
        assertEquals(PRODUCT_NAME, response.getProductName());
        assertEquals(QUANTITY,response.getQuantity());
        assertEquals(PRICE,response.getPrice());
        assertEquals(MAX_DISCOUNT,response.getMaxDiscount());

    }

    @Test
    void findAll() {
    }

    @Test
    void delete() {
    }


    private void startProduct() {
        product = new Product(ID, PRODUCT_NAME, QUANTITY, MAX_DISCOUNT, PRICE);
        dto = new ProductDTO(ID, PRODUCT_NAME, QUANTITY, PRICE);
    }


}