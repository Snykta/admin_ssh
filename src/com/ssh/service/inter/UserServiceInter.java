package com.ssh.service.inter;

import com.ssh.bean.Admin_User;

/**
 * service层接口
 * @author snykt
 *
 */
public interface UserServiceInter {
	
	/**
	 * 管理员service登录
	 * @param username
	 * @param password
	 * @return
	 */
	public String login(String username,String password);
	/**
	 *   修改用户信息
	 * @param ad
	 */
	public String updateAdminUser(Admin_User ad,int id);
	/**
	 *   修改用户密码
	 * @param ad
	 * @param id
	 * @return
	 */
	public String updateAdminpass(Admin_User ad,int id);
	/**
	 * 退出登录
	 * @return
	 */
	public String loginOut();
	
	public String addAdminUser(Admin_User ad,String code);
	
	public String selectAuser();

}
