<%@ page contentType="text/html; charset=utf-8"
	import="com.mycountry.add.*,com.mycountry.util.*" language="java"%>
<%
	//此页面为由Android端填写学生信息，提交至服务器端的页面

	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name").trim();//用户名
	String password = request.getParameter("password").trim(); //密码

	String usertype = request.getParameter("type").trim(); //用户类别

	//name=new String(name.getBytes("iso-8859-1"),"utf-8");
	//  sex=new String(sex.getBytes("iso-8859-1"),"utf-8");
	//   name=new String(name.getBytes("iso-8859-1"),"utf-8");
	/*
	 String namen=MyConverter.escape(name);
	 String phonenumbern=MyConverter.escape(phonenumber);
	 String passwordn=MyConverter.escape(password);
	 String sexn=MyConverter.escape(sex);
	 String emailn=MyConverter.escape(email);*/

	Register aw = new Register();
	String k = aw.Add_Worker(name, password, usertype);
	if (k.equals("sucess")) {
		out.print("添加学生信息成功!!");
	} else if (k.equals("exist")) {
		out.print("该学生已存在");
	} else {
		out.print("添加该学生失败!!!");
	}
