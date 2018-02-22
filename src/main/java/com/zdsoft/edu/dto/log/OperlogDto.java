package com.zdsoft.edu.dto.log;

import java.util.Date;

public class OperlogDto {
	private Long logid;
	
	private Integer logtype;
	
	private String logcontent;
	
	private Date createtime;
	
	private String loginfo;

	public Long getLogid() {
		return logid;
	}

	public void setLogid(Long logid) {
		this.logid = logid;
	}

	public Integer getLogtype() {
		return logtype;
	}

	public void setLogtype(Integer logtype) {
		this.logtype = logtype;
	}

	public String getLogcontent() {
		return logcontent;
	}

	public void setLogcontent(String logcontent) {
		this.logcontent = logcontent;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getLoginfo() {
		return loginfo;
	}

	public void setLoginfo(String loginfo) {
		this.loginfo = loginfo;
	}
	
	
	
	

}
