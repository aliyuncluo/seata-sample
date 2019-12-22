package com.cluo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cluo.dao.StorageInfoMapper;
import com.cluo.dto.CommodityDTO;

@Service
public class StorageServiceImpl implements StorageService{
    @Autowired
	private StorageInfoMapper storageMapper;
	
	@Override
	public int StorageMapper(CommodityDTO commodityDTO) {
		return storageMapper.decreaseStorage(commodityDTO);
	}

}
