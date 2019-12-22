package com.cluo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cluo.dao.OrderInfoMapper;
import com.cluo.dto.OrderDTO;

@Service
public class OrderInfoServiceImpl implements OrderInfoService{
    
	@Autowired
	private OrderInfoMapper orderMapper;
    
	@Override
	public int createOrder(OrderDTO orderDTO) {
		return orderMapper.createOrder(orderDTO);
	}

}
