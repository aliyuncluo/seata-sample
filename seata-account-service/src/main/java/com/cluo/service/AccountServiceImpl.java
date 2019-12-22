package com.cluo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cluo.dto.AccountDTO;
import com.cluo.dao.AccountMapper;
import com.cluo.response.ObjectResponse;

import io.seata.core.context.RootContext;

@Service
public class AccountServiceImpl implements AccountService{
    
	@Autowired
	private AccountMapper accountMapper;

    @Override
    public Map<String,Object> decreaseAccount(AccountDTO accountDTO) {
        Map<String,Object> map = new HashMap<>();
    	try {
        	System.out.println("全局事务id ：" + RootContext.getXID());
            int account = accountMapper.decreaseAccount(accountDTO);
            map.put("code", "200");
            map.put("msg", "操作成功");
		} catch (Exception e) {
			map.put("code", "500");
			map.put("msg", "操作失败");
		}
        return map;
    }
}
