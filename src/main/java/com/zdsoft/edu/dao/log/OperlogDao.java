package com.zdsoft.edu.dao.log;

import com.zdsoft.edu.dto.log.OperlogDto;

public interface OperlogDao {
	
	public Long insertOperlog(OperlogDto operlogDto);

}
