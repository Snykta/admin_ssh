package com.ssh.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.ssh.bean.Link;
import com.ssh.dao.inter.LinkDaoInter;
import com.ssh.service.inter.LinkServiceInter;
import com.ssh.util.Time;

@Service("linkserviceimpl")
@Transactional(readOnly=true)
public class LinkServiceImpl implements LinkServiceInter {
	@Resource(name="linkdaoimpl")
	private LinkDaoInter linkdao;
	private Map<String, String> map;
	
	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public String addLink(Link link) {
		try {
			link.setDatas(Time.getTime());
			linkdao.addLink(link);
			return "1";
		} catch (Exception e) {
			System.out.println(e.toString());
			return "-1";
		}
	}

	@Override
	public String counts() {
		Map<String, Integer> maps = new HashMap<String, Integer>();
		maps.put("counts", linkdao.counts());
		return JSON.toJSONString(maps);
	}

	@Override
	public String findPage(Integer start, int pageSize) {
		List<Link> lists = linkdao.findForPage(start, pageSize);
		return JSON.toJSONString(lists);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public String delLink(int id) {
		map = new HashMap<String, String>();
		try {
			linkdao.del_link(id);
			map.put("state", "1");
			return JSON.toJSONString(map);
		} catch (Exception e) {
			System.out.println(e.toString());
			map.put("state", "1");
			return JSON.toJSONString(map);
		}
	}

	@Override
	public String findId(int id) {
		Link link = linkdao.findIdLink(id);
		return JSON.toJSONString(link);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public String updateLink(Link link, int id) {
		Link links = linkdao.findIdLink(id);
		links.setKeyword(link.getKeyword());
		links.setLinkad(link.getLinkad());
		links.setStates(link.getStates());
		links.setDatas(Time.getTime());
		linkdao.updateLink(links);
		return "1";
	}

}
