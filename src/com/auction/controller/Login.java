package com.auction.controller;

import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.auction.pojo.BuyerDO;
import com.auction.pojo.SalerDO;
import com.auction.service.BuyerService;
import com.auction.service.SalerService;

@Controller
@RequestMapping(value = "/login")
public class Login  {
	HttpServletRequest request ;
	
	@Resource
	private SalerService salerService;
	@Resource
	private BuyerService buyerService;
	
	//买家登录
    @RequestMapping(value = "/buyerLogin")
    public String buyerLogin(Model model,BuyerDO buyer,HttpSession session)
    {
    	if(buyer.getBuyerName() != null && buyer.getPassword() !=null && buyer.getBuyerName().length() != 0 && buyer.getPassword().length() != 0)
    	{
    		BuyerDO result = buyerService.loginVerify(buyer);
    		if(result != null)
    		{
				session.setAttribute("buyer", result);
				ConcurrentHashMap<Integer,Integer> shopCarList = new ConcurrentHashMap<Integer,Integer>();
				session.setAttribute("shopCarList", shopCarList);
        		return "index";
    		}
    		else
    		{
    			model.addAttribute("loginMsg","用户名密码不匹配");
        		return "again_buyerLogin";
    		}
    	}
    	else
    	{
    		model.addAttribute("loginMsg","输入不能为空");
    		return "again_buyerLogin";
    	}
    }
    
    //卖家登录
    @RequestMapping(value = "/salerLogin")
    public String salerLogin(Model model,SalerDO saler,HttpSession session)
    {
    	if(saler.getSalerName() != null && saler.getPassword() != null && saler.getSalerName().length() != 0 && saler.getPassword().length() != 0)
    	{
    		SalerDO result = salerService.loginVerify(saler);
    		if(result != null)
    		{
				session.setAttribute("saler", result);
   			    return "saler";
    		}
    		else
    		{
    			model.addAttribute("loginMsg","用户名密码不匹配");
    			return "again_salerLogin";
    		}
    	}
    	else
    	{
    		model.addAttribute("loginMsg","用户名密码不能为空");
    		return "again_salerLogin";
    	}
    }
}
