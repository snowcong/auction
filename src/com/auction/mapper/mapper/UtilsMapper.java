package com.auction.mapper.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.auction.pojo.AuctionBookDO;
import com.auction.pojo.AuctionChinaWareDO;
import com.auction.pojo.AuctionJadeWareDO;
import com.auction.pojo.AuctionLiquorDO;
import com.auction.pojo.AuctionPaintingDO;

public interface UtilsMapper {
     public List<AuctionBookDO> getBookList();
     public List<AuctionPaintingDO> getPaintingList();
     public List<AuctionChinaWareDO> getChinaWareList();
     public List<AuctionJadeWareDO> getJadeWareList();
     public List<AuctionLiquorDO> getLiquorList();
     
     public void insertBook(@Param("book") AuctionBookDO book);
     public void insertPainting(@Param("painting") AuctionPaintingDO painting);
     public void insertChinaWare(@Param("chinaware") AuctionChinaWareDO chinaWare);
     public void insertJadeWare(@Param("jadeware") AuctionJadeWareDO jadeWare);
     public void insertLiquor(@Param("liquor") AuctionLiquorDO liquor);
     
     public void deleteBook(@Param("id") int id);
     public void deletePainting(@Param("id") int id);
     public void deleteChinaWare(@Param("id") int id);
     public void deleteJadeWare(@Param("id") int id);
     public void deleteLiquor(@Param("id") int id);
     
     public void de(@Param("id") int id);
}
