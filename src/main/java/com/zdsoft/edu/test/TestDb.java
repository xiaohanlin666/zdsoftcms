package com.zdsoft.edu.test;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.zdsoft.edu.dto.order.OrderDto;
import com.zdsoft.edu.dto.user.UserDto;
import com.zdsoft.edu.service.order.OrderService;
import com.zdsoft.edu.service.user.UserService;

public class TestDb {
	private static Logger logger = LogManager.getLogger(TestDb.class.getName());
	 private ApplicationContext ac = null; 
	    public static void main(String[] args) {
	        TestDb test=new TestDb();
	        test.orderAddTest();
	    }
	    public void before() {  
	     // ac = new FileSystemXmlApplicationContext("classpath:applicationContext.xml"); //引入配置文件 
	      ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	     UserService userService= (UserService) ac.getBean("userServiceImpl");//需要注意这里的customerService 是在service中使用@Service（“customerService”）一致
	     UserDto userDto=new  UserDto();
	     long before=System.currentTimeMillis();
	     logger.info("before time==="+before);
	     for(int i=0;i<1000;i++)
	     {
	     userDto.setCreatetime(new Date());
	     userDto.setPasswd(i+10+"");
	     userDto.setUsername("测试雅虎哇哈哈"+i);
	     userDto.setSex((byte)1);
	     userDto.setLockstatus((byte)2);
	     userService.insert(userDto);
	     }
	     long after=System.currentTimeMillis();
	     logger.info("excute time==="+(after-before));
	     
	     DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	     
	     Map map =new HashMap();
	     try {
			map.put("createtime", df.parse("2017-04-21 00:30:28"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			logger.error("",e);
		}
	    
	    /*  CustomerService TellerService= (CustomerService) ac.getBean("TellerService");
	      System.out.println(TellerService);*/
	  } 
	    
	    
	    
	    public void orderAddTest()
	    {
	    	ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	    	
	    	OrderDto order =new OrderDto();
	    	order.setAddressdesc("重庆星光五路三号");
	    	order.setOrderamount(new BigDecimal(16.18));
	    	order.setOrdertime(new Date());
	    	order.setPaymenttype((byte)1);
	    	order.setReceivemobile("15320588851");
	    	order.setReceivename("肖翰林");
	    	order.setStatus((byte)1);
	    	order.setUserid(1l);
	    	
	    	
	    	OrderService orderService=(OrderService)ac.getBean("orderServiceImpl");
	    	
	    	orderService.addOrder(order);
	    	
	    }

}
