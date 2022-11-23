package com.mentorama.javapro.api.test.apitest.services;

import com.mentorama.javapro.api.test.apitest.exceptions.OutOfStockException;
import com.mentorama.javapro.api.test.apitest.models.Product;
import com.mentorama.javapro.api.test.apitest.models.SalesOrder;
import com.mentorama.javapro.api.test.apitest.models.SalesOrderItem;
import com.mentorama.javapro.api.test.apitest.repositories.IProductRepository;
import com.mentorama.javapro.api.test.apitest.repositories.ISaleOrderRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.transaction.Transactional;

import static com.mentorama.javapro.api.test.apitest.exceptions.Constants.PRODUCT_OUT_OF_STOCK_MESSAGE;

@Log4j2
@Service
@RequestMapping("/salesOrders")

public class SalesOrderSevice {

    @Autowired
    IProductRepository iProductRepository;
    @Autowired
    ISaleOrderRepository iSaleOrderRepository;

    @Transactional
    public SalesOrder sellProducts( SalesOrder salesFinalPrice ) throws OutOfStockException {

        // Faz uma lista para adicionar mais de um item vendido no ped
        for (SalesOrderItem item : salesFinalPrice.getItems()) {
            // valida desconto e quantidade
            setFinalDiscount(item);
            setQuanityProduct(item);

            Double finalPrice = finalPrice(item);
            item.setFinalPrice(finalPrice);
        }
        iSaleOrderRepository.save(salesFinalPrice);

        return salesFinalPrice;
    }

    public void setFinalDiscount( SalesOrderItem salesOrder ) {

        Product productStock = iProductRepository.findById(salesOrder.getProductId()).get();
        salesOrder.setProductName(productStock.getProductName());

        if (salesOrder.getDiscount() > productStock.getMaxDiscount()) {
            salesOrder.setDiscount(productStock.getMaxDiscount());
        }
    }

    public void setQuanityProduct( SalesOrderItem salesOrder ) throws OutOfStockException {
        Product quantityStock = iProductRepository.findById(salesOrder.getProductId()).get();

        if (quantityStock.getQuantity().equals(0)) {
            log.error(PRODUCT_OUT_OF_STOCK_MESSAGE);
            throw new OutOfStockException(PRODUCT_OUT_OF_STOCK_MESSAGE);
        }

        if (salesOrder.getQuantity() > quantityStock.getQuantity()) {
            salesOrder.setQuantity(quantityStock.getQuantity());
        }

        quantityStock.setQuantity(quantityStock.getQuantity() - salesOrder.getQuantity());
        // grava no banco
        iProductRepository.save(quantityStock);
    }

    public Double finalPrice( SalesOrderItem salesOrder ) {

        Product quantityStock = iProductRepository.findById(salesOrder.getProductId()).get();

        double desconto = quantityStock.getPrice() * (salesOrder.getDiscount() / 100);
        double total = (quantityStock.getPrice() - desconto) * salesOrder.getQuantity();
        return total;
    }
}
