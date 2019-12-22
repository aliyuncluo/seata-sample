package com.cluo.service;

import com.cluo.dto.BusinessDTO;
import com.cluo.response.ObjectResponse;

public interface BusinessService {

	ObjectResponse handleBusiness(BusinessDTO businessDTO);
}
