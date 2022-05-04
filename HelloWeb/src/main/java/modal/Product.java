package modal;

import java.util.List;

// contains information of a product on the website.
public class Product {
 private int id ;
 private String name;
 private String decription;
 private float price;
 private String src;//location of image of product
 private String type;//type of product
 private String brand;//product's category
 private int number;
 
public Product() {
	super();
}
public Product(int id, String name, String decription, float price, String src, String type, String brand, int number) {
	super();
	this.id = id;
	this.name = name;
	this.decription = decription;
	this.price = price;
	this.src = src;
	this.type = type;
	this.brand = brand;
	this.number = number;
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
public String getDecription() {
	return decription;
}
public void setDecription(String decription) {
	this.decription = decription;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public String getSrc() {
	return src;
}
public void setSrc(String src) {
	this.src = src;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
public int getNumber() {
	return number;
}
public void setNumber(int number) {
	this.number = number;
}
@Override
public String toString() {
	return "Product [id=" + id + ", name=" + name + ", decription=" + decription + ", price=" + price + ", src=" + src
			+ ", type=" + type + ", brand=" + brand + ", number=" + number + "]";
}
 

}
