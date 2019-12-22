package com.cluo.dao;

import org.apache.ibatis.annotations.Mapper;

import com.cluo.dto.CommodityDTO;

@Mapper
public interface StorageInfoMapper {

	int decreaseStorage(CommodityDTO commodityDTO);
}
