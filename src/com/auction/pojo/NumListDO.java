package com.auction.pojo;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "numList")
public class NumListDO {
    private Integer id;
    private Integer num;
    private Integer commodityId;
    private String  commodityName;
    
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
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Integer getCommodityId() {
		return commodityId;
	}
	public void setCommodityId(Integer commodityId) {
		this.commodityId = commodityId;
	}
}
