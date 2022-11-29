package com.mentorama.javapro.api.test.apitest.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class ProductDTO {

    private Integer id;
    private String productName;
    private Integer quantity;
    private Double price;




}
