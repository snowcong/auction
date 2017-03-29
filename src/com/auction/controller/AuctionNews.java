package com.auction.controller;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.auction.pojo.AuctionNewsDO;
import com.auction.service.AuctionNewsService;

@Controller
@RequestMapping(value = "/auction")
public class AuctionNews {
    @Resource
    private AuctionNewsService auctionNewsService;
    
    @RequestMapping(value = "/news")
    public String getNews(Model model,int id)
    {
    	AuctionNewsDO news = auctionNewsService.getNews(id);
    	model.addAttribute("auctionNews", news);
    	return "auction/newsDetails";
    }
}
