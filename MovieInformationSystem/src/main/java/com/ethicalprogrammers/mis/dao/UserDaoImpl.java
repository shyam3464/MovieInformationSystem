/**
 * @author praveen 
 * 
 */

package com.ethicalprogrammers.mis.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ethicalprogrammers.mis.model.User;

public class UserDaoImpl implements UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public User retrieveUser(String userName, String password) {
		User result = null;
		try {
			result = jdbcTemplate.queryForObject("SELECT USER_NAME, PASSWORD, EMAIL, USER_TYPE FROM USER where USER_NAME = ? and PASSWORD = ?", new UserRowMapper(), userName, password);			
		} catch (EmptyResultDataAccessException e) {
			
		}
		return result;
	}
	
	@Override
	public User retrieveUserByNameEmailType(String userName, String email) {
		User result = null;
		try {
			result = jdbcTemplate.queryForObject("SELECT USER_NAME, PASSWORD, EMAIL, USER_TYPE FROM USER where USER_NAME = ? and EMAIL = ? AND USER_TYPE = ?", new UserRowMapper(), userName, email, "customer");			
		} catch (EmptyResultDataAccessException e) {
			
		}
		return result;
	}
	
	@Override
	public boolean createUser(User user) {
		int numRows=0;
		String inserQuery = "insert into USER ( USER_NAME, PASSWORD, EMAIL , USER_TYPE) values ( ?, ?, ?,'customer') ";
		Object[] params = new Object[] { user.getUserName(),
		user.getPassword(), user.getEmail() };
		numRows = jdbcTemplate.update(inserQuery, params);
		return numRows == 1 ? true : false;
	}
	
	public class UserRowMapper implements RowMapper<User> {

		@Override
		public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			User obj = new User();
			obj.setUserName(resultSet.getString("USER_NAME"));
			obj.setPassword(resultSet.getString("PASSWORD"));
			obj.setEmail(resultSet.getString("EMAIL"));
			obj.setUserType(resultSet.getString("USER_TYPE"));
			return obj;
		}
		
	}


}
