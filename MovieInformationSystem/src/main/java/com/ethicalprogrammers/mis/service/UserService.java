/**
 * @author praveen
 * 
 */
package com.ethicalprogrammers.mis.service;

import com.ethicalprogrammers.mis.model.User;

public interface UserService {
	
	public User checkUser(User user);
	
	public boolean createUser(User user);

}
