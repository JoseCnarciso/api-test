package com.mentorama.javapro.api.test.apitest.controllers;

import com.mentorama.javapro.api.test.apitest.models.Product;
import com.mentorama.javapro.api.test.apitest.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity add( @RequestBody Product product ) {

        try {
            productService.saveProduct(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Produto adicionado com sucesso.", HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity update( @RequestBody Product product ) {
        try {
            productService.saveProduct(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Produto atualizado com sucesso.", HttpStatus.CREATED);
    }

    @GetMapping
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findById( @PathVariable("id") Integer id ) {
        return productService.findById(id);
    }

    @DeleteMapping("/{id}")
    public String delete( @PathVariable("id") Integer id ) {
        productService.delete(id);
        return "Produto apagado";
    }

}
