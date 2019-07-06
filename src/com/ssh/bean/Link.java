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
	@Id//Ψһid
	@GeneratedValue(generator="mygener")
	@GenericGenerator(name="mygener",strategy="native")//��������
	private int id;
	@Column(name="keyword",length=20,nullable=true,unique=false)
	private String keyword;//�ؼ���
	@Column(name="linkad",length=40,nullable=true,unique=false)
	private String linkad;//����
	@Column(name="states",length=15,nullable=true,unique=false)
	private String states;//״̬
	@Column(name="datas",length=50,nullable=true,unique=false)
	private String datas;//ʱ��
	
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
