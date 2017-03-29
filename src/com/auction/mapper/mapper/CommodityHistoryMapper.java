package com.auction.mapper.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.auction.pojo.CommodityHistoryDO;

public interface CommodityHistoryMapper {
	public void insert(@Param("c") CommodityHistoryDO c);
	public List<CommodityHistoryDO> getList(@Param("id") int id);
}
