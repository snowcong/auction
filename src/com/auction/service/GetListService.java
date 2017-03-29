package com.auction.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.auction.mapper.mapper.GetListMapper;
import com.auction.pojo.CommodityNewDO;
import com.auction.pojo.CommodityRecommendDO;
import com.auction.pojo.EntertainmentCommodityDO;
import com.auction.pojo.LifeCommodityDO;
import com.auction.pojo.NumListDO;
import com.auction.pojo.OthersCommodityDO;
import com.auction.pojo.PriceListDO;
import com.auction.pojo.SportCommodityDO;

@Service
public class GetListService {
    @Resource
    private GetListMapper getListMapper; 
    
	public List<PriceListDO> getPriceList()
	{
		List<PriceListDO> list = getListMapper.getPriceList();
	    return list;
	}
	
	public List<NumListDO> getNumList()
	{
		List<NumListDO> list = getListMapper.getNumList();
	    return list;
	}
	
	public List<SportCommodityDO> getSport()
	{
		List<SportCommodityDO> list = getListMapper.getSport();
		return list;
	}
	
	public List<OthersCommodityDO> getOthers()
	{
		List<OthersCommodityDO> list = getListMapper.getOthers();
		return list;
	}
	
	public List<LifeCommodityDO> getLife()
	{
		List<LifeCommodityDO> list = getListMapper.getLife();
		return list;
	}
	
	public List<EntertainmentCommodityDO> getEntertainment()
	{
		List<EntertainmentCommodityDO> list = getListMapper.getEntertainment();
		return list;
	}
	
	public List<CommodityNewDO> getNews()
	{
		List<CommodityNewDO> list = getListMapper.getNews();
		return list;
	}
	
	public List<CommodityRecommendDO> getRecommend()
	{
		List<CommodityRecommendDO> list = getListMapper.getRecommend();
		return list;
	}
}
