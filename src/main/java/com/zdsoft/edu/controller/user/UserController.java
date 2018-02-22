package com.zdsoft.edu.controller.user;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zdsoft.edu.dto.log.OperlogDto;
import com.zdsoft.edu.dto.user.UserDto;
import com.zdsoft.edu.service.log.OperlogService;
import com.zdsoft.edu.service.user.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private static Logger logger = LogManager.getLogger(UserController.class.getName());
	
	@Autowired
	private UserService userService;
	@Autowired
	private OperlogService operlogService;
	
	@RequestMapping("/list")
	public ModelAndView list(){
		ModelAndView mv = new ModelAndView("/user/userList");
		
		OperlogDto operlogDto=new OperlogDto();
		long start=System.currentTimeMillis();
		logger.info("start==="+start);
		for(int i=0;i<2500;i++)
		{
		operlogDto.setCreatetime(new Date());
		operlogDto.setLogcontent("这是一个日志111212"+i);
		operlogDto.setLoginfo("日志121"+i);
		operlogDto.setLogtype(1);
		
		
		Long logid=operlogService.insertOperlog(operlogDto);
		}
		long after=System.currentTimeMillis();
		logger.info("after======"+after);
		logger.info("after-start======"+(after-start));
		
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 Map map =new HashMap();
	     try {
			map.put("createtime", df.parse("2017-04-21 00:30:28"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			logger.error("",e);
		}
		logger.info("======"+userService);
		List<UserDto> list=userService.selectAll();
		//list.get(2).setCreatetime(new Date());
		mv.addObject("list",list );
		return mv;
	}

}
