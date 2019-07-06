package com.ssh.dao.inter;

import java.util.List;
import com.ssh.bean.News;
import com.ssh.bean.NewsType;

public interface NewsDaoInter {
	/**
	 * �������
	 * @param n
	 */
	public void addnews(News n);
	
	/**
	 * ��ѯ����
	 * @param id
	 * @return
	 */
	public NewsType selectNewType(int id);
	
	public List<NewsType> getNewTypes();
	
	
	public void addType(NewsType nt);
	
	public int counts();
	
	public void delNews(int id);
	
	public int delsNews(String[] id);
	
	/**
	 * ��ҳ��ѯ
	 * @param start
	 * @param pageSize
	 * @return
	 */
	public List<News> findForPage(Integer start,int pageSize);
	
	/***
	 * ����id��ѯ����
	 * @return
	 */
	public News findIdNew(int id);
	
	public void updateNews(News news);
	
	/**
	 * ģ����ѯ
	 * @param Sname
	 * @return
	 */
	public List<News> searchNew(String titles);
}
