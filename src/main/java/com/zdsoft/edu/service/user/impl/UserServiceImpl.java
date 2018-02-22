package com.zdsoft.edu.service.user.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zdsoft.edu.dao.user.UserDao;
import com.zdsoft.edu.dto.user.UserDto;
import com.zdsoft.edu.service.user.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;

	@Override
	public int insert(UserDto record) {
		// TODO Auto-generated method stub
		return userDao.insert(record);
	}

	@Override
	public List<UserDto> selectAll() {
		// TODO Auto-generated method stub
		return userDao.selectAll();
	}

	@Override
	public UserDto selectByUsername(String username) {
		// TODO Auto-generated method stub
		return userDao.selectByUsername(username);
	}
	
	

}
