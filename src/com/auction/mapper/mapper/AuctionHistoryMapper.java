package com.auction.mapper.mapper;

import java.util.List;

import com.auction.pojo.AuctionHistoryDO;


public interface AuctionHistoryMapper {
     public AuctionHistoryDO getHistory(int id);
     public List<AuctionHistoryDO> getHistoryList();
}
