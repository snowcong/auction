package com.auction.mapper.mapper;

import org.apache.ibatis.annotations.Param;

import com.auction.pojo.CommentDO;

public interface AjaxMapper {
     public void updateGood( @Param("comment") CommentDO comment);
     public void updateCommon( @Param("comment") CommentDO comment);
     public void updateBad( @Param("comment") CommentDO comment);
     public void insertComment( @Param("comment") CommentDO comment);
}
