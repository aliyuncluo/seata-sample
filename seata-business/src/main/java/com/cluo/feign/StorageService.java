package com.cluo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cluo.dto.CommodityDTO;
import com.cluo.response.ObjectResponse;

@Service
@FeignClient(value="storage-service")
public interface StorageService {

	@PostMapping("/storage/decrease")
	public ObjectResponse decreaseStorage(@RequestBody CommodityDTO commodityDTO);
}
