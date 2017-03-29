package com.auction.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.auction.mapper.mapper.UtilsMapper;
import com.auction.pojo.AuctionBookDO;
import com.auction.pojo.AuctionChinaWareDO;
import com.auction.pojo.AuctionJadeWareDO;
import com.auction.pojo.AuctionLiquorDO;
import com.auction.pojo.AuctionPaintingDO;

@Service
public class UtilsService {
      @Resource
      private UtilsMapper utilsMapper;
      
      public List<AuctionBookDO> getBookList()
      {
    	  return utilsMapper.getBookList();
      }
      
      public List<AuctionPaintingDO> getPaintingList()
      {
    	  return utilsMapper.getPaintingList();
      }

      public List<AuctionChinaWareDO> getChinaWareList()
      {
    	  return utilsMapper.getChinaWareList();
      }
      
      public List<AuctionJadeWareDO> getJadeWareList()
      {
    	  return utilsMapper.getJadeWareList();
      }

      public List<AuctionLiquorDO> getLiquorList()
      {
    	  return utilsMapper.getLiquorList();
      }

      public void insertAuctionHistory(AuctionBookDO book)
      {
    	  utilsMapper.insertBook(book);
      }
      
      public void insertAuctionHistory(AuctionPaintingDO painting)
      {
    	  utilsMapper.insertPainting(painting);
      }
      
      public void insertAuctionHistory(AuctionChinaWareDO chinaWare)
      {
    	  utilsMapper.insertChinaWare(chinaWare);
      }
      
      public void insertAuctionHistory(AuctionJadeWareDO jadeWare)
      {
    	  utilsMapper.insertJadeWare(jadeWare);
      }
      
      public void insertAuctionHistory(AuctionLiquorDO liquor)
      {
    	  utilsMapper.insertLiquor(liquor);
      }
      
      public void deleteBook(int id)
      {
    	  utilsMapper.deleteBook(id);
      }
      
      public void deletePainting(int id)
      {
    	  utilsMapper.deletePainting(id);
      }
      
      public void deleteChinaWare(int id)
      {
    	  utilsMapper.deleteChinaWare(id);
      }
      
      public void deleteJadeWare(int id)
      {
    	  utilsMapper.deleteJadeWare(id);
      }
      
      public void deleteLiquor(int id)
      {
    	  utilsMapper.deleteLiquor(id);
      }
}
