package modal;


import java.util.Date;
import java.util.List;

//  contains information about an order, including product list of the order, buyer information
public class Orders {
 private int orderId;
 private double price;// total amount of order
 private int status;
 private java.util.Date orderDate;
 private String address;//buyer's address
 private String phoneNumber;
 private List<ProductOrders> lp;
 private String userMail;//buyer's email
 private java.util.Date receiveDate;
 private String discount;
public Orders() {
	super();
}
public Orders(int orderId, double price, int status, Date orderDate, String address, String phoneNumber,
		List<ProductOrders> lp, String userMail, Date receiveDate, String discount) {
	super();
	this.orderId = orderId;
	this.price = price;
	this.status = status;
	this.orderDate = orderDate;
	this.address = address;
	this.phoneNumber = phoneNumber;
	this.lp = lp;
	this.userMail = userMail;
	this.receiveDate = receiveDate;
	this.discount = discount;
}

public int getOrderId() {
	return orderId;
}
public void setOrderId(int orderId) {
	this.orderId = orderId;
}
public double getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public Date getOrderDate() {
	return orderDate;
}
public void setOrderDate(Date orderDate) {
	this.orderDate = orderDate;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public List<ProductOrders> getLp() {
	return lp;
}
public void setLp(List<ProductOrders> lp) {
	this.lp = lp;
}
public String getUserMail() {
	return userMail;
}
public void setUserMail(String userMail) {
	this.userMail = userMail;
}
public Date getReceiveDate() {
	return receiveDate;
}
public void setReceiveDate(Date receiveDate) {
	this.receiveDate = receiveDate;
}
public String getDiscount() {
	return discount;
}
public void setDiscount(String discount) {
	this.discount = discount;
}
 
}
