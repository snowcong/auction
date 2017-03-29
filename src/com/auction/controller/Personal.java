package com.auction.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.auction.pojo.BuyerDO;
import com.auction.service.BuyerService;
import com.auction.service.CommodityHistoryService;

@Controller
@RequestMapping(value = "/personal")
public class Personal {
    @Resource
    private CommodityHistoryService commodityHistoryService;
    @Resource
    private BuyerService buyerService;
	
	@RequestMapping(value = "/getPersonalList")
	public String getPersonalList(Model model,HttpSession session)
	{
		BuyerDO buyer = (BuyerDO)session.getAttribute("buyer");
		model.addAttribute("img",buyerService.getImg(buyer.getId()));
		model.addAttribute("commodityList",commodityHistoryService.getList(buyer.getId()));
		return "personal";
	}
	
	@RequestMapping(value = "/editPas")
	public void editPas(String pas,String newPas,HttpServletResponse response,HttpSession session) throws IOException
	{
		BuyerDO buyer = (BuyerDO)session.getAttribute("buyer");
		if(buyer.getPassword().equals(pas))
		{
		   buyer.setPassword(newPas);
		   buyerService.updatePas(buyer);
		   response.getWriter().write("success");
		}
		else
		{
		   response.getWriter().write("error");
		}
 		response.getWriter().close();
	}
}
