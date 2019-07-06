package com.ssh.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 登录日志实体类
 * @author snykt
 *
 */
@Entity
@Table(name="login_log")
public class Login_log {
	@Id//唯一id
	@GeneratedValue(generator="mygener")
	@GenericGenerator(name="mygener",strategy="native")//整长策略
	private int uid;
	
	@Column(name="login_ip",length=20,nullable=true,unique=false)
	private String login_ip;
	
	@Column(name="site",length=20,nullable=true,unique=false)
	private String site;
	
	@Column(name="dates",length=20,nullable=true,unique=false)
	private String dates;
	
	@Column(name="endlog",length=10,nullable=true,unique=false)
	private String endlog;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getLogin_ip() {
		return login_ip;
	}

	public void setLogin_ip(String login_ip) {
		this.login_ip = login_ip;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getDates() {
		return dates;
	}

	public void setDates(String dates) {
		this.dates = dates;
	}

	public String getEndlog() {
		return endlog;
	}

	public void setEndlog(String endlog) {
		this.endlog = endlog;
	}
	
	
}
