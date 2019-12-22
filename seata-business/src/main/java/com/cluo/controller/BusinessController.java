package com.cluo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cluo.dto.BusinessDTO;
import com.cluo.response.ObjectResponse;
import com.cluo.service.BusinessService;

@RestController
public class BusinessController {

	private static final Logger LOGGER = LoggerFactory.getLogger(BusinessController.class);


    @Autowired
    private BusinessService businessService;

    /**
     * 模拟用户购买商品下单业务逻辑流程
     * @Param:
     * @Return:
     */
    @PostMapping("/buy")
    ObjectResponse handleBusiness(@RequestBody BusinessDTO businessDTO){
        LOGGER.info("请求参数：{}",businessDTO.toString());
        return businessService.handleBusiness(businessDTO);
    }
}
