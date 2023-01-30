package com.mhj.home.product;

public class ProductOptionDTO {
	
	private Long option_num;
	private Long product_num;
	private String option_name;
	private Integer option_price;
	private Integer option_stock;
	
	//getter, setter
	
	public Long getOption_num() {
		return option_num;
	}
	public void setOption_num(Long option_num) {
		this.option_num = option_num;
	}
	public Long getProduct_num() {
		return product_num;
	}
	public void setProduct_num(Long product_num) {
		this.product_num = product_num;
	}
	public String getOption_name() {
		return option_name;
	}
	public void setOption_name(String option_name) {
		this.option_name = option_name;
	}
	public Integer getOption_price() {
		return option_price;
	}
	public void setOption_price(Integer option_price) {
		this.option_price = option_price;
	}
	public Integer getOption_stock() {
		return option_stock;
	}
	public void setOption_stock(Integer option_stock) {
		this.option_stock = option_stock;
	}

}
