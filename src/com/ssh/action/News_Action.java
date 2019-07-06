package com.ssh.action;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssh.bean.News;
import com.ssh.service.inter.NewsServiceInter;
import com.ssh.util.Time;

@Controller("news_action")
@Scope("singleton")//singleton之所以用这个，是因为上传图片与点击增加文章的分开的，
//两个请求，但最后是写入一个表中，所以用这个属性，只产生一个实例
public class News_Action extends ActionSupport implements ModelDriven<News> {
	private News news = new News();
	@Resource(name="newserviceimpl")
	private NewsServiceInter nsi;
	private String result;
	private String Fenye;
	private String stitle;
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	
	public String getFenye() {
		return Fenye;
	}
	public void setFenye(String fenye) {
		Fenye = fenye;
	}
	
	
	public String getStitle() {
		return stitle;
	}
	public void setStitle(String stitle) {
		this.stitle = stitle;
	}
	public String addNews() {
		news.setDatas(Time.getTime2());
		String a = nsi.addNews(news);
		System.out.println("Action"+a);
		return "addnews";
	}
	
	public String uploadImgNews() {//上传
		Map<String, String> map = new HashMap<String,String>();
		String upload = "E:\\apache-tomcat-9.0.11\\webapps\\test";
		File fs = new File(upload);
		if(!fs.exists()) {
			fs.mkdir();
		}
		File file = new File(upload,news.getMyfileFileName());
		try {
			FileUtils.copyFile(news.getMyfile(), file);
			map.put("state", "1");
			map.put("names", news.getMyfileFileName());
			this.setResult(JSON.toJSONString(map));
		} catch (Exception e) {
			System.out.println(e.toString());
			map.put("state", "-1");
			this.setResult(JSON.toJSONString(map));
		}
		System.out.println(news.getMyfileFileName());
		return "upload";
		
	}
	
	
	public String countsNews() {
		String numss = nsi.counts();
		this.setResult(numss);
		return "select";
	}
	
	public String delNews() {//单击删除
		String del = nsi.delNews(Integer.parseInt(this.getResult()));
		this.setResult(del);
		return "delte";
	}
	
	public String delsNews() {//批量删除
		System.out.println("批量"+this.getResult());
		String[] bs = this.getResult().split(",");
		String dels = nsi.deletes(bs);
		this.setResult(dels);
		return "deltes";
	}
	
	public String findPageNews() {
		String listst = nsi.findPage(Integer.parseInt(this.getFenye()), 5);
		System.out.println(this.getFenye());
		this.setResult(listst);
		return "findPage";
	}
	
	
	public String searchNews() {
		String sear = nsi.searchNew(this.getStitle());
		this.setStitle(sear);
		System.out.println(sear);
		return "search";
	}
	
	@Override
	public News getModel() {
		return news;
	}


}
