package com.mentorama.javapro.api.test.apitest.services;

import com.mentorama.javapro.api.test.apitest.models.Product;

import com.mentorama.javapro.api.test.apitest.repositories.IProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


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
        return iProductRepository.findById(id).get();
    }

    public List<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Transactional
    public void delete( Integer id ) {
        iProductRepository.deleteById(id);
    }



}
