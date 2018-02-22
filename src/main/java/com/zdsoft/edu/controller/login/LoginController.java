package com.zdsoft.edu.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zdsoft.edu.dto.user.UserDto;
import com.zdsoft.edu.service.user.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	private static Logger logger = LogManager.getLogger(LoginController.class.getName());
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public ModelAndView login(@RequestParam String username , @RequestParam String password, HttpServletRequest request)
	{
		HttpSession session=request.getSession();
		ModelAndView mv = new ModelAndView("/home");
		UserDto user=userService.selectByUsername(username);
		logger.info("========="+user.getUsername());
		if(user.getPasswd().equalsIgnoreCase(password))
			session.setAttribute("userInfo", user);
		
		return mv;
	}

}
