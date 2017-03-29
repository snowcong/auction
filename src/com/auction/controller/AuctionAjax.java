package com.auction.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.auction.pojo.BuyerDO;
import com.auction.service.AuctionAjaxService;

@Controller
@RequestMapping(value = "/auctionAjax")
public class AuctionAjax {
    @Resource
    private AuctionAjaxService auctionAjaxService;
	
	@RequestMapping(value = "/paimai")
	public void paimai(Model model,int id,String price, int type ,HttpServletResponse response,HttpSession session) throws IOException
	{
		BuyerDO buyer = (BuyerDO) session.getAttribute("buyer");
		int buyerId = buyer.getId();
		auctionAjaxService.update(id, type, buyerId, price);
		
		response.getWriter().write("success");
 		response.getWriter().close();
	}
	@RequestMapping(value = "/recommendPaimai")
	public void recommendPaimai(Model model,int id,String price,HttpServletResponse response,HttpSession session) throws IOException
	{
		BuyerDO buyer = (BuyerDO) session.getAttribute("buyer");
		int buyerId = buyer.getId();
		auctionAjaxService.updateRecommend(id, buyerId, price);
		
		response.getWriter().write("success");
 		response.getWriter().close();
	}
}
