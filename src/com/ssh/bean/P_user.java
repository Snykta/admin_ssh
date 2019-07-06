package com.ssh.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="p_users")
public class P_user {
	@Id//唯一id
	@GeneratedValue(generator="mygener")
	@GenericGenerator(name="mygener",strategy="native")//整长策略
	private int id;
	@Column(name="names",length=20,nullable=true,unique=false)
	private String names;//名字
	@Column(name="sex",length=10,nullable=true,unique=false)
	private String sex;//性别
	@Column(name="iphone",length=40,nullable=true,unique=false)
	private String iphone;//手机号
	@Column(name="email",length=45,nullable=true,unique=false)
	private String email;//邮箱
	@Column(name="states",length=10,nullable=true,unique=false)
	private String states;//状态
	public P_user() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNames() {
		return names;
	}
	public void setNames(String names) {
		this.names = names;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getIphone() {
		return iphone;
	}
	public void setIphone(String iphone) {
		this.iphone = iphone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStates() {
		return states;
	}
	public void setStates(String states) {
		this.states = states;
	}
	@Override
	public String toString() {
		return "P_user [id=" + id + ", names=" + names + ", sex=" + sex + ", iphone=" + iphone + ", email=" + email
				+ ", states=" + states + "]";
	}
	
}
