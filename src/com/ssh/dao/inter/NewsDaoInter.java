package com.ssh.dao.inter;

import java.util.List;
import com.ssh.bean.News;
import com.ssh.bean.NewsType;

public interface NewsDaoInter {
	/**
	 * 添加文章
	 * @param n
	 */
	public void addnews(News n);
	
	/**
	 * 查询分类
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
	 * 分页查询
	 * @param start
	 * @param pageSize
	 * @return
	 */
	public List<News> findForPage(Integer start,int pageSize);
	
	/***
	 * 根据id查询数据
	 * @return
	 */
	public News findIdNew(int id);
	
	public void updateNews(News news);
	
	/**
	 * 模糊查询
	 * @param Sname
	 * @return
	 */
	public List<News> searchNew(String titles);
}
