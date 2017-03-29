package com.auction.mapper.mapper;

import org.apache.ibatis.annotations.Param;

import com.auction.pojo.SalerDO;

public interface SalerRegisterMapper {
     public String isHaveSaler( @Param("saler") SalerDO saler);
     public void insertSaler( @Param("saler") SalerDO saler); 
}
