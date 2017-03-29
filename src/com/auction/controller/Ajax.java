package com.auction.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.auction.pojo.CommentDO;
import com.auction.service.AjaxService;

@Controller
@RequestMapping(value = "/ajax")
public class Ajax {
    @Resource
    private AjaxService ajaxService;
    
    @RequestMapping(value = "/shopCar")
    public void shopCar(Integer commodityId, Integer num, HttpServletResponse response,HttpSession session) throws IOException
    {
    	Boolean flag = false;
    	ConcurrentHashMap<Integer,Integer> shopCarList = (ConcurrentHashMap<Integer,Integer>) session.getAttribute("shopCarList");
    	//判断购物车中是否有该商品，如果有则相应的价格变化
		Iterator iter = shopCarList.entrySet().iterator();
		while (iter.hasNext()) {
			//能获得map中的每一个键值对了
			Entry entry = (Entry) iter.next();
			Integer key = (Integer)entry.getKey();
			if(key.equals(commodityId))
			{
				flag = true;
				Integer value = (Integer)entry.getValue();
				value =( value + num);
				shopCarList.put(commodityId, value);
			}
		}
    	//购物车中没有该商品，直接加入该商品ID和相应的数量
    	if(flag == false)
    	{
    		shopCarList.put(commodityId,num);
    		session.setAttribute("shopCarList", shopCarList);
    	}
    	
    	response.getWriter().write("success");
 		response.getWriter().close();
    }
    
	@RequestMapping(value = "/good")
	public void good(Integer commentId,HttpServletResponse response) throws IOException
	{
		CommentDO comment = new CommentDO();
		comment.setId(commentId);
		
	    ajaxService.good(comment);
	    
	    response.getWriter().write("success");
		response.getWriter().close();
	}
	
	@RequestMapping(value = "/common")
	public void common(Integer commentId,HttpServletResponse response) throws IOException
	{
		CommentDO comment = new CommentDO();
		comment.setId(commentId);
		
	    ajaxService.common(comment);
	    
	    response.getWriter().write("success");
		response.getWriter().close();
	}
	
	@RequestMapping(value = "/bad")
	public void bad(Integer commentId,HttpServletResponse response) throws IOException
	{
		CommentDO comment = new CommentDO();
		comment.setId(commentId);
		
	    ajaxService.bad(comment);
	    
	    response.getWriter().write("success");
		response.getWriter().close();
	}
	
	@RequestMapping(value = "/comment")
	public void comment(Integer commodityId,String buyerName,String content,HttpServletResponse response) throws IOException
	{
		String con = content;
        content.replace("傻", "*");	
        content.replace("你妹", "*");
        content.replace("去你的", "*");
        content.replace("滚", "*");
        content.replace("nima", "*");
        
		CommentDO comment = new CommentDO();
		comment.setCommodityId(commodityId);
		comment.setBuyerName(buyerName);
		Date date = new Date();
		comment.setTime(date);
		comment.setGood(0);
		comment.setCommon(0);
		comment.setBad(0);
		comment.setContent(con);
		
	    ajaxService.comment(comment);
	    
	    response.getWriter().write("success");
		response.getWriter().close();
	}
	
	@RequestMapping(value = "/delete")
	public void delete(Integer id,HttpServletResponse response,HttpSession session) throws IOException
	{
		ConcurrentHashMap<Integer,Integer> list = (ConcurrentHashMap<Integer,Integer>) session.getAttribute("shopCarList");
		Iterator iter = list.entrySet().iterator();
		while (iter.hasNext()) {
			//能获得map中的每一个键值对了
			Entry entry = (Entry) iter.next();
			Integer key = (Integer)entry.getKey();
			if(key.equals(id))
			{
				iter.remove();
			}
		}
		response.getWriter().write("success");
		response.getWriter().close();
	}
}
