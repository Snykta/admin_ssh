package com.ssh.dao.inter;

import java.util.List;

import com.ssh.bean.Dept;
import com.ssh.bean.P_user;

public interface P_userDaointer {
	/**
	 * 添加人员
	 * @param puser
	 */
	public void addPuser(P_user puser,int dept_id);
	/**
	 * 总数
	 * @return
	 */
	public int counts();
	
	/**
	 * 人员列表分页
	 * @param start
	 * @param pageSize
	 * @return
	 */
	public List<P_user> pagePuser(int start,int pageSize);
	
	/**
	 * 删除人员
	 * @param id
	 */
	public void del_puser(int id);
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public P_user findidu(int id);
	/**
	 * 更新人员
	 * @param pu
	 */
	public void updatuser(P_user pu);
	
	public List<P_user> searchuser(String names);
	
	/**
	 * 修改人员部门
	 * @param dept_id 修改的新部门的id
	 * @param p 要修改的人员id
	 */
	public void updatedpu(int dept_id,int p);
}
