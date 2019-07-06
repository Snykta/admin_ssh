package com.ssh.action;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;

@Controller("filelists")
@Scope("prototype")
public class FileLists extends ActionSupport{
	private String filelist;
	public String getFilelist() {
		return filelist;
	}
	public void setFilelist(String filelist) {
		this.filelist = filelist;
	}
	
	public String getlistsFile() {
		Map<String,Float> map = new HashMap<String,Float>();
		File file = new File("E:\\apache-tomcat-9.0.11\\webapps\\test");
		File[] files = file.listFiles();
		
		for (File file2 : files) {
			if(!file2.isDirectory()) {
				float filesize = (float)file2.length()/1024;
				map.put(file2.getName(), filesize);
			}
		}
		this.setFilelist(JSON.toJSONString(map));
		System.out.println(this.getFilelist());
		return "lists";
	}
	
	public String delFile() {
		Map<String,String> map = new HashMap<String,String>();
		String path = "E:\\apache-tomcat-9.0.11\\webapps\\test\\"+this.getFilelist();
		File file = new File(path);
		file.delete();
		map.put("state", "1");
		this.setFilelist(JSON.toJSONString(map));
		System.out.println(path);
		return "delfile";
	}
	
	
	
	public static void main(String[] args) {
		File file = new File("E:\\apache-tmcat-9.0.11\\webapps\\test\\a1bc.jpg");
		file.delete();
		System.out.println("1");
	}
}
