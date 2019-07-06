package com.ssh.action;


import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssh.bean.Admin_User;
import com.ssh.service.inter.LogServiceInter;
import com.ssh.service.inter.UserServiceInter;

@Controller("admin_useraction")
@Scope("prototype")
public class Admin_UserAction extends ActionSupport implements ModelDriven<Admin_User>{
	@Resource(name="userServiceimpl")//注入依赖
	private UserServiceInter userServiceInter;
	
	@Resource(name="logserviceimpl")
	private LogServiceInter logServiceInter;
	
	private Admin_User u = new Admin_User();
	
	private String result;
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}

	public String loginUser() {//登录
		String  logins = userServiceInter.login(u.getUsers(), u.getPassword());
		this.setResult(logins);
		JSONObject json = JSONObject.parseObject(logins);
		if(json.get("state").equals("1")) {//如果登录成功
			logServiceInter.addLog();//写入日志，可能会登录延迟
		}
		return "login";
	}
	
	
	
	public String updateUser() {//修改管理员信息
		String updateM = userServiceInter.updateAdminUser(u,Integer.parseInt(this.getResult()));
		this.setResult(updateM);
		return "updateMessage";
	}
	
	
	public String updatepassUser() {//修改密码
		String updatePass = userServiceInter.updateAdminpass(u, Integer.parseInt(this.getResult()));
		this.setResult(updatePass);
		return "updatepass";
	}
	
	public String SignOutUser() {//退出登录
		userServiceInter.loginOut();
		return "signout";
	}
	
	public String selectIpUser() {//日志
		String ips = logServiceInter.getIp();
		this.setResult(ips);
		return "selectIp";
	}
	
	public String registerUser() {//注册
		String regis = userServiceInter.addAdminUser(u, this.getResult());
		this.setResult(regis);
		return "register";
	}
	
	public String selectAdUser() {//查询全部
		String selects = userServiceInter.selectAuser();
		this.setResult(selects);
		return "select";
	}
	
	
	
	
	
	
	
	
	
	@Override
	public Admin_User getModel() {
		// TODO Auto-generated method stub
		return u;
	}

}
