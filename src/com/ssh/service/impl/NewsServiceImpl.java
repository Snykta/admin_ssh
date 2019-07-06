package com.ssh.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.ssh.bean.News;
import com.ssh.bean.NewsType;
import com.ssh.dao.inter.NewsDaoInter;
import com.ssh.service.inter.NewsServiceInter;
import com.ssh.util.Time;

@Service("newserviceimpl")
@Transactional(readOnly=true)
public class NewsServiceImpl implements NewsServiceInter {
	@Resource(name="newsdaoimpl")
	private NewsDaoInter newsDaointer;
	private Map<String, String> map;

	
	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public String addNews(News ns) {
		NewsType newsType = newsDaointer.selectNewType(Integer.parseInt(ns.getSort()));
		ns.setSort(newsType.getNames());
		try {
			newsDaointer.addnews(ns);
			return "1";
		} catch (Exception e) {
			System.out.println(e.toString());
			return "-1";
		}
		
	}


	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public String delNews(int id) {
		map = new HashMap<String,String>();
		try {
			newsDaointer.delNews(id);
			map.put("state", "1");
			return JSON.toJSONString(map);
		} catch (Exception e) {
			System.out.println(e.toString());
			map.put("state", "-1");
			return JSON.toJSONString(map);
			
		}
	}


	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public String deletes(String[] id) {
		map = new HashMap<String,String>();
		int n = newsDaointer.delsNews(id);
		if(n==1) {
			map.put("state", "1");
			return JSON.toJSONString(map);
		}else {
			map.put("state", "-1");
			return JSON.toJSONString(map);
		}
	}


	@Override
	public String findPage(Integer start, int pageSize) {
		List<News> lists = newsDaointer.findForPage(start, pageSize);
		return JSON.toJSONString(lists);
	}


	@Override
	public String counts() {
		Map<String,Integer> maps = new HashMap<String,Integer>();
		maps.put("state", newsDaointer.counts());
		return JSON.toJSONString(maps);
	}


	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public String updateNews(News news, int id) {
		map = new HashMap<String,String>();
		try {
			News news1 = newsDaointer.findIdNew(id);
			news1.setTitle(news.getTitle());news1.setKeyword(news.getKeyword());
			news1.setDescs(news.getDescs());news1.setSource(news.getSource());
			news1.setAuthor(news.getAuthor());news1.setDatas(Time.getTime2());
			newsDaointer.updateNews(news1);
			map.put("state", "1");
			return JSON.toJSONString(map);
		} catch (Exception e) {
			System.out.println(e.toString());
			map.put("state", "-1");
			return JSON.toJSONString(map);
		}
		
	}


	@Override
	public String findIdNews(int id) {
		News n = newsDaointer.findIdNew(id);
		return JSON.toJSONString(n);
	}


	@Override
	public String searchNew(String titles) {
			List<News> lists = newsDaointer.searchNew(titles);
			return JSON.toJSONString(lists);
		
	}


	@Override
	public String selectNewsType() {//查询所有分类
		List<NewsType> lists = newsDaointer.getNewTypes();
		return JSON.toJSONString(lists);
	}


	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public String addType(NewsType nd) {
		nd.setDates(Time.getTime());
		newsDaointer.addType(nd);
		return "1";
	}

}
