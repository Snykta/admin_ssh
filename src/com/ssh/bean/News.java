package com.ssh.bean;

import java.io.File;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

/**
 * ����ʵ����
 * @author snykt
 *
 */

@Entity
@Table(name="news")
public class News {
	@Id//Ψһid
	@GeneratedValue(generator="mygener")
	@GenericGenerator(name="mygener",strategy="native")//��������
	private int id;

	@Column(name="title",length=20,nullable=true,unique=false)
	private String title;//����
	
	@Column(name="keyword",length=25,nullable=true,unique=false)
	private String keyword;//�ؼ���
	
	@Column(name="descs",length=25,nullable=true,unique=false)
	private String descs;//����
	
	@Column(name="sort",length=15,nullable=true,unique=false)
	private String sort;//����
	
	@Column(name="source",length=30,nullable=true,unique=false)
	private String source;//��Դ
	
	@Column(name="author",length=20,nullable=true,unique=false)
	private String author;//����
	
	@Column(name="datas",length=35,nullable=true,unique=false)
	private String datas;//ʱ��
	
	@Transient
	private File myfile;
	
	@Transient
	private String myfileContentType;
	
	@Column(name="imgs",length=35,nullable=true,unique=false)
	private String myfileFileName;//����ͼ
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getDescs() {
		return descs;
	}

	public void setDescs(String descs) {
		this.descs = descs;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}


	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	public File getMyfile() {
		return myfile;
	}
	public void setMyfile(File myfile) {
		this.myfile = myfile;
	}
	public String getMyfileContentType() {
		return myfileContentType;
	}
	public void setMyfileContentType(String myfileContentType) {
		this.myfileContentType = myfileContentType;
	}
	public String getMyfileFileName() {
		return myfileFileName;
	}
	public void setMyfileFileName(String myfileFileName) {
		this.myfileFileName = myfileFileName;
	}

	public String getDatas() {
		return datas;
	}

	public void setDatas(String datas) {
		this.datas = datas;
	}
	
	
	
	
}
