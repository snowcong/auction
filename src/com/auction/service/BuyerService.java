package com.auction.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.auction.mapper.mapper.BuyerMapper;
import com.auction.pojo.BuyerDO;
@Service
public class BuyerService {
	@Resource
	private BuyerMapper userMapper;
	
	/**
	 * 登陆验证买家用户名密码
	 */
    public BuyerDO loginVerify(BuyerDO buyer)
    {
    	if(buyer != null)
    	{
    		BuyerDO result = userMapper.loginVerify(buyer);
	    	return result;
    	}
    	else
    	{
    		return null;
    	}
    }
    
    /**
     * 得到用户头像
     */
    public String getImg(int id)
    {
    	return userMapper.getImg(id);
    }
    
    /**
     * 修改密码
     */
    public void updatePas(BuyerDO buyer)
    {
    	userMapper.updatePas(buyer);	
    }
    
}
