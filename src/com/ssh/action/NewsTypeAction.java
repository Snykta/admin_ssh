package com.ssh.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssh.bean.NewsType;
import com.ssh.service.inter.NewsServiceInter;

@Controller("newstypeaction")
@Scope("prototype")
public class NewsTypeAction extends ActionSupport implements ModelDriven<NewsType> {
	private NewsType nt = new NewsType();
	@Resource(name="newserviceimpl")
	private NewsServiceInter nsi;
	private String result;
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	public String selectType() {
		String sels = nsi.selectNewsType();
		this.setResult(sels);
		return "selecttype";
	}
	
	public String addType() {
		nsi.addType(nt);
		return "add";
	}





	@Override
	public NewsType getModel() {
		
		return nt;
	}

}
