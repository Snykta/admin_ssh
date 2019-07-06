package com.ssh.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="link")
public class Link {
	@Id//唯一id
	@GeneratedValue(generator="mygener")
	@GenericGenerator(name="mygener",strategy="native")//整长策略
	private int id;
	@Column(name="keyword",length=20,nullable=true,unique=false)
	private String keyword;//关键字
	@Column(name="linkad",length=40,nullable=true,unique=false)
	private String linkad;//短链
	@Column(name="states",length=15,nullable=true,unique=false)
	private String states;//状态
	@Column(name="datas",length=50,nullable=true,unique=false)
	private String datas;//时间
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getLinkad() {
		return linkad;
	}
	public void setLinkad(String linkad) {
		this.linkad = linkad;
	}
	public String getStates() {
		return states;
	}
	public void setStates(String states) {
		this.states = states;
	}
	public String getDatas() {
		return datas;
	}
	public void setDatas(String datas) {
		this.datas = datas;
	}
	
	
}
