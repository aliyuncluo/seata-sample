package com.cluo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cluo.dto.OrderDTO;
import com.cluo.response.ObjectResponse;

@Service
@FeignClient(value="order-service")
public interface OrderService {

	@PostMapping("/order/create")
	public ObjectResponse createOrder(@RequestBody OrderDTO orderDTO);
}
