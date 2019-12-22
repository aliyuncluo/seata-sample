package com.cluo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cluo.dto.AccountDTO;
import com.cluo.response.ObjectResponse;
import com.cluo.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
	private AccountService accountService;
	
	@PostMapping("/decrease")
	public ObjectResponse decreaseAccount(AccountDTO accountDTO) {
		ObjectResponse<Object> response = ObjectResponse.newInstance();
		response.setData(accountService.decreaseAccount(accountDTO));
		return response;
	}
}
