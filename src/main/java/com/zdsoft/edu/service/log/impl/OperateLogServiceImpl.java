package com.zdsoft.edu.service.log.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zdsoft.edu.dao.log.OperateLogDao;
import com.zdsoft.edu.dto.log.OperateLogDto;
import com.zdsoft.edu.service.log.OperateLogService;

@Service
public class OperateLogServiceImpl implements OperateLogService{
	
	@Autowired
	private OperateLogDao operateLogDao;

	@Override
	public int insert(OperateLogDto record) {
		// TODO Auto-generated method stub
		return operateLogDao.insert(record);
	}

	@Override
	public int insertSelective(OperateLogDto record) {
		// TODO Auto-generated method stub
		return operateLogDao.insertSelective(record);
	}

}
