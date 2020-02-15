/*
 * created by:Nayan Kumar
 * 
 * purpose:interface to get user details
 * 
 */
package com.bridgelabz.service;

import java.util.List;

import com.bridgelabz.model.Users;

public interface UserInf {
	
	List<Users> getUsers(int start , int total);

}
