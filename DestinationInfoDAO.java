package com.internousdev.olive.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.olive.dto.DestinationInfoDTO;
import com.internousdev.olive.util.DBConnector;

public class DestinationInfoDAO {

	//宛先情報入力
	public int createDestination(String userId,String familyName, String firstName, String familyNameKana, String firstNameKana,String email, String telNumber, String userAddress) {

		DBConnector dbConnector = new DBConnector();
		Connection con = dbConnector.getConnection();

		int count=0;

		String sql = "INSERT INTO destination_info (user_id,family_name,first_name,family_name_kana,first_name_kana,email,tel_number,user_address,regist_date,update_date) VALUES(?,?,?,?,?,?,?,?,now(),now())";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, familyName);
			ps.setString(3, firstName);
			ps.setString(4, familyNameKana);
			ps.setString(5, firstNameKana);
			ps.setString(6, email);
			ps.setString(7, telNumber);
			ps.setString(8, userAddress);

			count=ps.executeUpdate();

		} catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();

			}catch(SQLException e){
				e.printStackTrace();
			}
		}return count;

	}

	//宛先情報選択
	public List<DestinationInfoDTO>getDestinationInfo(String userId){

		DBConnector dbConnector = new DBConnector();
		Connection con = dbConnector.getConnection();

		List<DestinationInfoDTO> destinationInfoDTOList =new ArrayList<DestinationInfoDTO>();

		String sql="SELECT id,family_name,first_name,family_name_kana,first_name_kana,email,tel_number,user_address FROM destination_info WHERE user_id = ?";

		try {
			PreparedStatement ps;

			ps=con.prepareStatement(sql);
			ps.setString(1, userId);

			ResultSet rs=ps.executeQuery();

			while(rs.next()) {
				DestinationInfoDTO destinationInfoDTO = new DestinationInfoDTO();
				destinationInfoDTO.setId(rs.getInt("id"));
				destinationInfoDTO.setFamilyName(rs.getString("family_name"));
				destinationInfoDTO.setFirstName(rs.getString("first_name"));
				destinationInfoDTO.setEmail(rs.getString("email"));
				destinationInfoDTO.setFamilyNameKana(rs.getString("family_name_kana"));
				destinationInfoDTO.setFirstNameKana(rs.getString("first_name_kana"));
				destinationInfoDTO.setTelNumber(rs.getString("tel_number"));
				destinationInfoDTO.setUserAddress(rs.getString("user_address"));
				destinationInfoDTOList.add(destinationInfoDTO);
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {

			try {
				con.close();

			}catch(SQLException e) {
				e.printStackTrace();

			}
		}
		return destinationInfoDTOList;

	}

	//宛先情報削除
	public int deleteDestination(String id) {
		DBConnector dbConnector = new DBConnector();
		Connection con = dbConnector.getConnection();

		String sql = "DELETE from destination_info where id=?";

		int count=0;

		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, id);

			count=ps.executeUpdate();

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();

			}catch(SQLException e){
				e.printStackTrace();
			}

		}
		return count;

	}

}