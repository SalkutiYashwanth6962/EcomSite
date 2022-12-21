package com.fixitytech.EcomSite;

public class CartItem extends Item{
	int quantity;
	double totalAmount;

	public double getTotalAmount() {
		return quantity*price;
	}
	

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

}
