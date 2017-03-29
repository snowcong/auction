package com.auction.mapper.mapper;

import org.apache.ibatis.annotations.Param;

import com.auction.pojo.BuyerDO;

public interface BuyerRegisterMapper {
     public String isHaveBuyer( @Param("buyer") BuyerDO buyer);
     public void insertBuyer( @Param("buyer") BuyerDO buyer);     
}
