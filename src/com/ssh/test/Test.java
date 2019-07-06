package com.ssh.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ssh.bean.Admin_User;
import com.ssh.bean.Dept;
import com.ssh.bean.Link;
import com.ssh.bean.News;
import com.ssh.dao.inter.NewsDaoInter;
import com.ssh.dao.inter.UserDaoInter;
import com.ssh.service.inter.DeptServiceInter;
import com.ssh.service.inter.LinkServiceInter;
import com.ssh.service.inter.LogServiceInter;
import com.ssh.service.inter.NewsServiceInter;
import com.ssh.service.inter.UserServiceInter;
import com.ssh.util.AppUtil;
import com.ssh.util.GetIp;

public class Test {
	
	public void test1() {
		ApplicationContext applicationContext = AppUtil.getApplicationContext();
		DeptServiceInter uservice = (DeptServiceInter) applicationContext.getBean("deptserviceimpl");
//		Link link = new Link();
//		uservice.searchNew("f");
//		link.setKeyword("¹þ¹þ¹þ");
//		uservice.counts();
		//System.out.println(uservice.selectDept());
		String d = uservice.selectDept();
		JSONArray j = JSONArray.parseArray(d);
		System.out.println(j.get(0));
		JSONObject jj = JSONObject.parseObject(JSON.toJSONString(j.get(0)));
		System.out.println(jj.get("puser"));
		JSONArray js = JSONArray.parseArray(JSON.toJSONString(jj.get("puser")));
		System.out.println(js.size());
//		uservice.delNews(53);
//		System.out.println(uservice.findPage(0, 5));
	}
	public static void main(String[] args){
		new Test().test1();
//		System.out.println(ServletActionContext.getServletContext());
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("id", "1");
//		System.out.println(map);
	}

}
