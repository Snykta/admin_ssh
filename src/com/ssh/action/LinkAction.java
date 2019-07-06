package com.ssh.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssh.bean.Link;
import com.ssh.service.inter.LinkServiceInter;

@Controller("linkaction")
@Scope("prototype")
public class LinkAction extends ActionSupport implements ModelDriven<Link> {
	private Link link = new Link();
	@Resource(name="linkserviceimpl")
	private LinkServiceInter linkservice;
	private String result;
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}

	public String addLink() {
		linkservice.addLink(link);
		return "add";
	}
	
	public String countLink() {
		String sel = linkservice.counts();
		this.setResult(sel);
		return "conts";
	}
	
	public String findPageLink() {
		String pages = linkservice.findPage(Integer.parseInt(this.getResult()), 5);
		this.setResult(pages);
		return "page";
	}
	
	public String delLink() {
		String del = linkservice.delLink(Integer.parseInt(this.getResult()));
		this.setResult(del);
		return "del";
	}
	
	public String selectLink() {
		String selects =linkservice.findId(Integer.parseInt(this.getResult()));
		this.setResult(selects);
		return "select";
	}
	
	public String updateLink() {
		String up = linkservice.updateLink(link, Integer.parseInt(this.getResult()));
		System.out.println(up);
		return "update";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public Link getModel() {
		return link;
	}

}
