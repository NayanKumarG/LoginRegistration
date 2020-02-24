/*
 * created by:Nayan Kumar
 * 
 * purpose:implementation to fetch the data from database
 * 
 */
package com.bridgelabz.serviceimpl;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bridgelabz.dao.DBConnection;
import com.bridgelabz.model.Users;
import com.bridgelabz.service.UserInf;

public class UsersDao implements UserInf{
private static Logger log = LogManager.getLogger(UsersDao.class);
	
	/*
	 * method which returns the list of user
	 */
	@Override
	public List<Users> getUsers(int start , int total) {
		List<Users> users = new ArrayList<Users>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String qry = ("select * from mydatabase.userRegister limit "+(start-1)+","+total);
		try
		{

			pstmt = DBConnection.getConnection().prepareStatement(qry);
		    rs = pstmt.executeQuery();
		    while(rs.next())
		    {
		    	Users user = new Users();
		    	user.setName(rs.getString(1));
		    	user.setMailid(rs.getString(3));
		    	user.setCity(rs.getString(4));
		    	user.setAge(rs.getInt(5));
		    	user.setPhno(rs.getString(6));
		    	users.add(user);
		    }
		}catch(SQLException e)
		{
			log.error("connection not possible");
		}finally
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
	
		}
		return users;
	}

}
