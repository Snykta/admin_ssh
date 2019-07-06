package com.ssh.dao.inter;

import java.util.List;

import com.ssh.bean.Link;

public interface LinkDaoInter {
	/**
	 * ���
	 * @param link
	 */
	public void addLink(Link link);
	
	public int counts();
	
	/**
	 * ��ҳ��ѯ
	 * @param start
	 * @param pageSize
	 * @return
	 */
	public List<Link> findForPage(Integer start,int pageSize);
	
	public void del_link(int id);
	
	public Link findIdLink(int id);
	
	public void updateLink(Link link);
}
