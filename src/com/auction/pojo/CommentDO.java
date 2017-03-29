package com.auction.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comment")
public class CommentDO {
    private Integer id;
    private Integer commodityId;
    private String  content;
    private Integer bad;
    private Integer good;
    private String  buyerName;
    private Date    time;
    private Integer common;
    
    @Column(name = "common", nullable = true, length = 11)
	public Integer getCommon() {
		return common;
	}
	public void setCommon(Integer common) {
		this.common = common;
	}
	@Column(name = "buyerName", nullable = true, length = 255)
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	@Column(name = "time", nullable = true, length = 0)
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 11)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "commodityId", nullable = true, length = 11)
	public Integer getCommodityId() {
		return commodityId;
	}
	public void setCommodityId(Integer commodityId) {
		this.commodityId = commodityId;
	}
	@Column(name = "content", nullable = true, length = 11)
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Column(name = "bad", nullable = true, length = 11)
	public Integer getBad() {
		return bad;
	}
	public void setBad(Integer bad) {
		this.bad = bad;
	}
	@Column(name = "good", nullable = true, length = 11)
	public Integer getGood() {
		return good;
	}
	public void setGood(Integer good) {
		this.good = good;
	}
}
