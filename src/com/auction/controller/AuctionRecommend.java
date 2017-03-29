package com.auction.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.auction.service.AuctionRecommendService;

@Controller
@RequestMapping(value = "/auction")
public class AuctionRecommend {
	  @Resource
      private AuctionRecommendService auctionRecommendService;
	  
	  @RequestMapping(value = "/recommend")
	  public String getRecommend(Model model,int id)
	  {
		  model.addAttribute("imgList", auctionRecommendService.getRecommend(id).getImg().split(";"));
		  model.addAttribute("detail", auctionRecommendService.getRecommend(id));
		  return "/auction/recommendDetails";
	  }
}
