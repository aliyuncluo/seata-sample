package com.cluo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cluo.dto.OrderDTO;
import com.cluo.response.ObjectResponse;
import com.cluo.service.OrderInfoService;


@RestController
@RequestMapping("/order")
public class OrderInfoController {
    @Autowired
	private OrderInfoService orderService;
	
	@PostMapping("/create")
	public ObjectResponse createOrder(@RequestBody OrderDTO orderDTO) {
		ObjectResponse<Object> response = ObjectResponse.newInstance();
		response.setData(orderService.createOrder(orderDTO));
		return response;
	}
}
