package com.auction.mapper.mapper;

import org.apache.ibatis.annotations.Param;

import com.auction.pojo.BuyerDO;

public interface BuyerMapper {
     public BuyerDO loginVerify( @Param("buyer") BuyerDO buyer);
     public void updateCom (@Param("com") String com,@Param("buyerName") String buyerName); 
     public String getImg(@Param("id") int id);
     public void updatePas(@Param("buyer") BuyerDO buyer);
}
