package com.mentorama.javapro.api.test.apitest.models;

import com.mentorama.javapro.api.test.apitest.models.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ProductTest {


    @Test
    public void descontoMaximoDado(){

        Product product = new Product(1,"Teclado",0,0.10,100.00);

        Double result  = product.getMaxDiscount();
        Assertions.assertEquals(0.1,result);

        Double result2 = product.getMaxDiscount();
        Assertions.assertEquals(0.10,result2);

    }

}
