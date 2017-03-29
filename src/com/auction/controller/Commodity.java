package com.auction.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.auction.pojo.CommentDO;
import com.auction.pojo.CommodityDO;
import com.auction.pojo.CommodityNewDO;
import com.auction.pojo.CommodityRecommendDO;
import com.auction.pojo.EntertainmentCommodityDO;
import com.auction.pojo.LifeCommodityDO;
import com.auction.pojo.OthersCommodityDO;
import com.auction.pojo.SalerDO;
import com.auction.pojo.SportCommodityDO;
import com.auction.service.CommodityService;

@Controller
@RequestMapping(value = "/commodity")
public class Commodity {
    @Resource
    private CommodityService commodityService;
    
    @RequestMapping(value = "/index")
    public String index()
    {
    	return "index";	
    }
    
	@RequestMapping(value = "/particulars")
	public String particulars(Model model,Integer commodityId)
	{
		CommodityDO com = commodityService.getCommodityParticulars(commodityId);
		SalerDO saler = commodityService.getSaler(com.getSalerId());
		List<CommentDO> comment = commodityService.getComment(commodityId);
		
        String [] img = com.getImg().split(";");
        
        model.addAttribute("imgList",img);
		model.addAttribute("commodity",com);
		model.addAttribute("saler",saler);
		model.addAttribute("comment",comment);
		
		return "commodityParticulars";
	}
	
	@RequestMapping(value = "/sport")
	public String getSport(Model model, Integer begin, Integer number)
	{
		List<SportCommodityDO> list = commodityService.getSport(begin, number);
		model.addAttribute("sportList",list);
		return "/more/moreSport";
	}
	
	@RequestMapping(value = "/others")
	public String getOthers(Model model, Integer begin, Integer number)
	{
		List<OthersCommodityDO> list = commodityService.getOthers(begin, number);
		model.addAttribute("othersList",list);
		return "/more/moreOthers";
	}
	
	@RequestMapping(value = "/life")
	public String getLife(Model model, Integer begin, Integer number)
	{
		List<LifeCommodityDO> list = commodityService.getLife(begin, number);
		model.addAttribute("lifeList",list);
		return "/more/moreLife";
	}
	
	@RequestMapping(value = "/entertainment")
	public String getEntertainment(Model model, Integer begin, Integer number,Integer type)
	{
		if(type == 0)
		{
		   begin = begin * 20;
		}
		else if(type == 1)
		{
			if(begin == 1)
			{
				begin = 1;
			}
			else
			{
				begin = begin - 1;
			}
		}
		else
		{
			int num = commodityService.getNum();
			System.out.println("11111      "+num);
			if(begin == num)
			{
				begin = num ;
			}
			else
			{
				begin = begin + 1;
			}
		}
		List<EntertainmentCommodityDO> list = commodityService.getEntertainment(begin, number);
		model.addAttribute("entertainmentList",list);
		return "/more/moreEntertainment";
	}
	
	@RequestMapping(value = "/news")
	public String getNews(Model model,Integer begin, Integer number)
	{
		List<CommodityNewDO> list = commodityService.getNews(begin, number);
		model.addAttribute("newsList",list);
		return "/more/news";
	}
	
	@RequestMapping(value = "/recommend")
	public String getRecommend(Model model,Integer begin, Integer number)
	{
		List<CommodityRecommendDO> list = commodityService.getRecommend(begin, number);
		model.addAttribute("recommendList",list);
		return "/more/recommend";
	}
	
	@RequestMapping(value = "/aboutus")
	public String aboutus()
	{
		return "aboutus";
	}
}
