package com.ssh.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssh.bean.Dept;
import com.ssh.service.inter.DeptServiceInter;

@Controller("deptaction")
@Scope("prototype")
public class DeptAction extends ActionSupport implements ModelDriven<Dept> {
	private Dept dept = new Dept();
	@Resource(name="deptserviceimpl")
	private DeptServiceInter deptinter;
	private String result;
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}

	public String selectDept() {
		String seles = deptinter.selectDept();
		this.setResult(seles);
		return "select";
	}


	public String countsDept() {
		String counts = deptinter.counts();
		this.setResult(counts);
		return "conts";
	}

	public String pageDept() {
		String page = deptinter.pagedept(Integer.parseInt(this.getResult()), 3);
		this.setResult(page);
		return "pagef";
	}
	
	public String delDept() {
		String del = deptinter.deldept(Integer.parseInt(this.getResult()));
		this.setResult(del);
		return "del";
	}
	
	public String adddept() {
		deptinter.adddept(dept);
		return "add";
	}
	
	public String findIde() {
		String indid = deptinter.findid(Integer.parseInt(this.getResult()));
		this.setResult(indid);
		return"findid";
	}
	
	public String updateDept() {
		deptinter.updatedept(dept, Integer.parseInt(this.getResult()));
		return "update";
	}





	@Override
	public Dept getModel() {
		// TODO Auto-generated method stub
		return dept;
	}

}
