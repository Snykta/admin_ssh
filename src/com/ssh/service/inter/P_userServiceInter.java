package com.ssh.service.inter;

import com.ssh.bean.P_user;

public interface P_userServiceInter {
	
	public String addpuser(P_user puser,int id);
	
	public String counts();
	
	public String pagepuser(int start,int pageSize);
	
	public String del_puser(int id);
	
	public String findId(int id);
	
	public String updateuser(P_user pu,int id);
	
	public String searchuser(String names);
	
	public String updateUserdept(int dept_id,int p);

}
