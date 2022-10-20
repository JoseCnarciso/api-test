package com.mentorama.javapro.api.test.apitest.controllers;

import com.mentorama.javapro.api.test.apitest.exceptions.OutOfStockException;
import com.mentorama.javapro.api.test.apitest.models.Product;
import com.mentorama.javapro.api.test.apitest.models.SalesFinalPrice;
import com.mentorama.javapro.api.test.apitest.models.SalesOrder;
import com.mentorama.javapro.api.test.apitest.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product>findAll(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findById( @PathVariable("id")Integer id ){
        return productService.findById(id);
    }
    @PostMapping
    public ResponseEntity add( @RequestBody Product product  ){
        try {
            productService.addProduct(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Produto adicionado com sucesso.", HttpStatus.CREATED);
    }

    @PostMapping("/sell")
    public SalesFinalPrice sellProducts ( @RequestBody SalesOrder salesOrder) throws OutOfStockException {
        return productService.sellProducts(salesOrder);
    }


}
