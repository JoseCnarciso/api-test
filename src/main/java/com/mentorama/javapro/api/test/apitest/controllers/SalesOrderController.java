package com.mentorama.javapro.api.test.apitest.controllers;

import com.mentorama.javapro.api.test.apitest.dtos.SalesOrderRetorno;
import com.mentorama.javapro.api.test.apitest.exceptions.OutOfStockException;
import com.mentorama.javapro.api.test.apitest.models.SalesOrder;
import com.mentorama.javapro.api.test.apitest.services.SalesOrderSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sell")
public class SalesOrderController {

    @Autowired
    private SalesOrderSevice sevice;

    @PostMapping
    public SalesOrderRetorno sellProducts ( @RequestBody SalesOrder salesOrder) throws OutOfStockException {
        SalesOrder order = sevice.sellProducts(salesOrder);

        SalesOrderRetorno retorno = new SalesOrderRetorno();
        retorno.setSalesOrder(order);
        return retorno;
    }
}
