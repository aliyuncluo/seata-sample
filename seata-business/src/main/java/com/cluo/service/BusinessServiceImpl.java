package com.cluo.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cluo.dto.BusinessDTO;
import com.cluo.dto.CommodityDTO;
import com.cluo.dto.OrderDTO;
import com.cluo.enums.RspStatusEnum;
import com.cluo.exception.DefaultException;
import com.cluo.feign.AccountService;
import com.cluo.feign.OrderService;
import com.cluo.feign.StorageService;
import com.cluo.response.ObjectResponse;

import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;

@Service
public class BusinessServiceImpl implements BusinessService{

	@Autowired
    private StorageService storageService;

	@Autowired
    private OrderService orderService;
	
	@Autowired
	private AccountService accountService;

    private boolean flag;

    /**
     * 处理业务逻辑
     * @Param:
     * @Return:
     */
    @Override
    @GlobalTransactional(timeoutMills = 300000, name = "seata-business")
    public ObjectResponse handleBusiness(BusinessDTO businessDTO) {
        System.out.println("开始全局事务，XID = " + RootContext.getXID());
        ObjectResponse<Object> objectResponse = new ObjectResponse<>();
        //1、扣减库存
        CommodityDTO commodityDTO = new CommodityDTO();
        commodityDTO.setCommodityCode(businessDTO.getCommodityCode());
        commodityDTO.setCount(businessDTO.getCount());
        ObjectResponse storageResponse = storageService.decreaseStorage(commodityDTO);
        System.out.println("storageResponse="+storageResponse.toString());
        //2、创建订单
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setUserId(businessDTO.getUserId());
        orderDTO.setCommodityCode(businessDTO.getCommodityCode());
        orderDTO.setOrderCount(businessDTO.getCount());
        orderDTO.setOrderAmount(new BigDecimal(businessDTO.getAmount()));
        ObjectResponse<OrderDTO> response = orderService.createOrder(orderDTO);
        System.out.println("response="+response.toString());
        //打开注释测试事务发生异常后，全局回滚功能
//        if (!flag) {
//            throw new RuntimeException("测试抛异常后，分布式事务回滚！");
//        }

        if (storageResponse.getStatus() != 200 || response.getStatus() != 200) {
            throw new DefaultException(RspStatusEnum.FAIL);
        }

        objectResponse.setStatus(RspStatusEnum.SUCCESS.getCode());
        objectResponse.setMessage(RspStatusEnum.SUCCESS.getMessage());
        objectResponse.setData(response.getData());
        return objectResponse;
    }
}
