package com.zdsoft.edu.aspect.operlog;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.zdsoft.edu.dto.log.OperateLogDto;
import com.zdsoft.edu.dto.user.UserDto;
import com.zdsoft.edu.service.log.OperateLogService;

@Component
@Aspect
public class OperLogAspect {
	
	private static Logger logger = LogManager.getLogger(OperLogAspect.class.getName());

	@Autowired
	private OperateLogService operateLogService;
	
	//配置接入点,如果不知道怎么配置,可以百度一下规则
    @Pointcut("execution(* com.zdsoft.edu.controller..*.*(..))")  
    private void controllerAspect(){}//定义一个切入点

    @Around("controllerAspect()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
    	
    	logger.info("===go into around==="+pjp.getSignature());
    	Object object = null;
    	object= pjp.proceed();
    	logger.info("===after method execute==="+object);
        //常见日志实体对象
    	OperateLogDto log = new OperateLogDto(); 
        //获取登录用户账户
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        UserDto user = (UserDto) request.getSession().getAttribute("userInfo");
        log.setUserid(user.getUserid());
        Date nowDate=new Date();
        //获取系统时间
        String time = new SimpleDateFormat("dd").format(nowDate);
        if(time.startsWith("0"))
        	log.setTableName("t_operate_log_"+time.substring(1));
        else
        	log.setTableName("t_operate_log_"+time);
        	
        log.setCreatetime(nowDate);
        //获取系统ip,这里用的是我自己的工具类,可自行网上查询获取ip方法
       // String ip = GetLocalIp.localIp();
        log.setIpaddr(request.getRemoteAddr());
        log.setLogcontent("登录成功");
        log.setLogtype((short)1);
        logger.info("===log createtime==="+log.getCreatetime());
        operateLogService.insert(log);
       //方法通知前获取时间,为什么要记录这个时间呢？当然是用来计算模块执行时间的
        long start = System.currentTimeMillis();
       // 拦截的实体类，就是当前正在执行的controller
       Object target = pjp.getTarget();
       // 拦截的方法名称。当前正在执行的方法
       String methodName = pjp.getSignature().getName();
       // 拦截的方法参数
       Object[] args = pjp.getArgs();
       // 拦截的放参数类型
       Signature sig = pjp.getSignature();
       MethodSignature msig = null;
       if (!(sig instanceof MethodSignature)) {
           throw new IllegalArgumentException("该注解只能用于方法");
       }
       msig = (MethodSignature) sig;
       Class[] parameterTypes = msig.getMethod().getParameterTypes();
       
       
       // 获得被拦截的方法
      /* Method method = null;
       try {
           method = target.getClass().getMethod(methodName, parameterTypes);
       } catch (NoSuchMethodException e1) {
           // TODO Auto-generated catch block
           e1.printStackTrace();
       } catch (SecurityException e1) {
           // TODO Auto-generated catch block
           e1.printStackTrace();
       }
       if (null != method) {
           // 判断是否包含自定义的注解，说明一下这里的SystemLog就是我自己自定义的注解
           if (method.isAnnotationPresent(SystemLog.class)) {
               SystemLog systemlog = method.getAnnotation(SystemLog.class);
               log.setMODULE(systemlog.module());
               log.setMETHOD(systemlog.methods());
               try {
                   object = pjp.proceed();
                   long end = System.currentTimeMillis();
                   //将计算好的时间保存在实体中
                   log.setRSPONSE_DATA(""+(end-start));
                   log.setCOMMITE("执行成功！");
                   //保存进数据库
                   logservice.saveLog(log);
               } catch (Throwable e) {
                   // TODO Auto-generated catch block
                   long end = System.currentTimeMillis();
                   log.setRSPONSE_DATA(""+(end-start));
                   log.setCOMMITE("执行失败");
                   logservice.saveLog(log);
               }
           } else {//没有包含注解
               object = pjp.proceed();
           }
       } else { //不需要拦截直接执行
           object = pjp.proceed();
       }*/
       return object;
    }
	
}
