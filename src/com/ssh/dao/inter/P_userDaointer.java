package com.ssh.dao.inter;

import java.util.List;

import com.ssh.bean.Dept;
import com.ssh.bean.P_user;

public interface P_userDaointer {
	/**
	 * �����Ա
	 * @param puser
	 */
	public void addPuser(P_user puser,int dept_id);
	/**
	 * ����
	 * @return
	 */
	public int counts();
	
	/**
	 * ��Ա�б��ҳ
	 * @param start
	 * @param pageSize
	 * @return
	 */
	public List<P_user> pagePuser(int start,int pageSize);
	
	/**
	 * ɾ����Ա
	 * @param id
	 */
	public void del_puser(int id);
	
	/**
	 * ����id��ѯ
	 * @param id
	 * @return
	 */
	public P_user findidu(int id);
	/**
	 * ������Ա
	 * @param pu
	 */
	public void updatuser(P_user pu);
	
	public List<P_user> searchuser(String names);
	
	/**
	 * �޸���Ա����
	 * @param dept_id �޸ĵ��²��ŵ�id
	 * @param p Ҫ�޸ĵ���Աid
	 */
	public void updatedpu(int dept_id,int p);
}
