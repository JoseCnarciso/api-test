package com.mentorama.javapro.api.test.apitest.TESTANDO;

import cucumber.api.java.eo.Do;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductTest {
    private int id;
    private String description;
    private Double price;
    private Double maxDiscount;


    public Double getPriceWhitDiscount( Double discount ) {
        if (discount > maxDiscount) {
            return price * (1 - maxDiscount);
        } else {
            return price * (1 - discount);
        }
    }


}
