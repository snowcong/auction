package com.auction.mapper.mapper;

import java.util.List;

import com.auction.pojo.AuctionRecommendDO;


public interface AuctionRecommendMapper {
     public AuctionRecommendDO getRecommend(int id);
     public List<AuctionRecommendDO> getRecommendList();
}
