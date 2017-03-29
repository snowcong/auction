package com.auction.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.auction.pojo.CommodityNewDO;
import com.auction.pojo.CommodityRecommendDO;
import com.auction.pojo.EntertainmentCommodityDO;
import com.auction.pojo.LifeCommodityDO;
import com.auction.pojo.NumListDO;
import com.auction.pojo.OthersCommodityDO;
import com.auction.pojo.PriceListDO;
import com.auction.pojo.SportCommodityDO;
import com.auction.service.AuctionHistoryService;
import com.auction.service.AuctionNewsService;
import com.auction.service.AuctionRecommendService;
import com.auction.service.GetListService;

@Controller
@RequestMapping(value = "/project")
public class Init {
	 @Resource
     private GetListService getList;
	 @Resource
	 private AuctionNewsService auctionNewsService;
	 @Resource
     private AuctionHistoryService auctionHistoryService;
	 @Resource
     private AuctionRecommendService auctionRecommendService;
	 
	 @RequestMapping(value = "/index")
	 public String index(HttpSession session)
	 {
		//得到价格排行榜
    	 List<PriceListDO> priceList = getList.getPriceList();
 		 session.setAttribute("priceList", priceList);
 		 
 		 //得到销量排行榜
 		 List<NumListDO> numList = getList.getNumList();
		 session.setAttribute("numList",numList);
		 
		 //得到各种商品的前10
		 List<SportCommodityDO> sport = getList.getSport();
		 session.setAttribute("sport",sport);
		 
		 List<LifeCommodityDO> life = getList.getLife();
		 session.setAttribute("life",life);

		 List<OthersCommodityDO> others = getList.getOthers();
		 session.setAttribute("others",others);
		 
		 List<EntertainmentCommodityDO> entertainment = getList.getEntertainment();
		 session.setAttribute("entertainment",entertainment);
		 
		 List<CommodityNewDO> news = getList.getNews();
		 session.setAttribute("news",news);
		 
		 List<CommodityRecommendDO> recommend = getList.getRecommend();
		 session.setAttribute("recommend",recommend);
		 
		 return "login";
	 }
	
     @RequestMapping(value = "/initSale")
     public String init()
     {
    	 return "index";
     }
     
     @RequestMapping(value = "initAuction")
     public String initAcution(Model model)
     {
    	 model.addAttribute("newsList", auctionNewsService.getNewsList());
    	 model.addAttribute("historyList", auctionHistoryService.getHistoryList());
    	 model.addAttribute("recommendList", auctionRecommendService.getRecommendList());
    	 return "auction/index";
     }
     @RequestMapping(value = "/buyerLogin")
     public String buyerLogin()
     {
    	 return "login";
     }
     @RequestMapping(value = "/salerLogin")
     public String salerLogin()
     {
    	 return "salerLogin";
     }
     @RequestMapping(value = "/register")
     public String register()
     {
    	 return "register";
     }
}
