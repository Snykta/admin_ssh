package com.ssh.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssh.bean.P_user;
import com.ssh.service.inter.P_userServiceInter;

@Controller("p_useraction")
@Scope("prototype")
public class P_userAction extends ActionSupport implements ModelDriven<P_user> {
	private P_user puser = new P_user();
	@Resource(name="p_userserviceimpl")
	private P_userServiceInter p_userinter;
	private String result;
	private String dept_id;
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	public String getDept_id() {
		return dept_id;
	}
	public void setDept_id(String dept_id) {
		this.dept_id = dept_id;
	}
	public String addpuser() {
		p_userinter.addpuser(puser, Integer.parseInt(this.getResult()));
		return "add";
	}
	
	public String countpuser() {
		String counts = p_userinter.counts();
		this.setResult(counts);
		return "conts";
	}
	
	public String pagepuser() {
		String page = p_userinter.pagepuser(Integer.parseInt(this.getResult()), 5);
		this.setResult(page);
		return "pagef";
	}
	
	public String delpuser() {
		String dels = p_userinter.del_puser(Integer.parseInt(this.getResult()));
		this.setResult(dels);
		return "del";
	}
	
	public String findidu() {
		String pu = p_userinter.findId(Integer.parseInt(this.getResult()));
		this.setResult(pu);
		return "findid";
	}
	
	public String updateuser() {
		p_userinter.updateuser(puser, Integer.parseInt(this.getResult()));
		return "update";
	}
	public String searchUser() {
		String sear = p_userinter.searchuser(this.getResult());
		this.setResult(sear);
		System.out.println(sear);
		return "search";
	}
	
	public String updateDeptUser() {
		p_userinter.updateUserdept(Integer.parseInt(this.getDept_id()),Integer.parseInt(this.getResult()));
		return "updatedeptus";
	}
	
	@Override
	public P_user getModel() {
		// TODO Auto-generated method stub
		return puser;
	}

}
