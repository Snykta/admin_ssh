package com.ssh.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssh.bean.News;
import com.ssh.service.inter.NewsServiceInter;

@Controller("updateaction")
@Scope("prototype")
public class UpdateAction extends ActionSupport implements ModelDriven<News>{
	private News news = new News();
	@Resource(name="newserviceimpl")
	private NewsServiceInter nsi;
	private String result;

	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	
	public String selectNew() {
		String seles =  nsi.findIdNews(Integer.parseInt(this.getResult()));
		this.setResult(seles);
		return "select";
	}
	
	
	public String updateNew() {//пч╦дндуб
		String updates =  nsi.updateNews(news, Integer.parseInt(this.getResult()));
		System.out.println(updates);
		return "update";
		
	}















	@Override
	public News getModel() {
		// TODO Auto-generated method stub
		return news;
	}

}
