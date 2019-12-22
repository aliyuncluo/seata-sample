package com.cluo.service;

import java.util.Map;

import com.cluo.dto.AccountDTO;

public interface AccountService {

	public Map<String,Object> decreaseAccount(AccountDTO accountDTO);
}
