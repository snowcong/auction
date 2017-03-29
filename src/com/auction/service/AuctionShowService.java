package com.auction.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.auction.mapper.mapper.AuctionShowMapper;
import com.auction.pojo.AuctionBookDO;
import com.auction.pojo.AuctionChinaWareDO;
import com.auction.pojo.AuctionJadeWareDO;
import com.auction.pojo.AuctionLiquorDO;
import com.auction.pojo.AuctionPaintingDO;

@Service
public class AuctionShowService {
      @Resource
      private AuctionShowMapper auctionShowMapper;
      
      public List<AuctionBookDO> showBook()
      {
    	  List<AuctionBookDO> list = auctionShowMapper.showBook();
    	  return list;
      }
      
      public List<AuctionPaintingDO> showPainting()
      {
    	  List<AuctionPaintingDO> list = auctionShowMapper.showPainting();
    	  return list;
      }
      
      public List<AuctionChinaWareDO> showChinaWare()
      {
    	  List<AuctionChinaWareDO> list = auctionShowMapper.showChinaWare();
    	  return list;
      }
      
      public List<AuctionJadeWareDO> showJadeWare()
      {
    	  List<AuctionJadeWareDO> list = auctionShowMapper.showJadeWare();
    	  return list;
      }
      
      public List<AuctionLiquorDO> showLiquor()
      {
    	  List<AuctionLiquorDO> list = auctionShowMapper.showLiquor();
    	  return list;
      }
      
}
