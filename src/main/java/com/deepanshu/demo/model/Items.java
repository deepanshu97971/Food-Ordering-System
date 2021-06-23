package com.deepanshu.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Items 
{
	
	@Id
	private int SNo;
	private String item;
	private int price;
	public int getSNo() {
		return SNo;
	}
	public void setSNo(int sNo) {
		SNo = sNo;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Items [SNo=" + SNo + ", item=" + item + ", price=" + price + "]";
	}
	

}
