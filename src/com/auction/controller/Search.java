package com.auction.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.auction.pojo.CommodityDO;
import com.auction.service.CommodityService;

@Controller
@RequestMapping(value = "/search")
public class Search {
    @Resource
    private CommodityService commodityService;
    
	@RequestMapping(value = "/vagueSearch")
	public String search(Model model,String search)
	{
		List<CommodityDO> list = commodityService.getSearch(search);
		model.addAttribute("searchList",list);
		return "search";
	}
}
