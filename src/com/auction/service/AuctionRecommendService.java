package com.auction.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.auction.mapper.mapper.AuctionRecommendMapper;
import com.auction.pojo.AuctionRecommendDO;

@Service
public class AuctionRecommendService {
      @Resource
      private AuctionRecommendMapper auctionRecommendMapper;
      
      public AuctionRecommendDO getRecommend(int id)
      {
    	  return auctionRecommendMapper.getRecommend(id);
      }
      
      public List<AuctionRecommendDO> getRecommendList()
      {
    	  return auctionRecommendMapper.getRecommendList();
      }
}
