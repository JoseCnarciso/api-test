package com.mentorama.javapro.api.test.apitest.services;

import com.mentorama.javapro.api.test.apitest.exceptions.OutOfStockException;
import com.mentorama.javapro.api.test.apitest.models.Product;
import com.mentorama.javapro.api.test.apitest.models.SalesFinalPrice;
import com.mentorama.javapro.api.test.apitest.models.SalesOrder;
import com.mentorama.javapro.api.test.apitest.repositories.IProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.mentorama.javapro.api.test.apitest.exceptions.Constants.*;

@Service
@Log4j2
public class ProductService {

    @Autowired
    IProductRepository iProductRepository;

    public Product addProduct(Product product){
      return iProductRepository.save(product);
    }


    public Product findById( Integer id ) {
        return iProductRepository.findAllById(id);
    }

    public List<Product> findAll() {
        return iProductRepository.findAll();
    }

    public void delete( Integer id ) {
        iProductRepository.deleteById(id);
    }

    public void setFinalDiscount( SalesOrder salesOrder ) {
        Product productStock = findById(salesOrder.getId());
        if (salesOrder.getDiscount() > productStock.getMaxDiscount()) ;
    }

    public SalesFinalPrice sellProducts( SalesOrder salesFinalPrice) throws OutOfStockException {
        setFinalDiscount(salesFinalPrice);
        setQuanityProduct(salesFinalPrice);
        Double finalPrice = finalPrice(salesFinalPrice);

       SalesFinalPrice salesFinalPrice1 = new SalesFinalPrice();
        salesFinalPrice1.setFinalPrice(finalPrice);
        return salesFinalPrice1;

    }

    public void setQuanityProduct( SalesOrder salesOrder ) throws OutOfStockException {
        Product quantityStock = findById(salesOrder.getId());

        if (quantityStock.getQuantity().equals(0)) {
            log.error(PRODUCT_OUT_OF_STOCK_MESSAGE);
            throw new OutOfStockException(PRODUCT_OUT_OF_STOCK_MESSAGE);
        }

        if (salesOrder.getQuantity() > quantityStock.getQuantity()) {
            salesOrder.setQuantity(quantityStock.getQuantity());
        }
        quantityStock.setQuantity(quantityStock.getQuantity() - salesOrder.getQuantity());
    }

    public Double finalPrice( SalesOrder salesOrder ) {

        Product quantityStock = findById(salesOrder.getId());
        return salesOrder.getQuantity() * (quantityStock.getPrice() - (quantityStock.getPrice()
                * salesOrder.getDiscount()));
    }


}
