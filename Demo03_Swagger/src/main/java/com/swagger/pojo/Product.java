package com.swagger.pojo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @ Author：ke
 * @ Date： 2019/8/25 15:14
 * @ Version 1.0
 */
@Data
public class Product {
    private String productId;
    private String description;
    private BigDecimal price;
}
