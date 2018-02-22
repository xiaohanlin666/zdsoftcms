package com.zdsoft.edu.service.user;

import java.util.List;
import java.util.Map;

import com.zdsoft.edu.dto.user.UserDto;

public interface UserService {
	int insert(UserDto record);
	
	 List<UserDto> selectAll();
	 
	 UserDto selectByUsername(String username);

}
