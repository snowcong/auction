package com.auction.mapper.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.auction.pojo.CommentDO;
import com.auction.pojo.CommodityDO;
import com.auction.pojo.CommodityNewDO;
import com.auction.pojo.CommodityRecommendDO;
import com.auction.pojo.EntertainmentCommodityDO;
import com.auction.pojo.LifeCommodityDO;
import com.auction.pojo.OthersCommodityDO;
import com.auction.pojo.SalerDO;
import com.auction.pojo.SportCommodityDO;

public interface CommodityMapper {
     public CommodityDO getCommodityParticulars( @Param("cid") Integer id);
     public List<CommodityDO> getSearch( @Param("search") String search);
     public SalerDO getSaler(@Param("cid") Integer id); 
     public List<CommentDO> getComment(@Param("cid") Integer id);
     public List<SportCommodityDO> getSport(@Param("begin") Integer begin,@Param("number") Integer number);
     public List<LifeCommodityDO> getLife(@Param("begin") Integer begin,@Param("number") Integer number);
     public List<OthersCommodityDO> getOthers(@Param("begin") Integer begin,@Param("number") Integer number);
     public List<EntertainmentCommodityDO> getEntertainment(@Param("begin") Integer begin,@Param("number") Integer number);
     public List<CommodityNewDO> getNews(@Param("begin") Integer begin,@Param("number") Integer number);
     public List<CommodityRecommendDO> getRecommend(@Param("begin") Integer begin,@Param("number") Integer number);
     public int getEnterNum();
     public int getId();
     public void insert(@Param("commodity")CommodityDO commodity);
     public void insertS(@Param("sport")SportCommodityDO commodity);
     public void insertE(@Param("enter")EntertainmentCommodityDO commodity);
     public void insertL(@Param("life")LifeCommodityDO commodity);
     public void insertO(@Param("others")OthersCommodityDO commodity);
}
