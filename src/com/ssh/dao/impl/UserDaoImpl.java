package com.ssh.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.ssh.bean.Admin_User;
import com.ssh.dao.inter.UserDaoInter;

@Repository("userimpl")//注解方式bean
public class UserDaoImpl extends HibernateDaoSupport implements UserDaoInter {
	
	@Resource(name="sessionFactory")//注入
	public void setHibernateSessionFactroy(SessionFactory sessionFactory){
		this.setSessionFactory(sessionFactory);
	}

	@Override
	public Admin_User login(String username, String password) {
		String sql = "select u from Admin_User u where u.users = ? and u.password = ?";
		List<Admin_User> userlist = (List<Admin_User>) this.getHibernateTemplate().find(sql, username,password);
		if(userlist!=null&&userlist.size()>0) {
			return userlist.get(0);
		}else {
			return null;
		}
		
	}

	@Override
	public Admin_User findAdminUser(int id) {
		Admin_User u = this.getHibernateTemplate().get(Admin_User.class, id);
		return u;
	}

	@Override
	public void updateAdminUser(Admin_User ad) {
		this.getHibernateTemplate().update(ad);
	}

	@Override
	public void addAdminUser(Admin_User ad) {
		this.getHibernateTemplate().save(ad);
		
	}

	@Override
	public List<Admin_User> selectAdUser() {
		String sql = "select au from Admin_User au";
		List<Admin_User> lists = (List<Admin_User>) this.getHibernateTemplate().find(sql);
		return lists;
	}


}
