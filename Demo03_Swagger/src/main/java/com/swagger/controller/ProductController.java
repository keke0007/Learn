package com.swagger.controller;

import com.swagger.common.Result;
import com.swagger.common.StatusCode;
import com.swagger.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ Author：ke
 * @ Date： 2019/8/25 15:18
 * @ Version 1.0
 */
@Api(value = "ProductController",description = "商品模块接口")
@RestController
@RequestMapping(value = "product")
public class ProductController {
    /*查询所有商品*/
    @Autowired
    private ProductService productService;

    @ApiOperation(value = "查询所有商品",notes = "查询所有商品")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "响应成功"),
            @ApiResponse(code = 401,message = "请求要求用户的身份认证"),
            @ApiResponse(code = 403,message = "没有权限访问本网站")})
    @RequestMapping(value = "findAll", method = RequestMethod.GET,produces = "application/json")
    public Result findAll() {

        return new Result(true, StatusCode.OK, "响应成功", productService.findALl());
    }

    @ApiOperation(value = "根据商品id查询商品", notes = "根据商品id查询商品")
    @RequestMapping(value = "findById/{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable("id") String id) {
        return new Result(true, StatusCode.OK, "查询成功", productService.findById());
    }
}

