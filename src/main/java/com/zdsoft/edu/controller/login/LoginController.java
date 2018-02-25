package com.zdsoft.edu.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.ModelAndView;

import com.zdsoft.edu.dto.user.UserDto;
import com.zdsoft.edu.service.user.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	private static Logger logger = LogManager.getLogger(LoginController.class.getName());
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/{id}/login",method=RequestMethod.POST,params={"username"})
	public ModelAndView login(@RequestParam(required=false,defaultValue="0") String username , @RequestParam String password, HttpServletRequest request,@PathVariable("id") Integer id)
	{ 
		
		System.out.println("id======"+id);
		HttpSession session=request.getSession();
		ModelAndView mv = new ModelAndView("/home");
		UserDto user=userService.selectByUsername(username);
		logger.info("========="+user.getUsername());
		if(user.getPasswd().equalsIgnoreCase(password))
			session.setAttribute("userInfo", user);
		
		return mv;
	}
	
	public ModelAndView login1(@RequestParam String username , @RequestParam String password, HttpServletRequest request)
	{
		HttpSession session=request.getSession();
		ModelAndView mv = new ModelAndView("/home");
		UserDto user=userService.selectByUsername(username);
		logger.info("=========11111"+user.getUsername());
		if(user.getPasswd().equalsIgnoreCase(password))
			session.setAttribute("userInfo", user);
		
		return mv;
	}

}
