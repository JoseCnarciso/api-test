package com.mentorama.javapro.api.test.apitest.repositories;

import com.mentorama.javapro.api.test.apitest.models.Product;
import com.mentorama.javapro.api.test.apitest.models.SalesOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISaleOrderRepository extends JpaRepository<SalesOrder,Integer> {

    //Product findAllById( Integer id );
}
