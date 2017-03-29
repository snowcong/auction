package com.auction.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.auction.mapper.mapper.AuctionAjaxMapper;
import com.auction.pojo.AuctionBookDO;
import com.auction.pojo.AuctionChinaWareDO;
import com.auction.pojo.AuctionJadeWareDO;
import com.auction.pojo.AuctionLiquorDO;
import com.auction.pojo.AuctionPaintingDO;
import com.auction.pojo.AuctionRecommendDO;

@Service
public class AuctionAjaxService {
      @Resource
      private AuctionAjaxMapper auctionAjaxMapper;
      
      public void update(int id,int type ,int buyerId,String price)
      {
    	  if(type == 1)
    	  {
    		  AuctionBookDO book = new AuctionBookDO();
    		  book.setId(id);
    		  book.setBuyerId(buyerId);
    		  book.setPrice(price);
    		  auctionAjaxMapper.updateBook(book);
    	  }
    	  else if(type == 2)
    	  {
    		  AuctionPaintingDO painting = new AuctionPaintingDO();
    		  painting.setId(id);
    		  painting.setType(type);
    		  painting.setBuyerId(buyerId);
    		  painting.setPrice(price);
    		  auctionAjaxMapper.updatePainting(painting);
    	  }
    	  else if(type == 3)
    	  {
    		  AuctionChinaWareDO chinaWare = new AuctionChinaWareDO();
    		  chinaWare.setId(id);
    		  chinaWare.setType(type);
    		  chinaWare.setBuyerId(buyerId);
    		  chinaWare.setPrice(price);
    		  auctionAjaxMapper.updateChinaWare(chinaWare);
    	  }
    	  else if(type == 4)
    	  {
    		  AuctionJadeWareDO jadeWare = new AuctionJadeWareDO();
    		  jadeWare.setId(id);
    		  jadeWare.setType(type);
    		  jadeWare.setBuyerId(buyerId);
    		  jadeWare.setPrice(price);
    		  auctionAjaxMapper.updateJadeWare(jadeWare);
    	  }
    	  else 
    	  {
    		  AuctionLiquorDO liquor = new AuctionLiquorDO();
    		  liquor.setId(id);
    		  liquor.setType(type);
    		  liquor.setBuyerId(buyerId);
    		  liquor.setPrice(price);
    		  auctionAjaxMapper.updateLiquor(liquor);
    	  }
      }
      
      public void updateRecommend(int id,int buyerId,String price)
      {
    	  AuctionRecommendDO recommend = new AuctionRecommendDO();
    	  recommend.setId(id);
    	  recommend.setBuyerId(buyerId);
    	  recommend.setPrice(price);
		  auctionAjaxMapper.updateRecommend(recommend);
      }
}
