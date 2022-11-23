package com.mentorama.javapro.api.test.apitest.controllers;

import com.mentorama.javapro.api.test.apitest.dtos.ProductDTO;
import com.mentorama.javapro.api.test.apitest.models.Product;
import com.mentorama.javapro.api.test.apitest.services.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity add( @RequestBody Product product ) {

        try {
            productService.addProduct(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Produto adicionado com sucesso.", HttpStatus.CREATED);
    }

    @GetMapping
    public List<Product> findAll() {
        return productService.findAll();
    }

    public void update(@RequestBody final Product product){

    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Product> update( @PathVariable(value = "id")@RequestBody Integer id, ProductDTO productDTO ){
//        Product productS = productService.findById(id);
//        if (productS == null){
//
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//        Product product = new Product();
//        BeanUtils.copyProperties(productDTO, product);
//        product.setId(productS.getId());
//
//        return ResponseEntity.status(HttpStatus.OK).body(productService.addProduct(product));
//    }

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
