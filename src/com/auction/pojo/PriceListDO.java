package com.auction.pojo;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "priceList")
public class PriceListDO {
    private Integer id;
    private String commodityName;
    private String  price;
    private Integer commodityId;
    
	public String getCommodityName() {
		return commodityName;
	}
	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Integer getCommodityId() {
		return commodityId;
	}
	public void setCommodityId(Integer commodityId) {
		this.commodityId = commodityId;
	}
}
