package com.auction.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.auction.mapper.mapper.CommodityMapper;
import com.auction.mapper.mapper.UtilsMapper;
import com.auction.pojo.CommentDO;
import com.auction.pojo.CommodityDO;
import com.auction.pojo.CommodityNewDO;
import com.auction.pojo.CommodityRecommendDO;
import com.auction.pojo.EntertainmentCommodityDO;
import com.auction.pojo.LifeCommodityDO;
import com.auction.pojo.OthersCommodityDO;
import com.auction.pojo.SalerDO;
import com.auction.pojo.SportCommodityDO;

@Service
public class CommodityService {
	    @Resource
	    private CommodityMapper commodityMapper;
	    @Resource
	    private UtilsMapper utilsMapper;
	    
	    //购买商品时在数据库中减1
	    public void decrease(int id)
	    {
	    	utilsMapper.de(id);
	    }
	    
	    //得到商品详情页（商品详情）
        public CommodityDO getCommodityParticulars(Integer id)
        {
        	CommodityDO result = commodityMapper.getCommodityParticulars(id);
        	return result;
        }
        
        //得到商品详情页（卖家详情）
        public SalerDO getSaler(Integer id)
        {
        	SalerDO result = commodityMapper.getSaler(id);
        	return result;
        }
        
        //得到商品详情页（评论详情）
        public List<CommentDO> getComment(Integer id)
        {
        	List<CommentDO> result = commodityMapper.getComment(id);
        	return result;
        }
        
        //模糊查询
        public List<CommodityDO> getSearch(String search)
        {
        	List<CommodityDO> result = commodityMapper.getSearch(search);
        	return result;
        }
        
        //得到运动商品的更多
        public List<SportCommodityDO> getSport(Integer begin , Integer number)
        {
        	List<SportCommodityDO> list = commodityMapper.getSport(begin , number);
            return list;        		
        }
        
        //得到其他商品的更多
        public List<OthersCommodityDO> getOthers(Integer begin , Integer number)
        {
        	List<OthersCommodityDO> list = commodityMapper.getOthers(begin , number);
            return list;        		
        }
        
        //得到运动商品的更多
        public List<LifeCommodityDO> getLife(Integer begin , Integer number)
        {
        	List<LifeCommodityDO> list = commodityMapper.getLife(begin , number);
            return list;        		
        }
        
        //得到运动商品的更多
        public List<EntertainmentCommodityDO> getEntertainment(Integer begin , Integer number)
        {
        	List<EntertainmentCommodityDO> list = commodityMapper.getEntertainment(begin , number);
            return list;        		
        }
        
        //得到最新商品的更多
        public List<CommodityNewDO> getNews(Integer begin , Integer number)
        {
        	List<CommodityNewDO> list = commodityMapper.getNews(begin, number);
            return list;
        }
        
        //得到推荐商品的更多
        public List<CommodityRecommendDO> getRecommend(Integer begin,Integer number)
        {
        	List<CommodityRecommendDO> list = commodityMapper.getRecommend(begin, number);
        	return list;
        }
        
        //得到娱乐商品的页数
        public int getNum()
        {
        	int num = commodityMapper.getEnterNum();
        	if(num % 20 == 0)
        	{
        		num = num / 20;
        	}
        	else
        	{
        		num = num / 20;
        		num = num +1;
        	}
        	return num;
        }
        
        //得到commodity下一个id
        public int getId()
        {
        	return commodityMapper.getId();
        }
        
        //插入commodity表中
        public void insert(CommodityDO commodity)
        {
        	commodityMapper.insert(commodity);
        }
        
        //插入sportcommodity表中
        public void insertS(SportCommodityDO commodity)
        {
        	commodityMapper.insertS(commodity);
        }
        
        //插入entertainmentcommodity表中
        public void insertE(EntertainmentCommodityDO commodity)
        {
        	commodityMapper.insertE(commodity);
        }
        
        //插入lifecommodity表中
        public void insertL(LifeCommodityDO commodity)
        {
        	commodityMapper.insertL(commodity);
        }
        
        //插入otherscommodity表中
        public void insertO(OthersCommodityDO commodity)
        {
        	commodityMapper.insertO(commodity);
        }
}
