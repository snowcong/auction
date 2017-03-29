package com.auction.mapper.mapper;

import org.apache.ibatis.annotations.Param;

import com.auction.pojo.AuctionBookDO;
import com.auction.pojo.AuctionChinaWareDO;
import com.auction.pojo.AuctionJadeWareDO;
import com.auction.pojo.AuctionLiquorDO;
import com.auction.pojo.AuctionPaintingDO;

public interface AuctionInsertMapper {
     public void insertB(@Param("b") AuctionBookDO b);
     public void insertP(@Param("p") AuctionPaintingDO p);
     public void insertC(@Param("c") AuctionChinaWareDO c);
     public void insertJ(@Param("j") AuctionJadeWareDO j);
     public void insertL(@Param("l") AuctionLiquorDO l);
}
