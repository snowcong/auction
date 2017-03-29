package com.auction.controller;

import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.auction.pojo.BuyerDO;
import com.auction.pojo.SalerDO;
import com.auction.service.RegisterService;

@Controller
@RequestMapping(value = "/register")
public class Register {
	@Resource
	private RegisterService registerService;

	@RequestMapping(value = "/submit")
	public String submit(Model model , String type,String username, String password,HttpSession session)
	{
		if(username!= null && password!=null && username.length() != 0 && password.length() != 0)
    	{
			if(type.equals("buyer"))
			{
				BuyerDO buyer = new BuyerDO();
				buyer.setBuyerName(username);
				buyer.setPassword(password);
				String result = registerService.isHaveBuyer(buyer);
				if(result == null)
				{
					registerService.insertBuyer(buyer);
					session.setAttribute("buyer", buyer);
					ConcurrentHashMap<Integer,Integer> shopCarList = new ConcurrentHashMap<Integer,Integer>();
					session.setAttribute("shopCarList", shopCarList);
					
					return "index";
				}
				else
				{
					model.addAttribute("registerMsg","该用户名已经被注册了");
					return "again_register";
				}
			}
			else if(type.equals("saler"))
			{
				SalerDO saler = new SalerDO();
				saler.setSalerName(username);
				saler.setPassword(password);
				String result = registerService.isHaveSaler(saler);
				if(result == null)
				{
					registerService.insertSaler(saler);
					
	                session.setAttribute("saler", saler);
					
					return "index";
				}
				else
				{
					model.addAttribute("registerMsg","该用户名已经被注册了");
					return "again_register";
				}
			}
			return "again_register";
    	}
    	else
    	{
    		model.addAttribute("registerMsg","输入不能为空");
    		return "again_register";
    	}
	}
}
