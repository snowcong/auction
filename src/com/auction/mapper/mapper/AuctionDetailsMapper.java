package com.auction.mapper.mapper;

import org.apache.ibatis.annotations.Param;

import com.auction.pojo.AuctionBookDO;
import com.auction.pojo.AuctionChinaWareDO;
import com.auction.pojo.AuctionJadeWareDO;
import com.auction.pojo.AuctionLiquorDO;
import com.auction.pojo.AuctionPaintingDO;

public interface AuctionDetailsMapper {
     public AuctionBookDO detailsBook(@Param("id") int id);
     public AuctionPaintingDO detailsPainting(@Param("id") int id);
     public AuctionChinaWareDO detailsChinaWare(@Param("id") int id);
     public AuctionJadeWareDO detailsJadeWare(@Param("id") int id);
     public AuctionLiquorDO detailsLiquor(@Param("id") int id);
}
