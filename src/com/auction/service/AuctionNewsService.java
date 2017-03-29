package com.auction.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.auction.mapper.mapper.AuctionNewsMapper;
import com.auction.pojo.AuctionNewsDO;

@Service
public class AuctionNewsService {
     @Resource
     private AuctionNewsMapper auctionNewsMapper;
     
     public AuctionNewsDO getNews(int id)
     {
    	 return auctionNewsMapper.getNews(id);
     }
     
     public List<AuctionNewsDO> getNewsList()
     {
    	 return auctionNewsMapper.getNewsList();
     }
}
