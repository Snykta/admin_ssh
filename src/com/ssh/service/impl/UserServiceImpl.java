package com.ssh.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ssh.bean.Admin_User;
import com.ssh.dao.inter.UserDaoInter;
import com.ssh.service.inter.UserServiceInter;
import com.ssh.util.Time;

@Service("userServiceimpl")
@Transactional(readOnly=true)
public class UserServiceImpl implements UserServiceInter {
	@Resource(name="userimpl")//����ע��
	private UserDaoInter userDaointer;
	//map���ϣ�����ֵ��Ȼ����תΪjson��
	private Map<String, String> map;

	@Override
	public String login(String username, String password) {
		map = new HashMap<String,String>();
		Admin_User u = userDaointer.login(username, password);
		if(u!=null) {
			map.put("user_name", u.getUsers());
			map.put("state", "1");
			try {
				String jsonUser = JSONObject.toJSONString(u);
				System.out.println(jsonUser);
				Cookie cookies = new Cookie("admin_user", java.net.URLEncoder.encode(jsonUser, "UTF-8"));//���л�
				ServletActionContext.getResponse().addCookie(cookies);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return JSON.toJSONString(map);
		}else {
			map.put("state", "-1");
			return JSON.toJSONString(map);
		}
	}


	
	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public String updateAdminUser(Admin_User ad,int id) {
		map = new HashMap<String,String>();
		try {
			Admin_User u = userDaointer.findAdminUser(id);
			u.setNames(ad.getNames());
			u.setEmail(ad.getEmail());
			userDaointer.updateAdminUser(u);
			System.out.println("�޸ĵ���ϢidΪ"+u.getId());
			String jsonUser = JSONObject.toJSONString(u);
			Cookie cookies = new Cookie("admin_user", java.net.URLEncoder.encode(jsonUser, "UTF-8"));//���л�
			ServletActionContext.getResponse().addCookie(cookies);
			
			map.put("state", "1");
			return JSON.toJSONString(map);
		} catch (Exception e) {
			System.out.println("�޸�ʧ��"+e.toString());
			map.put("state", "-1");
			return JSON.toJSONString(map);
		}
		
	}



	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public String updateAdminpass(Admin_User ad, int id) {
		map = new HashMap<String,String>();
		String yuanpss = ServletActionContext.getRequest().getParameter("pass");
		Admin_User u = userDaointer.findAdminUser(id);
		if(!yuanpss.equals(u.getPassword())) {
			map.put("state", "-2");
			return JSON.toJSONString(map);
		}else {
			try {
			u.setPassword(ad.getPassword());
			userDaointer.updateAdminUser(u);
			map.put("state", "1");
			return JSON.toJSONString(map);
		} catch (Exception e) {
			System.out.println(e.toString());
			map.put("state", "-1");
			return JSON.toJSONString(map);
			}
		}
	}



	@Override
	public String loginOut() {
		Cookie[] cookies = ServletActionContext.getRequest().getCookies();
		for(Cookie ck : cookies) {
			ck.setMaxAge(0);
			ServletActionContext.getResponse().addCookie(ck);
		}
		return "clearCk";
	}



	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public String addAdminUser(Admin_User ad,String code) {
		map = new HashMap<String,String>();
		HttpSession session = ServletActionContext.getRequest().getSession();
 		String keysy = session.getAttribute("sess_captcha").toString();
 		if(!code.equalsIgnoreCase(keysy)) {
 			map.put("state", "0");//��֤�����
 		}else {
 			try {
 				ad.setDates(Time.getTime2());
 				userDaointer.addAdminUser(ad);
 				map.put("state", "1");//ע��ɹ�
			} catch (Exception e) {
 				map.put("state", "-1");
 				System.out.println(e.toString());
			}
 		}
		
		return JSON.toJSONString(map);
	}



	@Override
	public String selectAuser() {
		 List<Admin_User> ad = userDaointer.selectAdUser();
		return JSON.toJSONString(ad);
	}



}
