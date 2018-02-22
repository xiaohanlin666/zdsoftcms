package com.zdsoft.edu.service.log.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zdsoft.edu.dao.log.OperlogDao;
import com.zdsoft.edu.dto.log.OperlogDto;
import com.zdsoft.edu.service.log.OperlogService;

@Service
public class OperlogServiceImpl implements OperlogService{
	@Autowired
	private OperlogDao operlogDao;

	@Override
	public Long insertOperlog(OperlogDto operlogDto) {
		// TODO Auto-generated method stub
		return operlogDao.insertOperlog(operlogDto);
	}

}
