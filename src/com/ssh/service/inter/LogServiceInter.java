package com.ssh.service.inter;


public interface LogServiceInter {
	/**
	 * 登录成功后添加日志
	 */
	public void addLog();
	
	/**
	 * 查询数据库登录log
	 * @return
	 */
	public String getIp();

}
