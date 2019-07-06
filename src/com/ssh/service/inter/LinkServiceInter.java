package com.ssh.service.inter;

import com.ssh.bean.Link;

public interface LinkServiceInter {
	
	public String addLink(Link link);
	
	public String counts();
	
	public String findPage(Integer start,int pageSize);
	
	public String delLink(int id);
	
	public String findId(int id);
	
	public String updateLink(Link link , int id);

}
