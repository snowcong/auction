package com.auction.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.auction.pojo.AuctionHistoryDO;
import com.auction.service.AuctionHistoryService;

@Controller
@RequestMapping(value = "/auction")
public class AuctionHistory {
     @Resource
     private AuctionHistoryService auctionHistoryService;
     
     @RequestMapping(value = "/history")
     public String getHistory(Model model,int id)
     {
    	String [] img = auctionHistoryService.getHistory(id).getImg().split(";"); 
    	model.addAttribute("imgList", img);
    	model.addAttribute("historyDetail", auctionHistoryService.getHistory(id));
    	return "auction/historyDetails"; 
     }
     
     @RequestMapping(value = "/historyList")
     public String getHistoryList(Model model)
     {
    	List<AuctionHistoryDO> historyList = auctionHistoryService.getHistoryList();
    	model.addAttribute("historyList", historyList);
    	return "auction/titleList"; 
     }
}
