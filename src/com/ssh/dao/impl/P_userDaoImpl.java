package com.ssh.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.ssh.bean.Dept;
import com.ssh.bean.Link;
import com.ssh.bean.News;
import com.ssh.bean.P_user;
import com.ssh.dao.inter.P_userDaointer;

@Repository("p_userimpl")
public class P_userDaoImpl extends HibernateDaoSupport implements P_userDaointer {
	
	@Resource(name="sessionFactory")//注入
	public void setHibernateSessionFactroy(SessionFactory sessionFactory){
		this.setSessionFactory(sessionFactory);
	}

	@Override
	public void addPuser(P_user puser, int dept_id) {//一对多添加员工的方式
		Dept d = this.getHibernateTemplate().get(Dept.class, dept_id);//根据id查询部门，得到部门类
		d.getPuser().add(puser);//跟据这个部门获取其中的set集合，并把user类加入进去，产生外键
		this.getHibernateTemplate().save(d);//保存dept,联级操作，同时增加从表
		
	}

	@Override
	public int counts() {//总数
		return this.getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery("select count(u) from P_user u");
				return Integer.parseInt(query.uniqueResult().toString());
			}
			
		});
	}

	
	@Override
	public List<P_user> pagePuser(int start, int pageSize) {
		return this.getHibernateTemplate().execute(new HibernateCallback<List<P_user>>() {
			@Override
			public List<P_user> doInHibernate(Session session) throws HibernateException {
				try {
					Query<P_user> query = session.createQuery("select u from P_user u");
					query.setFirstResult(start);
					query.setMaxResults(pageSize);
					return query.list();
				} catch (Exception e) {
					System.out.println("分页失败"+e.toString());
					return null;
				}
			}
			
		});
	}

	@Override
	public void del_puser(int id) {
		this.getHibernateTemplate().delete(this.getHibernateTemplate().load(P_user.class, id));
		
	}

	@Override
	public P_user findidu(int id) {
		P_user pu = this.getHibernateTemplate().get(P_user.class, id);
		return pu;
	}

	@Override
	public void updatuser(P_user pu) {
		this.getHibernateTemplate().update(pu);
	}

	@Override
	public List<P_user> searchuser(String names) {
		String hql = "select u from P_user u ";
		if(names!=null&&!"".equals(names.trim())) {
			hql+="where names like ?";
			List<P_user> lists = (List<P_user>) this.getHibernateTemplate().find(hql, "%"+names+"%");
			return lists;
		}else {
			return (List<P_user>) this.getHibernateTemplate().find(hql);
		}

	}

	@Override
	public void updatedpu(int dept_id, int p) {
		Dept d = this.getHibernateTemplate().get(Dept.class, dept_id);
		P_user pd = this.getHibernateTemplate().get(P_user.class, p);
		d.getPuser().add(pd);
		this.getHibernateTemplate().update(d);
	}



}
