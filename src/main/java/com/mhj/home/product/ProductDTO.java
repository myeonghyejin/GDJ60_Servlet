package com.mhj.home.product;

public class ProductDTO {
	
	private Long product_num;
	private String product_name;
	private String product_detail;
	private Double product_score;
	
	//getter, setter
	public Long getProduct_num() {
		return product_num;
	}
	public void setProduct_num(Long product_num) {
		this.product_num = product_num;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_detail() {
		return product_detail;
	}
	public void setProduct_detail(String product_detail) {
		this.product_detail = product_detail;
	}
	public Double getProduct_score() {
		return product_score;
	}
	public void setProduct_score(Double product_score) {
		this.product_score = product_score;
	}
	
}
