package com.mentorama.javapro.api.test.apitest.services;

import com.mentorama.javapro.api.test.apitest.dtos.ProductDTO;
import com.mentorama.javapro.api.test.apitest.exceptions.ProductNotFoundException;
import com.mentorama.javapro.api.test.apitest.models.Product;
import com.mentorama.javapro.api.test.apitest.repositories.IProductRepository;
import org.hibernate.ObjectNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
    void cadastrandoProduto() {

        when(repository.save(any())).thenReturn(product);

        Product response = service.saveProduct(product);

        assertNotNull(response);
        assertEquals(Product.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(PRODUCT_NAME, response.getProductName());
        assertEquals(QUANTITY, response.getQuantity());
        assertEquals(PRICE, response.getPrice());
        assertEquals(MAX_DISCOUNT, response.getMaxDiscount());
    }
    @Test
    void cadastrandoProdutoComErroException() {

        when(repository.findById(anyInt())).thenReturn(Optional.ofNullable(product));


       try {
           Optional.ofNullable(product).get().setId(1);
           service.saveProduct(product);
       }catch (Exception ex){
           assertEquals(DataIntegrityViolationException.class,ex.getClass());
       }
    }

    @Test
    void procurandoPorID() {
        when(repository.findById(anyInt())).thenReturn(Optional.ofNullable(product));
        Product response = service.findById(ID);

        assertNotNull(response);
        assertEquals(product.getId(), response.getId());
        assertEquals(ID, response.getId());
        assertEquals(PRODUCT_NAME, response.getProductName());
        assertEquals(QUANTITY, response.getQuantity());
        assertEquals(PRICE, response.getPrice());
        assertEquals(MAX_DISCOUNT, response.getMaxDiscount());
    }


    @Test
    void produtoNaoEncontrado() {
        when(repository.findById(anyInt())).thenThrow(new ProductNotFoundException("Produto não encontrado"));
        try {
            service.findById(ID);
        } catch (Exception e) {
            assertEquals(ProductNotFoundException.class, e.getClass());
            assertEquals("Produto não encontrado", e.getMessage());
        }
    }

    @Test
    void listandoTodosProdutosCadastrados() {
        when(repository.findAll()).thenReturn(List.of(product));
        List<Product> response = service.findAll();
        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(Product.class, response.get(0).getClass());

        assertEquals(ID, response.get(0).getId());
        assertEquals(PRODUCT_NAME, response.get(0).getProductName());
        assertEquals(QUANTITY, response.get(0).getQuantity());
        assertEquals(PRICE, response.get(0).getPrice());
        assertEquals(MAX_DISCOUNT, response.get(0).getMaxDiscount());
    }

    @Test
    void delete() {
    }


    private void startProduct() {
        product = new Product(ID, PRODUCT_NAME, QUANTITY, MAX_DISCOUNT, PRICE);
        dto = new ProductDTO(ID, PRODUCT_NAME, QUANTITY, PRICE);

    }


}