package com.mentorama.javapro.api.test.apitest.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDTO {

    private Integer id;
    private String productName;
    private Integer quantity;
    private Double price;

    private boolean permiteCadastrarMesmaDescricao;



}
