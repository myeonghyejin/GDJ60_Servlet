package com.mhj.home.product;

public class ProductService {

	public static void main(String[] args) {
		
		ProductDAO productDAO = new ProductDAO();
		
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProduct_name("Product1");
		productDTO.setProduct_detail("Detail1");
		
		ProductOptionDTO productOptionDTO = new ProductOptionDTO();
		productOptionDTO.setOption_name("OptionName1");
		productOptionDTO.setOption_price(100);
		productOptionDTO.setOption_stock(10);
		productOptionDTO.setProduct_num(null);
		
		ProductOptionDTO productOptionDTO2 = new ProductOptionDTO();
		productOptionDTO2.setOption_name("OptionName2");
		productOptionDTO2.setOption_price(200);
		productOptionDTO2.setOption_stock(20);
		productOptionDTO2.setProduct_num(null);
		
		try {
			long num = productDAO.getProductNum();
			productDTO.setProduct_num(num);
			
			int result = productDAO.setAddProduct(productDTO);
			
			productOptionDTO.setProduct_num(num);
			
			if (result == 1) {
				productDAO.setAddProductOption(productOptionDTO);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
