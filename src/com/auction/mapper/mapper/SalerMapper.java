package com.auction.mapper.mapper;

import org.apache.ibatis.annotations.Param;

import com.auction.pojo.SalerDO;

public interface SalerMapper {
     public SalerDO loginVerify( @Param("saler") SalerDO saler);
     public SalerDO getSaler(@Param("sid") Integer id);
     public void updatePas(@Param("saler") SalerDO saler);
}
