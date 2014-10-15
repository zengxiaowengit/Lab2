package com;

import impl.regImpl;

import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import impl.select;

@Namespace("")
@Results({ @Result(name = "loginSuccess", location = "/query.jsp"),
		@Result(name = "loginFailure", location = "/index.jsp"),
		@Result(name = "checkSuccess", location = "/login.jsp"),
		@Result(name = "checkFailure", location = "/register.jsp") })
public class loginAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String reg_username;
	private String reg_password;
	private String resultMsg;
	private int resultInt;
	regImpl reg = new regImpl();

	// ��Ӧ��jsp:
	// namespace/����!������.action
	// <form action="action/login!login.action">

	// Action!������.action
	// <form action="login!login.action">
	 @Action("register")
	public String register() throws Exception {
		// ��֤�û����Ƿ��ظ�
		resultInt = reg.findByUserName(reg_username);
		if (resultInt != 0) {
			resultMsg = "�û����ѱ�ʹ�ã�����������";
			return "registerFailure";
		} else {
			resultInt = reg.register(reg_username, reg_password);
			if (1 == resultInt) {
				// 1. ���û���Ϣ���浽Session�С�
				Map<String, Object> session = ActionContext.getContext()
						.getSession();
				session.put("reg_username", reg_username);
				session.put("reg_password", reg_password);
				// 2. ��ʶ����
				resultMsg = "ע��ɹ�";
				return "registerSuccess";
			} else {
				resultMsg = "ע��ʧ��";
				return "registerFailure";
			}
		}
	}

	// ��¼
	 @Action("login")  
	public String login() {
		resultMsg = null;
		// ���û��������ʽ������֤//Ӧ������jspҳ��javScript
		if ("".equals(username) || username == null) {
			resultMsg = "�û�������Ϊ��";
			return "checkFailure";
		} else if ("".equals(password) || password == null) {
			resultMsg = "���벻��Ϊ��";
			return "checkFailure";
		} else {
			if (password.length() < 4 || password.length() > 10) {
				resultMsg = "���������4��10֮��";
				return "checkFailure";
			}
		}
		// ���ݿ��ѯ�������û����������ݿ�������ƥ�����
		select select1 = new select();
		int resultInt = select1.selectStatement(username, password);

		if (1 == resultInt) {
			Map<String, Object> session = ActionContext.getContext()
					.getSession();
			session.put("usernameMsg", username);
			resultMsg = "��¼�ɹ�";
			return "loginSuccess";
		} else {
			resultMsg = "��¼ʧ��";
			return "loginFailure";
		}
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public String getReg_username() {
		return reg_username;
	}

	public void setReg_username(String reg_username) {
		this.reg_username = reg_username;
	}

	public String getReg_password() {
		return reg_password;
	}

	public void setReg_password(String reg_password) {
		this.reg_password = reg_password;
	}
	
	public String getUsername(){
		return username;
	}
	
	public void setUsername(String username){
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
