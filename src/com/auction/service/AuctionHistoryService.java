package com.auction.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.auction.mapper.mapper.AuctionHistoryMapper;
import com.auction.pojo.AuctionHistoryDO;

@Service
public class AuctionHistoryService {
     @Resource
     private AuctionHistoryMapper auctionHistoryMapper;
     
     public AuctionHistoryDO getHistory(int id)
     {
    	 return auctionHistoryMapper.getHistory(id);
     }
     
     public List<AuctionHistoryDO> getHistoryList()
     {
    	 return auctionHistoryMapper.getHistoryList();
     }
}
