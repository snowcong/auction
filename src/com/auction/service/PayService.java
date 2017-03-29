package com.auction.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.auction.mapper.mapper.BuyerMapper;

@Service
public class PayService {
	    @Resource
	    private BuyerMapper buyMapper;
	    
	    public void updateCom(String com, String buyName)
	    {
	    	buyMapper.updateCom(com, buyName);
	    }
}
