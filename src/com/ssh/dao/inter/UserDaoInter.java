package com.ssh.dao.inter;

import java.util.List;

import com.ssh.bean.Admin_User;

public interface UserDaoInter {
	
	/**
	 *   ����Ա��¼�ӿ�
	 * @param username
	 * @param password
	 * @return
	 */
	public Admin_User login(String username,String password);
	/**
	 *  ���ҵ���bean
	 * @param id
	 * @return
	 */
	public Admin_User findAdminUser(int id);
	/**
	 *   �޸Ľӿ�
	 * @param ad
	 */
	public void updateAdminUser(Admin_User ad);
	
	/**
	 * ���
	 * @param ad
	 */
	public void addAdminUser(Admin_User ad);
	
	/**
	 * ��ѯ����
	 */
	public List<Admin_User> selectAdUser();

}
