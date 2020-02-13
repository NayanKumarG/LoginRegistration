/*
 * created by:Nayan Kumar
 * purpose:to save data into database
 */
package com.bridgelabz.serviceimpl;
import java.sql.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bridgelabz.model.RegistrationModel;
import com.bridgelabz.service.RegistrationInf;

public class RegistrationImpl implements RegistrationInf{
	private static Logger log = LogManager.getLogger(RegistrationImpl.class);
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String qry = "insert into mydatabase.userRegister values(?,?,?,?,?,?)";
	/*
	 * overriding method to save data into database
	 */
	@Override
	public void saveData(RegistrationModel rmodel) {
		try {
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?useSSL=false","root","root");
			pstmt = con.prepareStatement(qry);
			pstmt.setString(1,rmodel.getName());
			pstmt.setString(2, rmodel.getPassword());
			pstmt.setString(3, rmodel.getMail());
			pstmt.setString(4, rmodel.getCity());
			pstmt.setInt(5, rmodel.getAge());
			pstmt.setString(6, rmodel.getPhno());
			pstmt.executeUpdate();

		}catch (SQLException e) {
			log.error("connection failed");
		}
		finally
		{
			if(rs!=null)
			{
				try
				{
					rs.close();
				}catch(SQLException e)
				{
					log.error("Resource not closed");
				}
			}
			if(pstmt!=null)
			{
				try
				{
					pstmt.close();

				}catch(SQLException e)
				{
					log.error("Statement resource not closed");
				}
			}
			if(con!=null)
			{
				try
				{
					con.close();

				}catch(SQLException e)
				{
					log.error("Connection resource not closed");
				}
			}
		}


	}

}
