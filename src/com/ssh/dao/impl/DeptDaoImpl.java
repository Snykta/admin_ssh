package com.ssh.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.ssh.bean.Dept;
import com.ssh.dao.inter.DeptDaoInter;

@Repository("deptdaoimpl")
public class DeptDaoImpl extends HibernateDaoSupport implements DeptDaoInter {
	
	@Resource(name="sessionFactory")//×¢Èë
	public void setHibernateSessionFactroy(SessionFactory sessionFactory){
		this.setSessionFactory(sessionFactory);
	}
	
	@Override
	public Dept findId(int id) {
		Dept d = this.getHibernateTemplate().get(Dept.class, id);
		return d;
	}

	@Override
	public List<Dept> selectdept() {
		String sql = "select d from Dept d";
		List<Dept> lists = (List<Dept>) this.getHibernateTemplate().find(sql);
		return lists;
	}

	@Override
	public int counts() {
		return this.getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery("select count(d) from Dept d");
				return Integer.parseInt(query.uniqueResult().toString());
			}
		});
	}

	@Override
	public List<Dept> pagedept(int start, int pageSize) {
		return this.getHibernateTemplate().execute(new HibernateCallback<List<Dept>>() {
			@Override
			public List<Dept> doInHibernate(Session session) throws HibernateException {
				try {
					Query<Dept> query = session.createQuery("select d from Dept d");
					query.setFirstResult(start);
					query.setMaxResults(pageSize);
					return query.list();
				} catch (Exception e) {
					System.out.println("·ÖÒ³Ê§°Ü"+e.toString());
					return null;
				}
			}
			
		});
	}

	@Override
	public void deldept(int id) {
		this.getHibernateTemplate().delete(this.getHibernateTemplate().load(Dept.class, id));
		
	}

	@Override
	public void adddept(Dept d) {
		this.getHibernateTemplate().save(d);
		
	}

	@Override
	public void updatedept(Dept d) {
		this.getHibernateTemplate().update(d);
		
	}
}
