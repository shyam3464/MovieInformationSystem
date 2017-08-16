/**
 * @author praveen
 * 
 */
package com.ethicalprogrammers.mis.dao;

import com.ethicalprogrammers.mis.model.User;

public interface UserDao {

	public User retrieveUser(String userName, String password);
	
	public User retrieveUserByNameEmailType(String userName, String email);
	
	public boolean createUser(User user);

}
