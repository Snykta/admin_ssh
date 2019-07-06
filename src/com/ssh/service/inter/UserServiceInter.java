package com.ssh.service.inter;

import com.ssh.bean.Admin_User;

/**
 * service��ӿ�
 * @author snykt
 *
 */
public interface UserServiceInter {
	
	/**
	 * ����Աservice��¼
	 * @param username
	 * @param password
	 * @return
	 */
	public String login(String username,String password);
	/**
	 *   �޸��û���Ϣ
	 * @param ad
	 */
	public String updateAdminUser(Admin_User ad,int id);
	/**
	 *   �޸��û�����
	 * @param ad
	 * @param id
	 * @return
	 */
	public String updateAdminpass(Admin_User ad,int id);
	/**
	 * �˳���¼
	 * @return
	 */
	public String loginOut();
	
	public String addAdminUser(Admin_User ad,String code);
	
	public String selectAuser();

}
