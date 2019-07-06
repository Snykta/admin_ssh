package com.ssh.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.ssh.bean.Login_log;
import com.ssh.dao.inter.LogDaoInter;
@Repository("loginlogimpl")
public class LogDaoImpl extends HibernateDaoSupport implements LogDaoInter {
	
	@Resource(name="sessionFactory")//×¢Èë
	public void setHibernateSessionFactroy(SessionFactory sessionFactory){
		this.setSessionFactory(sessionFactory);
	}

	@Override
	public void addLog(Login_log log) {
		this.getHibernateTemplate().save(log);
		
	}

	@Override
	public List<Login_log> getip() {
		String sql = "select log from Login_log log";
		List<Login_log> lists = (List<Login_log>) this.getHibernateTemplate().find(sql);
		return lists;
	}

}
