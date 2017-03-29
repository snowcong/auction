package com.auction.mapper.mapper;

import java.util.List;

import com.auction.pojo.CommodityNewDO;
import com.auction.pojo.CommodityRecommendDO;
import com.auction.pojo.EntertainmentCommodityDO;
import com.auction.pojo.LifeCommodityDO;
import com.auction.pojo.NumListDO;
import com.auction.pojo.OthersCommodityDO;
import com.auction.pojo.PriceListDO;
import com.auction.pojo.SportCommodityDO;

public interface GetListMapper {
      public List<PriceListDO> getPriceList();
      public List<NumListDO> getNumList();
      public List<SportCommodityDO> getSport();
      public List<OthersCommodityDO> getOthers();
      public List<EntertainmentCommodityDO> getEntertainment();
      public List<LifeCommodityDO> getLife();
      public List<CommodityNewDO> getNews();
      public List<CommodityRecommendDO> getRecommend();
}
