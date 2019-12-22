package com.cluo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

@Service
@FeignClient(value="account-service")
public interface AccountService {

}
