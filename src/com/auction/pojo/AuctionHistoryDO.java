package com.auction.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "history")
public class AuctionHistoryDO {
     private int id;
     private String name;
     private String price;
     private String lowPrice;
     private Date time;
     private String introduce;
     private String img;
     private String author;
     private int buyerId;
     private int type;
     private int salerId;
     private String imgUrl;
     
 	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public int getSalerId() {
		return salerId;
	}
	public void setSalerId(int salerId) {
		this.salerId = salerId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}
	public String getAuthor() {
 		return author;
 	}
 	public void setAuthor(String author) {
 		this.author = author;
 	}
	 public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public int getId() {
		return id;
	 }
	 public void setId(int id) {
		this.id = id;
	 }
	 public String getName() {
		return name;
	 }
	 public void setName(String name) {
		this.name = name;
	 }
	 public String getPrice() {
		return price;
	 }
	 public void setPrice(String price) {
		this.price = price;
	 }
	 public String getLowPrice() {
		return lowPrice;
	 }
	 public void setLowPrice(String lowPrice) {
		this.lowPrice = lowPrice;
	 }
	 public Date getTime() {
		return time;
	 }
	 public void setTime(Date time) {
		this.time = time;
	 }
}
