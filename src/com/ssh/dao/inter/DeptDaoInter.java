package com.ssh.dao.inter;

import java.util.List;

import com.ssh.bean.Dept;
import com.ssh.bean.P_user;

public interface DeptDaoInter {
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	public Dept findId(int id);
	
	/**
	 * 查询所有部门
	 * @return
	 */
	public List<Dept> selectdept();
	
	/**
	 * 总数
	 * @return
	 */
	public int counts();
	
	/**
	 * 部门分页
	 * @param start
	 * @param pageSize
	 * @return
	 */
	public List<Dept> pagedept(int start,int pageSize);
	
	public void deldept(int id);
	
	public void adddept(Dept d);
	
	public void updatedept(Dept d);

}
