package com.auction.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.auction.pojo.AuctionBookDO;
import com.auction.pojo.AuctionChinaWareDO;
import com.auction.pojo.AuctionJadeWareDO;
import com.auction.pojo.AuctionLiquorDO;
import com.auction.pojo.AuctionPaintingDO;
import com.auction.pojo.CommodityDO;
import com.auction.pojo.EntertainmentCommodityDO;
import com.auction.pojo.LifeCommodityDO;
import com.auction.pojo.OthersCommodityDO;
import com.auction.pojo.SalerDO;
import com.auction.pojo.SportCommodityDO;
import com.auction.service.AuctionInsertService;
import com.auction.service.CommodityService;
import com.auction.service.SalerService;

@Controller
@RequestMapping(value = "/saler")
public class Saler {
    @Resource
    private SalerService salerService;
    @Resource
    private CommodityService commodityService;
    @Resource
    private AuctionInsertService auctionInsertService;
	
	@RequestMapping(value = "/getSaler")
	public String getSaler(Model model,Integer id)
	{
		SalerDO saler = salerService.getSaler(id);
		model.addAttribute("saler",saler);
		return "saler";
	}
	
	@RequestMapping(value = "/editPas")
	public void editPas(String pas,String newPas,HttpServletResponse response,HttpSession session) throws Exception
	{
		SalerDO saler = (SalerDO)session.getAttribute("saler");
		if(saler.getPassword().equals(pas))
		{
		   saler.setPassword(newPas);
		   salerService.updatePas(saler);
		   response.getWriter().write("success");
		}
		else
		{
		   response.getWriter().write("error");
		}
 		response.getWriter().close();		
	}
	
	@RequestMapping(value = "/addCommodity")
	public String addCommodity(Model model,int type,CommodityDO commodity, @RequestParam(value = "file") MultipartFile file,@RequestParam(value = "file1") MultipartFile file1,@RequestParam(value = "file2") MultipartFile file2,@RequestParam(value = "file3") MultipartFile file3,HttpServletRequest request,HttpSession session) throws IOException
	{
		  String img = null;
		  String imgUrl = null;
	      if (!file.isEmpty()) {  
		        try {  
		            // 文件保存路径  
		            String filePath = "E://img/"+new Date().getTime()+".jpg";  
		            // 转存文件  
		            file.transferTo(new File(filePath));  
		            imgUrl = filePath;
		        } catch (Exception e) {  
		            e.printStackTrace();  
		        }  
		    }  
	       if (!file1.isEmpty()) {  
		        try {  
		            // 文件保存路径  
		            String filePath = "E://img/"+new Date().getTime()+".jpg";  
		            // 转存文件  
		            file.transferTo(new File(filePath));  
		            img = filePath;
		        } catch (Exception e) {  
		            e.printStackTrace();  
		        }  
		    }  
	       if (!file2.isEmpty()) {  
		        try {  
		            // 文件保存路径  
		            String filePath = "E://img/"+new Date().getTime()+".jpg";  
		            // 转存文件  
		            file.transferTo(new File(filePath));  
		            img = ";"+filePath;
		        } catch (Exception e) {  
		            e.printStackTrace();  
		        }  
		    }  
	       if (!file3.isEmpty()) {  
		        try {  
		            // 文件保存路径  
		            String filePath = "E://img/"+new Date().getTime()+".jpg";  
		            // 转存文件  
		            file.transferTo(new File(filePath));  
		            img = ";"+filePath;
		        } catch (Exception e) {  
		            e.printStackTrace();  
		        }  
		    }  
	        SalerDO saler = (SalerDO)session.getAttribute("saler");
	        commodity.setSalerId(saler.getId());
	        commodity.setImg(img);
	        commodity.setImgUrl(imgUrl);
            int id = commodityService.getId()+1; 
            commodityService.insert(commodity);
            if(type == 1)
            {
            	SportCommodityDO s = new SportCommodityDO();
            	s.setCommodityId(id);
            	s.setImg(img);
            	s.setImgUrl(imgUrl);
            	s.setIntroduce(commodity.getIntroduce());
                s.setName(commodity.getName());
                s.setNumber(commodity.getNumber());
                s.setPrice(commodity.getPrice());
                commodityService.insertS(s);
            }
            else if(type == 2)
            {
            	EntertainmentCommodityDO e = new EntertainmentCommodityDO();
            	e.setCommodityId(id);
            	e.setImg(img);
            	e.setImgUrl(imgUrl);
            	e.setIntroduce(commodity.getIntroduce());
                e.setName(commodity.getName());
                e.setNumber(commodity.getNumber());
                e.setPrice(commodity.getPrice());
                commodityService.insertE(e);
            }
            else if(type == 3)
            {
            	LifeCommodityDO l = new LifeCommodityDO();
            	l.setCommodityId(id);
            	l.setImg(img);
            	l.setImgUrl(imgUrl);
            	l.setIntroduce(commodity.getIntroduce());
                l.setName(commodity.getName());
                l.setNumber(commodity.getNumber());
                l.setPrice(commodity.getPrice());
                commodityService.insertL(l);
            }
            else
            {
            	OthersCommodityDO o = new OthersCommodityDO();
            	o.setCommodityId(id);
            	o.setImg(img);
            	o.setImgUrl(imgUrl);
            	o.setIntroduce(commodity.getIntroduce());
                o.setName(commodity.getName());
                o.setNumber(commodity.getNumber());
                o.setPrice(commodity.getPrice());
                commodityService.insertO(o);
            }
	        return "test";
	}
	
	@RequestMapping(value = "/addAuction")
	public String addAuction(Model model,int type,AuctionBookDO auction, @RequestParam(value = "file") MultipartFile file,@RequestParam(value = "file1") MultipartFile file1,@RequestParam(value = "file2") MultipartFile file2,@RequestParam(value = "file3") MultipartFile file3,HttpServletRequest request,HttpSession session) throws IOException
	{
		  String img = null;
		  String imgUrl = null;
	      if (!file.isEmpty()) {  
		        try {  
		            // 文件保存路径  
		            String filePath = "E://img/"+new Date().getTime()+".jpg";  
		            // 转存文件  
		            file.transferTo(new File(filePath));  
		            imgUrl = filePath;
		        } catch (Exception e) {  
		            e.printStackTrace();  
		        }  
		    }  
	       if (!file1.isEmpty()) {  
		        try {  
		            // 文件保存路径  
		            String filePath = "E://img/"+new Date().getTime()+".jpg";  
		            // 转存文件  
		            file.transferTo(new File(filePath));  
		            img = filePath;
		        } catch (Exception e) {  
		            e.printStackTrace();  
		        }  
		    }  
	       if (!file2.isEmpty()) {  
		        try {  
		            // 文件保存路径  
		            String filePath = "E://img/"+new Date().getTime()+".jpg";  
		            // 转存文件  
		            file.transferTo(new File(filePath));  
		            img = ";"+filePath;
		        } catch (Exception e) {  
		            e.printStackTrace();  
		        }  
		    }  
	       if (!file3.isEmpty()) {  
		        try {  
		            // 文件保存路径  
		            String filePath = "E://img/"+new Date().getTime()+".jpg";  
		            // 转存文件  
		            file.transferTo(new File(filePath));  
		            img = ";"+filePath;
		        } catch (Exception e) {  
		            e.printStackTrace();  
		        }  
		    }  
	        SalerDO saler = (SalerDO)session.getAttribute("saler");
          if(type == 1)
          {
          	  AuctionBookDO b = new AuctionBookDO();
              b.setSalerId(saler.getId());
          	  b.setImg(img);
          	  b.setImgUrl(imgUrl);
          	  b.setIntroduce(auction.getIntroduce());
              b.setName(auction.getName());
              b.setPrice(auction.getPrice());
              auctionInsertService.insertB(b);
          }
          else if(type == 2)
          {
        	  AuctionPaintingDO p = new AuctionPaintingDO();
              p.setSalerId(saler.getId());
          	  p.setImg(img);
          	  p.setImgUrl(imgUrl);
          	  p.setIntroduce(auction.getIntroduce());
              p.setName(auction.getName());
              p.setPrice(auction.getPrice());
              auctionInsertService.insertP(p);
          }
          else if(type == 3)
          {
        	  AuctionChinaWareDO c = new AuctionChinaWareDO();
              c.setSalerId(saler.getId());
          	  c.setImg(img);
          	  c.setImgUrl(imgUrl);
          	  c.setIntroduce(auction.getIntroduce());
              c.setName(auction.getName());
              c.setPrice(auction.getPrice());
              auctionInsertService.insertC(c);
          }
          else if(type == 4)
          {
        	  AuctionJadeWareDO j = new AuctionJadeWareDO();
              j.setSalerId(saler.getId());
          	  j.setImg(img);
          	  j.setImgUrl(imgUrl);
          	  j.setIntroduce(auction.getIntroduce());
              j.setName(auction.getName());
              j.setPrice(auction.getPrice());
              auctionInsertService.insertJ(j);
          }
          else
          {
        	  AuctionLiquorDO l = new AuctionLiquorDO();
              l.setSalerId(saler.getId());
          	  l.setImg(img);
          	  l.setImgUrl(imgUrl);
          	  l.setIntroduce(auction.getIntroduce());
              l.setName(auction.getName());
              l.setPrice(auction.getPrice());
              auctionInsertService.insertL(l);
          }
	        return "test";
	}
}
