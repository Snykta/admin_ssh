package com.ssh.service.inter;

import com.ssh.bean.News;
import com.ssh.bean.NewsType;

public interface NewsServiceInter {
	
	public String addNews(News ns);

	public String delNews(int id);
	
	public String deletes(String[] id);
	
	public String findPage(Integer start,int pageSize);
	
	public String counts();
	
	public String updateNews(News news,int id);
	
	public String findIdNews(int id);
	
	public String searchNew(String titles);
	
	public String selectNewsType();//≤È—Ø∑÷¿‡
	
	public String addType(NewsType nd);

}
