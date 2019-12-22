package com.cluo.dao;

import org.apache.ibatis.annotations.Mapper;

import com.cluo.dto.OrderDTO;

@Mapper
public interface OrderInfoMapper {

	int createOrder(OrderDTO orderDTO);
}
