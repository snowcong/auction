package com.auction.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.auction.mapper.mapper.BuyerRegisterMapper;
import com.auction.mapper.mapper.SalerRegisterMapper;
import com.auction.pojo.BuyerDO;
import com.auction.pojo.SalerDO;

@Service
public class RegisterService {
	@Resource
	private BuyerRegisterMapper buyerRegisterMapper;
	@Resource
	private SalerRegisterMapper salerRegisterMapper;
	
    public String isHaveBuyer(BuyerDO buyer)
    {
    	String result = buyerRegisterMapper.isHaveBuyer(buyer);
    	return result;
    }
    
    public String isHaveSaler(SalerDO saler)
    {
    	String result = salerRegisterMapper.isHaveSaler(saler);
    	return result;
    }
    
    public void insertBuyer(BuyerDO buyer)
    {
    	buyerRegisterMapper.insertBuyer(buyer);
    }
    
    public void insertSaler(SalerDO saler)
    {
    	salerRegisterMapper.insertSaler(saler);
    }
}
