package com.mentorama.javapro.api.test.apitest.repositories;

import com.mentorama.javapro.api.test.apitest.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product,Integer> {


}
