package com.mhj.home.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mhj.home.member.MemberDAO;
import com.mhj.home.member.MemberDTO;
import com.mhj.home.util.DBConnection;

public class ProductDAO {
	
	//getMax
	public Long getProductNum() throws Exception {
		Connection connection = DBConnection.getConnection();
		
		String sql = "SELECT PRODUCT_SEQ.NEXTVAL FROM DUAL";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		rs.next();
		
		Long num = rs.getLong(1);
		
		DBConnection.disConnection(rs, st, connection);
		
		return num;
		
	}
	
	//----------------------------------------------
	
	public List<ProductOptionDTO> getProductOptionList() throws Exception {
		List<ProductOptionDTO> ar = new ArrayList<ProductOptionDTO>();
		
		Connection connection = DBConnection.getConnection();
		
		String sql = "SELECT * FROM PRODUCT_OPTION";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			ProductOptionDTO productOptionDTO = new ProductOptionDTO();
//			productOptionDTO.setOption_num(rs.getLong("OPTION_NUM"));
//			productOptionDTO.setProduct_num(rs.getLong("PRODUCT_NUM"));
			productOptionDTO.setOption_name(rs.getString("OPTION_NAME"));
			productOptionDTO.setOption_price(rs.getInt("OPTION_PRICE"));
			productOptionDTO.setOption_stock(rs.getInt("OPTION_STOCK"));
			ar.add(productOptionDTO);
		}
		
		DBConnection.disConnection(rs, st, connection);
		
		return ar;
	}
	
	//setAddProductOption
	public int setAddProductOption(ProductOptionDTO productOptionDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		
		String sql = "INSERT INTO PRODUCT_OPTION (OPTION_NUM, PRODUCT_NUM, OPTION_NAME, OPTION_PRICE, OPTION_STOCK "
				+ "VALUES (OPTION_SEQ.NEXTVAL, ?, ?, ?, 0.0)";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
//		st.setLong(1, productOptionDTO.getProduct_num());
		st.setString(1, productOptionDTO.getOption_name());
		st.setInt(2, productOptionDTO.getOption_price());
		st.setInt(3, productOptionDTO.getOption_stock());
		
		int result = st.executeUpdate();
		
		DBConnection.disConnection(st, connection);
		
		return result;
	}
	
	//-------------------------------------------------------
	
	public List<ProductDTO> getProductList() throws Exception {
		ArrayList<ProductDTO> ar = new ArrayList<ProductDTO>();
		
		Connection connection = DBConnection.getConnection();
		
		String sql = "SELECT PRODUCT_NUM, PRODUCT_NAME, PRODUCT_SCORE "
				+ "FROM PRODUCT ORDER BY PRODUCT_SCORE DESC";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setProduct_num(rs.getLong("PRODUCT_NUM"));
			productDTO.setProduct_name(rs.getString("PRODUCT_NAME"));
			productDTO.setProduct_score(rs.getDouble("PRODUCT_SCORE"));
			ar.add(productDTO);
	      }
		
		return ar;
	}
	
	//setAddProduct
	public int setAddProduct(ProductDTO productDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
				
		String sql = "INSERT INTO PRODUCT (PRODUCT_NUM, PRODUCT_NAME, PRODUCT_DETAIL, PRODUCT_SCORE) "
				+ "VALUES (?, ?, ?, ?)";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setLong(1, productDTO.getProduct_num());
		st.setString(2, productDTO.getProduct_name());
		st.setString(3, productDTO.getProduct_detail());
		st.setDouble(4, productDTO.getProduct_score());
		
		int result = st.executeUpdate();
		
		DBConnection.disConnection(st, connection);
		
		return result;
	}
	
	//Test
	public static void main(String[] args) {
		ProductDAO productDAO = new ProductDAO();
		ProductDTO productDTO = new ProductDTO();
		
		try {
			List<ProductOptionDTO> ar = productDAO.getProductOptionList();
			System.out.println(ar.size() == 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
