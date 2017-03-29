package com.auction.pojo;

public class ShopCar {
   private int id;
   private String name;
   private int num;
   private String price;
   private String onePrice;
   
	public String getOnePrice() {
	return onePrice;
	}
	public void setOnePrice(String onePrice) {
		this.onePrice = onePrice;
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
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
}
