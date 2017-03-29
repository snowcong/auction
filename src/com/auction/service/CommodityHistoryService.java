package com.auction.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.auction.mapper.mapper.CommodityHistoryMapper;
import com.auction.pojo.CommodityHistoryDO;

@Service
public class CommodityHistoryService {
     @Resource
     private CommodityHistoryMapper commodityHistoryMapper;
	
	 public void insert(CommodityHistoryDO c)
	 {
		 commodityHistoryMapper.insert(c);
	 }
	 
	 public List<CommodityHistoryDO> getList(int id)
	 {
		 return commodityHistoryMapper.getList(id);
	 }
}
