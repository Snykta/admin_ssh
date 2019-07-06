package com.ssh.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 类别实体类
 * @author snykt
 *
 */

@Entity
@Table(name="newtype")
public class NewsType {
	@Id//唯一id
	@GeneratedValue(generator="mygener")
	@GenericGenerator(name="mygener",strategy="native")//整长策略
	private int id;
	@Column(name="names",length=25,nullable=true,unique=false)
	private String names;
	@Column(name="dates",length=35,nullable=true,unique=false)
	private String dates;
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
	public String getDates() {
		return dates;
	}
	public void setDates(String dates) {
		this.dates = dates;
	}
	

}
