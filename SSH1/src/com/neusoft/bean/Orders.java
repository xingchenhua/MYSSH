package com.neusoft.bean;

import java.util.List;

public class Orders {
	private int id;
	private String orderNo;
	private String time;
	private User user;
	private String status;
	private List<OrdersItem> ordersItems;

	public User getUser() {
		return user;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public List<OrdersItem> getOrdersItems() {
		return ordersItems;
	}

	public void setOrdersItems(List<OrdersItem> ordersItems) {
		this.ordersItems = ordersItems;
	}
}
