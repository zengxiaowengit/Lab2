<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
	pageEncoding="GBK"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="/struts-tags" prefix="h"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>ע��ҳ��</title>
</head>
<body>
	<h4>�������û�ע����Ϣ</h4>
	����˴�
	<a href="/MyLibrary/index.jsp">��¼</a>
	<h:form action="register!register.action">
		<table>
			<tr>
				<td>�û���:</td>
				<td colspan=2><input type="text" name="reg_username" />
				</td>
			</tr>
			<tr>
				<td>����:</td>
				<td colspan=2><input type="password" name="reg_password" />
				</td>
			</tr>
			<tr>
				<td>
				</td>
				<td colspan=2>
				<input type="reset" name="reset" value="����" />
				<input type="submit" name="register" value="ע��" />
				</td>
				<td><font color="red"><h:property value="resultMsg" /></font></td>
			</tr>
		</table>


	</h:form>
</body>
</html>
