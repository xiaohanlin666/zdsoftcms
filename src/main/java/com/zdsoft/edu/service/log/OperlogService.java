package com.zdsoft.edu.service.log;

import com.zdsoft.edu.dto.log.OperlogDto;

public interface OperlogService {
	
	public Long insertOperlog(OperlogDto operlogDto);

}
