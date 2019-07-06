package com.ssh.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.ssh.bean.Login_log;
import com.ssh.dao.inter.LogDaoInter;
import com.ssh.service.inter.LogServiceInter;
import com.ssh.util.GetIp;
import com.ssh.util.Get_ip_state;
import com.ssh.util.Time;

@Service("logserviceimpl")
@Transactional(readOnly=true)
public class LogServiceImpl implements LogServiceInter{
	@Resource(name="loginlogimpl")
	private LogDaoInter logdaointer;
	
	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public void addLog() {
		Login_log logs = new Login_log();
		logs.setLogin_ip(GetIp.getIpAddr());//IP
		logs.setSite(Get_ip_state.getIp(GetIp.getIpAddr()));//地址
		System.out.println("ip所在地"+Get_ip_state.getIp(GetIp.getIpAddr()));
		logs.setDates(Time.getTime());//时间
		logs.setEndlog("成功");//状态
		logdaointer.addLog(logs);
		
	}

	@Override
	public String getIp() {//获取日志
		List<Login_log> lists = logdaointer.getip();
		JSONArray jArray = new JSONArray();
		jArray.add(lists);
		System.out.println(jArray);
		return jArray.toString();
	}

}
