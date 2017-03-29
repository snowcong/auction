package com.auction.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.auction.mapper.mapper.AuctionDetailsMapper;
import com.auction.pojo.AuctionBookDO;
import com.auction.pojo.AuctionChinaWareDO;
import com.auction.pojo.AuctionJadeWareDO;
import com.auction.pojo.AuctionLiquorDO;
import com.auction.pojo.AuctionPaintingDO;

@Service
public class AuctionDetailsService {
      @Resource
      private AuctionDetailsMapper auctionDetailsMapper;
      
      public AuctionBookDO detailsBook(int id)
      {
    	  AuctionBookDO book = auctionDetailsMapper.detailsBook(id);
    	  return book;
      }
      
      public AuctionPaintingDO detailsPainting(int id)
      {
    	  AuctionPaintingDO painting = auctionDetailsMapper.detailsPainting(id);
    	  return painting;
      }
      
      public AuctionChinaWareDO detailsChinaWare(int id)
      {
    	  AuctionChinaWareDO chinaWare = auctionDetailsMapper.detailsChinaWare(id);
    	  return chinaWare;
      }
      
      public AuctionJadeWareDO detailsJadeWare(int id)
      {
    	  AuctionJadeWareDO jadeWare = auctionDetailsMapper.detailsJadeWare(id);
    	  return jadeWare;
      }
      
      public AuctionLiquorDO detailsLiquor(int id)
      {
    	  AuctionLiquorDO liquor = auctionDetailsMapper.detailsLiquor(id);
    	  return liquor;
      }
}
