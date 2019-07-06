package com.ssh.dao.inter;

import java.util.List;

import com.ssh.bean.Dept;
import com.ssh.bean.P_user;

public interface DeptDaoInter {
	
	/**
	 * ����ID��ѯ
	 * @param id
	 * @return
	 */
	public Dept findId(int id);
	
	/**
	 * ��ѯ���в���
	 * @return
	 */
	public List<Dept> selectdept();
	
	/**
	 * ����
	 * @return
	 */
	public int counts();
	
	/**
	 * ���ŷ�ҳ
	 * @param start
	 * @param pageSize
	 * @return
	 */
	public List<Dept> pagedept(int start,int pageSize);
	
	public void deldept(int id);
	
	public void adddept(Dept d);
	
	public void updatedept(Dept d);

}
