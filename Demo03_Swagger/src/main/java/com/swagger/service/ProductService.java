package com.swagger.service;

import com.swagger.pojo.Product;

import java.util.List;

/**
 * @ Author：ke
 * @ Date： 2019/8/25 15:16
 * @ Version 1.0
 */

public interface ProductService {
    List<Product> findALl();

    Product findById();
}
