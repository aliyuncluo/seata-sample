package com.cluo.dto;

import java.io.Serializable;
import lombok.Data;

/**
 * @Author: heshouyou
 * @Description
 * @Date Created in 2019/1/14 17:26
 */
@Data
public class BusinessDTO implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 8548509917684367735L;

	private String userId;

    private String commodityCode;

    private String name;

    private Integer count;

    private Double amount;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCommodityCode() {
        return commodityCode;
    }

    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
