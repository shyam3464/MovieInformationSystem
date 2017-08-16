/**
 * @author praveen
 * 
 */
package com.ethicalprogrammers.mis.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ethicalprogrammers.mis.dao.UserDao;
import com.ethicalprogrammers.mis.model.User;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	@Override
	public User checkUser(User user) {
		User userObject = userDao.retrieveUser(user.getUserName(), user.getPassword());
		return userObject;
	}
	@Override
	public boolean createUser(User user) {
		boolean status = false;
		if (!checkIfUserExisists(user)) {
			status = userDao.createUser(user);
		}
		return status;
	}
	
	private boolean checkIfUserExisists(User user) {
		User userFromDb = userDao.retrieveUserByNameEmailType(user.getUserName(), user.getEmail());
		if (null != userFromDb) return true;
		else return false;
	}
	
	
}
