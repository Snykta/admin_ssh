package com.ssh.service.inter;

import com.ssh.bean.Dept;

public interface DeptServiceInter {
	
	public String selectDept();
	
	public String counts();
	
	public String pagedept(int start,int pageSize);
	
	public String deldept(int id);
	
	public String adddept(Dept d);
	
	public String findid(int id);
	public String updatedept(Dept d , int id);

}
