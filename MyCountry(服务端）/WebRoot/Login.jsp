<%@ page language="java"
	import="java.util.*,com.mycountry.util.*,com.mycountry.add.Login"
	pageEncoding="utf-8"%>
<%
	//alogin.jsp页面，就是用于接收手机端传输过来的用户名和密码数据，进行验证登录方法

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<%
	//获取到了手机端传递过来 的值，
	String name = request.getParameter("username"); //获取用户名
	String pwd = request.getParameter("pwd"); //获取密码

	// String name="a";	//获取用户名
	//String pwd="123";	//获取密码

	Login login = new Login();
	login.setUsername(name.trim());
	login.setUserpwd(pwd.trim());
	String flag = login.DengLu();

	if (flag.equals("success")) { //判断用户名是否正确
		out.print("登录成功");
		// session.setAttribute("username",name);
		// response.sendRedirect("index.jsp");	//重定向页面到index.jsp页面
	} else {
		out.print("登录失败");
	}
%>