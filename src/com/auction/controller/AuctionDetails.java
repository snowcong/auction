package com.auction.controller;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.auction.pojo.AuctionBookDO;
import com.auction.pojo.AuctionChinaWareDO;
import com.auction.pojo.AuctionJadeWareDO;
import com.auction.pojo.AuctionLiquorDO;
import com.auction.pojo.AuctionPaintingDO;
import com.auction.service.AuctionDetailsService;

@Controller
@RequestMapping(value = "/auction")
public class AuctionDetails {
    @Resource
    private AuctionDetailsService auctionDetailsService;
	
	@RequestMapping(value = "/details")
	public String book(Model model,int id,int type)
	{
		if(type == 1)
		{
		    AuctionBookDO book =auctionDetailsService.detailsBook(id);
		    String img = book.getImg();
		    String[] list = img.split(";");
		    model.addAttribute("detail",book);
		    model.addAttribute("imgList",list);
		}
		else if(type == 2)
		{
			AuctionPaintingDO painting =auctionDetailsService.detailsPainting(id);
			String img = painting.getImg();
		    String[] list = img.split(";");
		    model.addAttribute("detail",painting);
			model.addAttribute("imgList",list);
		}
		else if(type == 3)
		{
			AuctionChinaWareDO chinaWare =auctionDetailsService.detailsChinaWare(id);
			String img = chinaWare.getImg();
		    String[] list = img.split(";");
			model.addAttribute("imgList",list);
			model.addAttribute("detail",chinaWare);
		}
		else if(type == 4)
		{
			AuctionJadeWareDO jadeWare =auctionDetailsService.detailsJadeWare(id);
			String img = jadeWare.getImg();
		    String[] list = img.split(";");
			model.addAttribute("imgList",list);
			model.addAttribute("detail",jadeWare);
		}
		else
		{
			AuctionLiquorDO liquor =auctionDetailsService.detailsLiquor(id);
			String img = liquor.getImg();
		    String[] list = img.split(";");
			model.addAttribute("imgList",list);
			model.addAttribute("detail",liquor);
		}
		return "auction/details";
	}
}
