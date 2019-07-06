package com.ssh.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ssh.bean.Dept;
import com.ssh.bean.P_user;
import com.ssh.dao.inter.DeptDaoInter;
import com.ssh.service.inter.DeptServiceInter;
import com.ssh.util.Time;

@Service("deptserviceimpl")
@Transactional(readOnly=true)
public class DeptServiceImpl implements DeptServiceInter {
	@Resource(name="deptdaoimpl")
	private DeptDaoInter deptinter;
	private Map<String, String> map;

	@Override
	public String selectDept() {
		List<Dept> lists = deptinter.selectdept();
		return JSON.toJSONString(lists);
	}

	@Override
	public String counts() {
		Map<String, Integer> maps = new HashMap<String, Integer>();
		maps.put("counts", deptinter.counts());
		return JSON.toJSONString(maps);
	}

	@Override
	public String pagedept(int start, int pageSize) {
		List<Dept> lists = deptinter.pagedept(start, pageSize);
		return JSON.toJSONString(lists);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public String deldept(int id) {
		map = new HashMap<String, String>();
		Dept d =deptinter.findId(id);
		try {
			JSONObject jsonObject = JSONObject.parseObject(JSON.toJSONString(d));
			JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(jsonObject.get("puser")));
			if(jsonArray.size()>0) {
				map.put("state", "0");
				System.out.println("²»É¾³ý");
			}else {
				deptinter.deldept(id);
				map.put("state", "1");
			}
			return JSON.toJSONString(map);
		} catch (Exception e) {
			map.put("state", "-1");
			System.out.println("É¾³ýÊ§°Ü"+e.toString());
			return JSON.toJSONString(map);
		}
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public String adddept(Dept d) {
		d.setDatas(Time.getTime2());
		deptinter.adddept(d);
		return "1";
	}

	@Override
	public String findid(int id) {
		Dept d = deptinter.findId(id);
		return JSON.toJSONString(d);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public String updatedept(Dept d, int id) {
		Dept dd = deptinter.findId(id);
		dd.setEname(d.getEname());
		deptinter.updatedept(dd);
		return "1";
	}

}
