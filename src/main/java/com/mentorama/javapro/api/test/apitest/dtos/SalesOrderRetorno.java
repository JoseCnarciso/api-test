package com.mentorama.javapro.api.test.apitest.dtos;

import com.mentorama.javapro.api.test.apitest.models.SalesOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SalesOrderRetorno {

    private SalesOrder salesOrder;
    private int totalDeitens;
    private double totalDeDescontos;

}
