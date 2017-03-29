package com.auction.mapper.mapper;

import org.apache.ibatis.annotations.Param;

import com.auction.pojo.AuctionBookDO;
import com.auction.pojo.AuctionChinaWareDO;
import com.auction.pojo.AuctionJadeWareDO;
import com.auction.pojo.AuctionLiquorDO;
import com.auction.pojo.AuctionPaintingDO;
import com.auction.pojo.AuctionRecommendDO;

public interface AuctionAjaxMapper {
     public void updateBook(@Param("book") AuctionBookDO book);
     public void updatePainting(@Param("painting") AuctionPaintingDO painting);
     public void updateChinaWare(@Param("chinaWare") AuctionChinaWareDO chinaWare);
     public void updateJadeWare(@Param("jadeWare") AuctionJadeWareDO jadeWare);
     public void updateLiquor(@Param("liquor") AuctionLiquorDO liquor);
     public void updateRecommend(@Param("recommend") AuctionRecommendDO recommend);
}
