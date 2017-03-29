package com.auction.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.auction.pojo.BuyerDO;
import com.auction.pojo.CommodityDO;
import com.auction.pojo.CommodityHistoryDO;
import com.auction.pojo.ShopCar;
import com.auction.service.CommodityHistoryService;
import com.auction.service.CommodityService;

@Controller
@RequestMapping(value = "/pay")
public class Pay {
	@Resource
	private CommodityService commodityService;
	@Resource
	private CommodityHistoryService commodityHistoryService;
    
	@RequestMapping(value = "/immediatelyPay")
	public String finishPay(String buyNum,Integer commodityId,Model model,HttpSession session)
	{
		List<ShopCar> shopCarList = new ArrayList<ShopCar>();
		int num1 = Integer.parseInt(buyNum);
        Boolean flag = false;
        ConcurrentHashMap<Integer,Integer> list = (ConcurrentHashMap<Integer,Integer>) session.getAttribute("shopCarList");
		Iterator iter = list.entrySet().iterator();
		while (iter.hasNext()) {
			Entry entry = (Entry) iter.next();
			Integer key = (Integer)entry.getKey();
			if(key.equals(commodityId)){
				Integer num = (Integer)entry.getValue();
				num = num + num1;
				list.put(commodityId, num);
				session.setAttribute("shopCarList", list);
				flag = true;
			}
		}
		if(flag == false){
			list.put(commodityId, num1);
			session.setAttribute("shopCarList", list);
		}
		
		Iterator iter1 = list.entrySet().iterator();
		while (iter1.hasNext()) {
			ShopCar sc = new ShopCar();
			Entry entry = (Entry) iter1.next();
			CommodityDO c = commodityService.getCommodityParticulars((Integer)entry.getKey());
			sc.setId((Integer)entry.getKey());
			sc.setName(c.getName());
			sc.setNum((Integer)entry.getValue());
			sc.setOnePrice(c.getPrice());
			Double a =(Integer)entry.getValue()*Double.valueOf(c.getPrice());
			sc.setPrice(a.toString());
			shopCarList.add(sc);
		}
		model.addAttribute("sCar", shopCarList);
        return "pay";
	}
	
	@RequestMapping(value = "/finishPay")
	public synchronized String finishPay(Model model,Integer [] payment,HttpSession session)
	{
		BuyerDO user = (BuyerDO)session.getAttribute("buyer");
		ConcurrentHashMap<Integer,Integer> list = (ConcurrentHashMap<Integer,Integer>) session.getAttribute("shopCarList");
		Iterator iter = list.entrySet().iterator();
		while (iter.hasNext()) {
			//能获得map中的每一个键值对了
			Entry entry = (Entry) iter.next();
			Integer key = (Integer)entry.getKey();
            //通过选中的与购物车中的商品名称对比，如果相同则删除，并且把成交记录写入commodityHistory表中
			for(int i=0; i<payment.length; i++)
			{
				if(payment[i].equals(key))
				{
					CommodityDO c = commodityService.getCommodityParticulars((Integer)entry.getKey());
			        CommodityHistoryDO ch = new CommodityHistoryDO();
			        ch.setBuyerId(user.getId());
					ch.setCommodityId(c.getId());
					ch.setImg(c.getImg());
					ch.setImgUrl(c.getImgUrl());
					ch.setIntroduce(c.getIntroduce());
					ch.setLevel(c.getLevel());
					ch.setName(c.getName());
					ch.setNumber(c.getNumber());
					ch.setPrice(c.getPrice());
					ch.setTime(new Date());
					ch.setSalerId(c.getSalerId());
					Integer sum = Integer.valueOf(c.getPrice())*c.getNumber();
					ch.setSum(sum.toString());
					commodityHistoryService.insert(ch);
					commodityService.decrease(c.getId());
					iter.remove();
				}
			}
		}
		return "index";
	}
	
	@RequestMapping(value = "shopCar") 
	public String shopCar(Model model,HttpSession session)
	{
		List<ShopCar> shopCarList = new ArrayList<ShopCar>();
		ConcurrentHashMap<Integer,Integer> list = (ConcurrentHashMap<Integer,Integer>) session.getAttribute("shopCarList");
		if(list.size() != 0)
		{
			Iterator iter = list.entrySet().iterator();
			while (iter.hasNext()) {
				ShopCar sc = new ShopCar();
				Entry entry = (Entry) iter.next();
				CommodityDO c = commodityService.getCommodityParticulars((Integer)entry.getKey());
				sc.setId((Integer)entry.getKey());
				sc.setName(c.getName());
				sc.setOnePrice(c.getPrice());
				sc.setNum((Integer)entry.getValue());
				Double a =(Integer)entry.getValue()*Double.valueOf(c.getPrice());
				sc.setPrice(a.toString());
				shopCarList.add(sc);
			}
		}
		else
		{
		}
		model.addAttribute("sCar", shopCarList);
		return "pay";
	}
}
