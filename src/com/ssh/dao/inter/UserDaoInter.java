package com.ssh.dao.inter;

import java.util.List;

import com.ssh.bean.Admin_User;

public interface UserDaoInter {
	
	/**
	 *   管理员登录接口
	 * @param username
	 * @param password
	 * @return
	 */
	public Admin_User login(String username,String password);
	/**
	 *  查找单个bean
	 * @param id
	 * @return
	 */
	public Admin_User findAdminUser(int id);
	/**
	 *   修改接口
	 * @param ad
	 */
	public void updateAdminUser(Admin_User ad);
	
	/**
	 * 添加
	 * @param ad
	 */
	public void addAdminUser(Admin_User ad);
	
	/**
	 * 查询所有
	 */
	public List<Admin_User> selectAdUser();

}
