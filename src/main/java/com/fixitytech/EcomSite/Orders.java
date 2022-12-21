package com.fixitytech.EcomSite;


import java.util.List;
public class Orders {
    int orderid;
    double totalamount;
    String customerId;
    List<OrderItem> orderItems;
    
    
    
    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
    
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }
    public int getOrderid() {
        return orderid;
    }
    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }
    public double getTotalamount() {
        return totalamount;
    }
    public void setTotalamount(double totalamount) {
        this.totalamount = totalamount;
    }
    public String getCustomerId() {
        return customerId;
    }
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }



}
/*
ackage com.fixity.Ecom.Object;



import java.util.List;



public class Orders {
    int Orderid;
    double totalamount;
    String customerId;
    
    List<OrderITem> orderItems;
    
    
    
    public void setOrderItems(List<OrderITem> orderItems) {
        this.orderItems = orderItems;
    }
    
    public List<OrderITem> getOrderItems() {
        return orderItems;
    }
    public int getOrderid() {
        return Orderid;
    }
    public void setOrderid(int orderid) {
        Orderid = orderid;
    }
    public double getTotalamount() {
        return totalamount;
    }
    public void setTotalamount(double totalamount) {
        this.totalamount = totalamount;
    }
    public String getCustomerId() {
        return customerId;
    }
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }



}
 */