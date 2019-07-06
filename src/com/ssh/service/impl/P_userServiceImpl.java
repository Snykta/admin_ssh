package com.ssh.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.ssh.bean.Dept;
import com.ssh.bean.News;
import com.ssh.bean.P_user;
import com.ssh.dao.inter.P_userDaointer;
import com.ssh.service.inter.P_userServiceInter;


@Service("p_userserviceimpl")
@Transactional(readOnly=true)
public class P_userServiceImpl implements P_userServiceInter {
	@Resource(name="p_userimpl")
	private P_userDaointer p_inter;

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public String addpuser(P_user puser, int id) {
		try {
			p_inter.addPuser(puser, id);
			return "1";
		} catch (Exception e) {
			System.out.println(e.toString());
			return "-1";
		}
		
		
	}

	@Override
	public String counts() {
		Map<String, Integer> maps = new HashMap<String, Integer>();
		maps.put("counts", p_inter.counts());
		return JSON.toJSONString(maps);
	}

	@Override
	public String pagepuser(int start, int pageSize) {
		List<P_user> lists = p_inter.pagePuser(start, pageSize);
		return JSON.toJSONString(lists);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public String del_puser(int id) {
		Map<String, String> maps = new HashMap<String, String>();
		try {
			p_inter.del_puser(id);
			maps.put("state", "1");
			return JSON.toJSONString(maps);
		} catch (Exception e) {
			maps.put("state", "-1");
			System.out.println(e.toString());
			return JSON.toJSONString(maps);
		}
	}

	@Override
	public String findId(int id) {
		P_user pu = p_inter.findidu(id);
		return JSON.toJSONString(pu);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public String updateuser(P_user pu, int id) {
		P_user p_user = p_inter.findidu(id);
		p_user.setNames(pu.getNames());
		p_user.setSex(pu.getSex());
		p_user.setIphone(pu.getIphone());
		p_user.setEmail(pu.getEmail());
		p_user.setStates(pu.getStates());
		p_inter.updatuser(p_user);
		return "1";
	}

	@Override
	public String searchuser(String names) {
		List<P_user> lists = p_inter.searchuser(names);
		return JSON.toJSONString(lists);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public String updateUserdept(int dept_id,int p) {
		p_inter.updatedpu(dept_id, p);
		return "1";
	}



	


}
