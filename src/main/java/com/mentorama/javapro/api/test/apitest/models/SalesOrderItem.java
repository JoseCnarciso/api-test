package com.mentorama.javapro.api.test.apitest.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_SALES_ORDERS_ITEM")
public class SalesOrderItem implements Serializable {
    private static  final Long serialVersionUID= 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer productId;
    private String productName;
    private Integer quantity;
    private Double discount;

    //só para retorno
    private Double finalPrice;

}
