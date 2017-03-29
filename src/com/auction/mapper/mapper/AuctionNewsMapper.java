package com.auction.mapper.mapper;

import java.util.List;

import com.auction.pojo.AuctionNewsDO;


public interface AuctionNewsMapper {
     public AuctionNewsDO getNews(int id);
     public List<AuctionNewsDO> getNewsList();
}
