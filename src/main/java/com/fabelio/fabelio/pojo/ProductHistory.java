package com.fabelio.fabelio.pojo;

import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Document(collection="product_history")
public class ProductHistory {
	private String id;
	private String productLink;
	private String productName;
	private BigDecimal price;
	private String description;
	private List<Image> images;
	private Date saveTime;

	public ProductHistory(Product product){
		this.productLink = product.getProductLink();
		this.productName = product.getProductName();
		this.price = product.getPrice();
		this.description = product.getDescription();
		this.images = product.getImages();
		this.saveTime = product.getSaveTime();
	}

	public Date getSaveTime() {
		return saveTime;
	}

	public void setSaveTime(Date saveTime) {
		this.saveTime = saveTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductLink() {
		return productLink;
	}

	public void setProductLink(String productLink) {
		this.productLink = productLink;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

}
