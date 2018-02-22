package com.zdsoft.edu.service.log;

import com.zdsoft.edu.dto.log.OperateLogDto;

public interface OperateLogService {
	
	int insert(OperateLogDto record);

	
	int insertSelective(OperateLogDto record);

}
