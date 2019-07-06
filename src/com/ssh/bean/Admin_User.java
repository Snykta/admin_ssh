package com.ssh.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
/**
 * 后台管理员登录实体类
 * @author snykt
 *
 */
@Entity
@Table(name="admin_user")
public class Admin_User {
	@Id//唯一id
	@GeneratedValue(generator="mygener")
	@GenericGenerator(name="mygener",strategy="native")//整长策略
	private int id;
	
	@Column(name="users",length=15,nullable=true,unique=false)
	private String users;
	
	@Column(name="password",length=20,nullable=true,unique=false)
	private String password;
	
	@Column(name="names",length=25,nullable=true,unique=false)
	private String names;
	
	@Column(name="email",length=35,nullable=true,unique=false)
	private String email;
	
	@Column(name="dates",length=40,nullable=true,unique=false)
	private String dates;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsers() {
		return users;
	}

	public void setUsers(String users) {
		this.users = users;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDates() {
		return dates;
	}

	public void setDates(String dates) {
		this.dates = dates;
	}
	
	
	

}
