package com.auction.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.auction.pojo.AuctionBookDO;
import com.auction.pojo.AuctionChinaWareDO;
import com.auction.pojo.AuctionJadeWareDO;
import com.auction.pojo.AuctionLiquorDO;
import com.auction.pojo.AuctionPaintingDO;

@Service
public class AuctionInsertService {
    @Resource
	private AuctionInsertService auctionInsertService;
	
    public void insertB(AuctionBookDO b)
    {
    	auctionInsertService.insertB(b);
    }
    
    public void insertP(AuctionPaintingDO p)
    {
    	auctionInsertService.insertP(p);
    }
    
    public void insertC(AuctionChinaWareDO c)
    {
    	auctionInsertService.insertC(c);
    }
    
    public void insertJ(AuctionJadeWareDO j)
    {
    	auctionInsertService.insertJ(j);
    }
    
    public void insertL(AuctionLiquorDO l)
    {
    	auctionInsertService.insertL(l);
    }
}
