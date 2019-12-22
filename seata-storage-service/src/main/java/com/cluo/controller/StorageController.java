package com.cluo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cluo.dto.CommodityDTO;
import com.cluo.response.ObjectResponse;
import com.cluo.service.StorageService;

@RestController
@RequestMapping("/storage")
public class StorageController {
	
    @Autowired
	private StorageService storageService;
	
    @PostMapping("/decrease")
	public ObjectResponse decreaseStorage(@RequestBody CommodityDTO commodityDTO) {
		ObjectResponse<Object> response = ObjectResponse.newInstance();
		response.setData(storageService.StorageMapper(commodityDTO));
		return response;
	}
}
