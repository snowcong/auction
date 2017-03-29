package com.auction.utils;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.auction.pojo.AuctionBookDO;
import com.auction.pojo.AuctionChinaWareDO;
import com.auction.pojo.AuctionJadeWareDO;
import com.auction.pojo.AuctionLiquorDO;
import com.auction.pojo.AuctionPaintingDO;
import com.auction.service.UtilsService;

@Component
public class TaskImpl implements TaskInterface {
	@Resource
    private UtilsService utils;
	
	@Scheduled(cron="0/5 * *  * * ? ")   //每5秒执行一次
	@Override
	public void success() {
      	List<AuctionBookDO> books = utils.getBookList();
		for(int i=0; i< books.size(); i++)
		{
			 books.get(i).setEndTime(new Date());
             utils.insertAuctionHistory(books.get(i));	
             utils.deleteBook(books.get(i).getId());
		}
		
		List<AuctionPaintingDO> paintings = utils.getPaintingList();
		for(int i=0; i< paintings.size(); i++)
		{
			 paintings.get(i).setEndTime(new Date());
             utils.insertAuctionHistory(paintings.get(i));
             utils.deletePainting(paintings.get(i).getId());
		}
		
		List<AuctionChinaWareDO> chinaWares = utils.getChinaWareList();
		for(int i=0; i< chinaWares.size(); i++)
		{
			 chinaWares.get(i).setEndTime(new Date());
             utils.insertAuctionHistory(chinaWares.get(i));
             utils.deleteChinaWare(chinaWares.get(i).getId());
		}
		
		List<AuctionJadeWareDO> jadeWares = utils.getJadeWareList();
		for(int i=0; i< jadeWares.size(); i++)
		{
			 jadeWares.get(i).setEndTime(new Date());
             utils.insertAuctionHistory(jadeWares.get(i));	
             utils.deleteJadeWare(jadeWares.get(i).getId());
		}
		
		List<AuctionLiquorDO> liquors = utils.getLiquorList();
		for(int i=0; i< liquors.size(); i++)
		{
			 liquors.get(i).setEndTime(new Date());
             utils.insertAuctionHistory(liquors.get(i));
             utils.deleteLiquor(liquors.get(i).getId());
		}
	}
}
