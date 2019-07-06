package com.ssh.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Controller;
import com.ssh.bean.Link;
import com.ssh.dao.inter.LinkDaoInter;

@Controller("linkdaoimpl")
public class LinkDaoImpl extends HibernateDaoSupport implements LinkDaoInter{
	
	@Resource(name="sessionFactory")//注入
	public void setHibernateSessionFactroy(SessionFactory sessionFactory){
		this.setSessionFactory(sessionFactory);
	}

	@Override
	public void addLink(Link link) {
		this.getHibernateTemplate().save(link);
		
	}

	@Override
	public int counts() {//查总数
		return this.getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery("select count(l) from Link l");
				return Integer.parseInt(query.uniqueResult().toString());
			}
			
		});
	}

	@Override
	public List<Link> findForPage(Integer start, int pageSize) {
		return this.getHibernateTemplate().execute(new HibernateCallback<List<Link>>() {

			@Override
			public List<Link> doInHibernate(Session session) throws HibernateException {
				try {
					Query<Link> query = session.createQuery("select l from Link l");
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
	public void del_link(int id) {//删除
		this.getHibernateTemplate().delete(this.getHibernateTemplate().load(Link.class, id));
		
		
	}

	@Override
	public Link findIdLink(int id) {
		Link link = this.getHibernateTemplate().get(Link.class, id);
		return link;
	}

	@Override
	public void updateLink(Link link) {
		this.getHibernateTemplate().update(link);
		
	}

}
