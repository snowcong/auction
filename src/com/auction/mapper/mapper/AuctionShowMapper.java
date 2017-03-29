package com.auction.mapper.mapper;

import java.util.List;

import com.auction.pojo.AuctionBookDO;
import com.auction.pojo.AuctionChinaWareDO;
import com.auction.pojo.AuctionJadeWareDO;
import com.auction.pojo.AuctionLiquorDO;
import com.auction.pojo.AuctionPaintingDO;

public interface AuctionShowMapper {
     public List<AuctionBookDO> showBook();
     public List<AuctionPaintingDO> showPainting();
     public List<AuctionChinaWareDO> showChinaWare();
     public List<AuctionJadeWareDO> showJadeWare();
     public List<AuctionLiquorDO> showLiquor();
}
