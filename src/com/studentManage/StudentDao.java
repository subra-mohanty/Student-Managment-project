package com.studentManage;


import java.sql.*;
public class StudentDao {
	public static boolean insertStudentRecordToDB(Student st) {
		boolean f = false;
		try {
			Connection con = CP.createc();
			String query = "insert into students(sid,sname,sphone,scity) values(?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			//set the value of parameters
			pstmt.setInt(1, st.getStudentID());
			pstmt.setString(2, st.getStudentName());
			pstmt.setString(3, st.getStudentPhone());
			pstmt.setString(4, st.getStudentCity());
			
			//execute..
			pstmt.executeUpdate();
			
			f = true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return f;
	}


	public static boolean deleteStudentRecordFromDB(int userID) {
		
		boolean f = false;
		try {
			Connection con = CP.createc();
			String query = "delete from students where sid=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			//set the value of parameters
			pstmt.setInt(1, userID);
			
			//execute..
			pstmt.executeUpdate();
			
			f = true;
		} catch (Exception e) {
			
		}
		return f;
	}


	public static void showAllStudentRecords() {
		// TODO Auto-generated method stub
		boolean f = false;
		try {
			Connection con = CP.createc();
			String query = "select * from students";
			Statement st = con.createStatement();
			ResultSet set = st.executeQuery(query);
			
			while(set.next()) {
				int id = set.getInt(1);
				String name = set.getString(2);
				String phone = set.getString(3);
				String city = set.getString("scity");
				
				System.out.println("Student ID: " + id + " \n Student Name: " + name + " \nStudent Phone: " + phone + " \nStudent city: " + city);
				System.out.println("----------------------------------------------");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}


	public static boolean updateStudentRecord(int val,String toUpdate,int id,Student st) {
		// TODO Auto-generated method stub
		boolean f = false;
		
		try {
			  Connection con = CP.createc();
			 if(val == 1) {
					//Update Name
					
						String query = "update students set sname=? where sid=?";
						PreparedStatement pstmt = con.prepareStatement(query);
						pstmt.setString(1, toUpdate);
						pstmt.setInt(2, id);
						
						//execute..
						pstmt.executeUpdate();
						f = true;
				}
				else if(val == 2) {
					//Update Phone
					String query = "update students set sphone=? where sid=?";
					PreparedStatement pstmt = con.prepareStatement(query);
					pstmt.setString(1, toUpdate);
					pstmt.setInt(2, id);
					
					//execute..
					pstmt.executeUpdate();
					f = true;
				}
				else if(val == 3) {
					//Update City
					String query = "update students set scity=? where sid=?";
					PreparedStatement pstmt = con.prepareStatement(query);
					pstmt.setString(1, toUpdate);
					pstmt.setInt(2, id);
					
					//execute..
					pstmt.executeUpdate();
					f = true;
				}
				else {
					
				}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return f;
	}
}