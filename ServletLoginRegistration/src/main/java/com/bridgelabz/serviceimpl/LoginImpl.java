/*
 * created by:Nayan Kumar
 * purpose:to fetch data from database
 */
package com.bridgelabz.serviceimpl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bridgelabz.model.LoginModel;
import com.bridgelabz.service.LoginInf;

public class LoginImpl implements LoginInf{
	private static Logger log = LogManager.getLogger(LoginImpl.class);
	Connection con = null;
	PreparedStatement pstmt=null;
	ResultSet rs = null;
	String qry = "select * from mydatabase.userRegister where name=? and password=?";

	/*
	 * Overriding the method to fetch the data and returns true if present
	 */
	@Override
	public boolean fetchData(LoginModel lmodel) {
		try
		{
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?useSSL=false","root","root");
			pstmt=con.prepareStatement(qry);
			pstmt.setString(1, lmodel.getName());
			pstmt.setString(2,lmodel.getPassword());
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				return true;
			}

		}catch(SQLException e)
		{
			log.error("connection not possible");
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
					log.error(e);
				}
			}
			if(pstmt!=null)
			{
				try
				{
					pstmt.close();
				}catch(SQLException e)
				{
				log.error(e);
				}
			}
			if(con!=null)
			{
				try
				{
					con.close();
				}catch(SQLException e)
				{
					log.error(e);
				}
			}
		}
		return false;


	}
}
