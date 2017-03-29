package com.auction.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.auction.mapper.mapper.SalerMapper;
import com.auction.pojo.SalerDO;

@Service
public class SalerService {
	@Resource
	private SalerMapper salerMapper;
	
	/**
	 * 登陆验证卖家用户名密码
	 */
    public SalerDO loginVerify(SalerDO saler)
    {
    	if(saler != null)
    	{
    		SalerDO result = salerMapper.loginVerify(saler);
	    	return result;
    	}
    	else
    	{
    		return null;
    	}
    }
    
    /**
     *通过id得到卖家信息
     */
    public SalerDO getSaler(Integer id)
    {
    	SalerDO result = salerMapper.getSaler(id);
    	return result;	
    }
    
    /**
     * 修改密码
     */
    public void updatePas(SalerDO saler)
    {
    	salerMapper.updatePas(saler);
    }
}
