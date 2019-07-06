package com.ssh.dao.inter;

import java.util.List;
import com.ssh.bean.Login_log;

public interface LogDaoInter {
	/**
	 * 	µÇÂ¼ÈÕÖ¾dao
	 * @param log
	 */
	public void addLog(Login_log log);
	
	public List<Login_log> getip();

}
