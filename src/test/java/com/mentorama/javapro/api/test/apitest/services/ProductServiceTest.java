package com.mentorama.javapro.api.test.apitest.services;

import com.mentorama.javapro.api.test.apitest.TESTANDO.ProductTest;
import com.mentorama.javapro.api.test.apitest.models.Product;
import com.mentorama.javapro.api.test.apitest.models.SalesOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ProductServiceTest {


    @Test
    public void descontoMaximoDado(){

        Product product = new Product(1,"Teclado",0,0.10,100.00);
        SalesOrder salesOrder = new SalesOrder();

        Double result  = salesOrder.getMaxDiscount();
        Assertions.assertEquals(0.15,result);

        Double result2 = product.getMaxDiscount();
        Assertions.assertEquals(0.10,result2);

    }
    @Test
    public void shouldCalculateTotalPriceWhitDiscount(){
        ProductTest newProduct = new ProductTest(1,"Monitor",100.00,0.10);
        Double result = newProduct.getPriceWhitDiscount(0.16);
        Assertions.assertEquals(90.00,result);
    }
}
