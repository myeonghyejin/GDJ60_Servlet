package com.mhj.home.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mhj.home.util.DBConnection;

public class MemberDAO {
	
	//setAddMember
	public int setAddMember(MemberDTO memberDTO) throws Exception {
		//1.
		Connection connection = DBConnection.getConnection();
		
		//2.
		String sql = "INSERT INTO MEMBER (MEMBER_ID, MEMBER_PW, MEMBER_NAME, MEMBER_ADDRESS, MEMBER_PHONE, MEMBER_EMAIL) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		
		//3.
		PreparedStatement st = connection.prepareStatement(sql);
		
		//4.
		st.setString(1, memberDTO.getMember_id());
		st.setString(2, memberDTO.getMember_pw());
		st.setString(3, memberDTO.getMember_name());
		st.setString(4, memberDTO.getMember_address());
		st.setString(5, memberDTO.getMember_phone());
		st.setString(6, memberDTO.getMember_email());
		
		//5.
		int result = st.executeUpdate();
		
		//6.
		DBConnection.disConnection(st, connection);
		
		//7.
		return result;
	}

	//Test
	public static void main(String[] args) {
		MemberDAO memberDAO = new MemberDAO();
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setMember_id("ID1");
		memberDTO.setMember_pw("PW1");
		memberDTO.setMember_name("a");
		memberDTO.setMember_address("Address1");
		memberDTO.setMember_phone("010-0000-0000");
		memberDTO.setMember_email("a@gmail.com");
		try {
			int result = memberDAO.setAddMember(memberDTO);
			System.out.println(result != 0);	//result == 1
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
