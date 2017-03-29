package com.auction.pojo;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "buyer")
public class BuyerDO {
    private Integer id;
    private String  buyerName;
    private String  password;
    private String  imgUrl;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
}
