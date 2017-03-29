package com.auction.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.auction.pojo.AuctionBookDO;
import com.auction.pojo.AuctionChinaWareDO;
import com.auction.pojo.AuctionJadeWareDO;
import com.auction.pojo.AuctionLiquorDO;
import com.auction.pojo.AuctionPaintingDO;
import com.auction.service.AuctionShowService;

@Controller
@RequestMapping(value = "/auction/show")
public class AuctionShow {
	@Resource
	private AuctionShowService auctionShowService;
	
	@RequestMapping(value = "/book")
	public String book(Model model)
	{
		List<AuctionBookDO> books = auctionShowService.showBook();
		model.addAttribute("lists",books);
		return "auction/show";
	}
	
	@RequestMapping(value = "/painting")
	public String painting(Model model)
	{
		List<AuctionPaintingDO> paintings = auctionShowService.showPainting();
		model.addAttribute("lists",paintings);
		return "auction/show";
	}
	
	@RequestMapping(value = "/chinaware")
	public String chinaware(Model model)
	{
		List<AuctionChinaWareDO> chinawares = auctionShowService.showChinaWare();
		model.addAttribute("lists",chinawares);
		return "auction/show";
	}
	
	@RequestMapping(value = "/jadeware")
	public String jadeware(Model model)
	{
		List<AuctionJadeWareDO> jadewares = auctionShowService.showJadeWare();
		model.addAttribute("lists",jadewares);
		return "auction/show";
	}
	
	@RequestMapping(value = "/liquor")
	public String liquor(Model model)
	{
		List<AuctionLiquorDO> liquors = auctionShowService.showLiquor();
		model.addAttribute("lists",liquors);
		return "auction/show";
	}
}
