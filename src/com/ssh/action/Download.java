package com.ssh.action;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLEncoder;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller("download")
@Scope("prototype")
public class Download extends ActionSupport {
	private String filename;

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	public String downfile() {
		return "download";
	}
	
	public InputStream getFileStream() throws Exception {//¾ø¶ÔÂ·¾¶
		filename = URLEncoder.encode(filename, "UTF-8");
		System.out.println(this.filename);
		return new FileInputStream("E:\\apache-tomcat-9.0.11\\webapps\\test\\"+filename);
	}
	


}
