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
		logs.setSite(Get_ip_state.getIp(GetIp.getIpAddr()));//��ַ
		System.out.println("ip���ڵ�"+Get_ip_state.getIp(GetIp.getIpAddr()));
		logs.setDates(Time.getTime());//ʱ��
		logs.setEndlog("�ɹ�");//״̬
		logdaointer.addLog(logs);
		
	}

	@Override
	public String getIp() {//��ȡ��־
		List<Login_log> lists = logdaointer.getip();
		JSONArray jArray = new JSONArray();
		jArray.add(lists);
		System.out.println(jArray);
		return jArray.toString();
	}

}
