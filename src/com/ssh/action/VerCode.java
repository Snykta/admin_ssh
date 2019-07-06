package com.ssh.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.util.Cores;

@Controller("vaercode")
@Scope("prototype")
public class VerCode extends ActionSupport {
	
	public String getcode() {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		response.setContentType("image/jpg");// ������Ӧ����,������������������ΪͼƬ
        response.setHeader("Pragma", "No-cache");// ������Ӧͷ��Ϣ�������������Ҫ���������
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);
        Cores randomValidateCode = new Cores();
        try {
        	randomValidateCode.getRandcode(request, response);// ���ͼƬ����
        	 HttpSession session = request.getSession();
     		String keysy = session.getAttribute("sess_captcha").toString();
     		System.out.println(keysy);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}

}
