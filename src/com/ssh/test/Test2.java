package com.ssh.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Test2 {
	
	public static void main(String[] args) {
		File file = new File("E:\\apache-tomcat-9.0.11\\webapps\\test");
		File[] aa = file.listFiles();
		int num = 0;
		List<String> lists = new ArrayList<String>();
		for (File file2 : aa) {
			
			if(!file2.isDirectory()) {
				num++;
				System.out.println(file2.getName());
				float filesize = (float)file2.length()/1024;
				System.out.println(filesize);
				lists.add(file2.getName());
			}
			//System.out.println(file2.get);
		}
		System.out.println(num);
		System.out.println(lists);
	}

}
