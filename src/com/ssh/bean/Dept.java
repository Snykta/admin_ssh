package com.ssh.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/*
 * 关联关系，在此维护在一的一方
 */

@Entity
@Table(name="dept")
public class Dept {
	@Id//唯一id
	@GeneratedValue(generator="mygener")
	@GenericGenerator(name="mygener",strategy="native")//整长策略
	private int id;
	@Column(name="ename",length=30,nullable=true,unique=false)
	private String ename;
	@Column(name="datas",length=40,nullable=true,unique=false)
	private String datas;
	@OneToMany(targetEntity=P_user.class,cascade=CascadeType.ALL)
	@JoinColumn(name="dept_id")
	private Set<P_user> puser = new HashSet<P_user>();
	public Dept() {

	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getDatas() {
		return datas;
	}
	public void setDatas(String datas) {
		this.datas = datas;
	}
	public Set<P_user> getPuser() {
		return puser;
	}
	public void setPuser(Set<P_user> puser) {
		this.puser = puser;
	}
	@Override
	public String toString() {
		return "Dept [id=" + id + ", ename=" + ename + ", datas=" + datas + ", puser=" + puser + "]";
	}
	
}
