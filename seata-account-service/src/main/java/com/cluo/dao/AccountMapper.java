package com.cluo.dao;

import org.apache.ibatis.annotations.Mapper;

import com.cluo.dto.AccountDTO;

@Mapper
public interface AccountMapper{

	public int decreaseAccount(AccountDTO accountDTO);
}
