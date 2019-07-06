package com.ssh.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONArray;
import com.ssh.bean.Dept;
import com.ssh.bean.News;
import com.ssh.bean.NewsType;
import com.ssh.dao.inter.NewsDaoInter;

@Repository("newsdaoimpl")
public class NewsDaoImpl extends HibernateDaoSupport implements NewsDaoInter {
	
	@Resource(name="sessionFactory")//注入
	public void setHibernateSessionFactroy(SessionFactory sessionFactory){
		this.setSessionFactory(sessionFactory);
	}

	@Override
	public void addnews(News n) {
		this.getHibernateTemplate().save(n);
		
	}

	@Override
	public NewsType selectNewType(int id) {
		NewsType nt = this.getHibernateTemplate().get(NewsType.class, id);
		return nt;
	}

	@Override
	public void delNews(int id) {//单击删除
		this.getHibernateTemplate().delete(this.getHibernateTemplate().load(News.class, id));
		
	}

	@Override
	public int delsNews(String[] id) {//批量删除
		String ides = "";
		for (String i : id) {
			ides+=Integer.parseInt(i)+",";
		}
		String aides = ides.substring(0, ides.length()-1);
		String sql = "delete from News where id in ("+aides+")";
		return this.getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session){
				try {
					Query<News> query = session.createQuery(sql);
					 query.executeUpdate();
					return 1;
				} catch (Exception e) {
					System.out.println(e.toString());
					return -1;
				}
				
			}
		});
	}

	@Override
	public List<News> findForPage(Integer start, int pageSize) {
		return this.getHibernateTemplate().execute(new HibernateCallback<List<News>>() {

			@Override
			public List<News> doInHibernate(Session session) throws HibernateException {
				try {
					Query<News> query = session.createQuery("select n from News n");
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
	public int counts() {//总数
		return this.getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery("select count(n) from News n");
				return Integer.parseInt(query.uniqueResult().toString());
			}
			
		});
	}

	@Override
	public News findIdNew(int id) {
		News news = this.getHibernateTemplate().get(News.class, id);
		return news;
	}

	@Override
	public void updateNews(News news) {
		this.getHibernateTemplate().update(news);
		
	}
	/**
	 * 根据标题模糊擦查询
	 */
	@Override
	public List<News> searchNew(String titles) {
		String hql = "select n from News n ";
		if(titles!=null&&!"".equals(titles.trim())) {
			hql+="where title like ?";
			List<News> lists = (List<News>) this.getHibernateTemplate().find(hql, "%"+titles+"%");
			return lists;
		}else {
			return (List<News>) this.getHibernateTemplate().find(hql);
		}
		
	}

	@Override
	public List<NewsType> getNewTypes() {
		String sql = "select t from NewsType t";
		List<NewsType> lists = (List<NewsType>) this.getHibernateTemplate().find(sql);
		return lists;
	}

	@Override
	public void addType(NewsType nt) {
		this.getHibernateTemplate().save(nt);
		
	}


}
