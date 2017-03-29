package com.auction.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.auction.mapper.mapper.AjaxMapper;
import com.auction.pojo.CommentDO;

@Service
public class AjaxService {
    @Resource
    private AjaxMapper ajaxMapper; 
    
	public void good(CommentDO comment)
	{
	    ajaxMapper.updateGood(comment);	
	}
	
	public void common(CommentDO comment)
	{
		System.out.println("cccccccccc   "+comment.getId());
	    ajaxMapper.updateCommon(comment);	
	}
	
	public void bad(CommentDO comment)
	{
	    ajaxMapper.updateBad(comment);	
	}
	
	public void comment(CommentDO comment)
	{
	    ajaxMapper.insertComment(comment);	
	}
}
