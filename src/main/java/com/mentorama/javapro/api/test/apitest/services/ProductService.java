package com.mentorama.javapro.api.test.apitest.services;

import com.mentorama.javapro.api.test.apitest.dtos.ProductDTO;
import com.mentorama.javapro.api.test.apitest.exceptions.ProductNotFoundException;
import com.mentorama.javapro.api.test.apitest.models.Product;

import com.mentorama.javapro.api.test.apitest.repositories.IProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Log4j2
public class ProductService {

    @Autowired
    IProductRepository iProductRepository;

    @Transactional
    public Product saveProduct( Product product){
      return iProductRepository.save(product);
    }

    public Product findById( Integer id ) {

        Optional<Product> product = iProductRepository.findById(id);
        return product.orElseThrow(()-> new ProductNotFoundException("Produto não encontrado"));

    }

    public List<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Transactional
    public Product update( Product product){
        return iProductRepository.save(product);
    }

    @Transactional
    public void delete( Integer id ) {
        iProductRepository.deleteById(id);
    }
}
