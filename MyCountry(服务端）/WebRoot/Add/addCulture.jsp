<%@ page contentType="text/html; charset=utf-8" language="java"
	pageEncoding="utf-8"%>
<%@ page
	import="com.mycountry.add.*,com.mycountry.util.*,java.util.*,com.mycountry.domain.Culture,java.io.*, java.text.SimpleDateFormat"%>

<%
	//此页面为由Android端填写学生信息，提交至服务器端的页面
	//String param = request.getParameter("httpclient");//获取参数值
	String culture_picture = request.getParameter("culture_picture");
	//String strImage1 ="image/koo.png";
	String flag = null;
	Culture culture = new Culture();
	AddCulture addculture = new AddCulture();
	File2StringUtil file2StringUtil = new File2StringUtil(); //创建图片操作类

	SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
	String time = df.format(new Date());// new Date()为获取当前系统时间
	file2StringUtil.byte2Image(culture_picture, time);//存图片
	
	String time1="image/"+time + ".jpg";

	String date = new java.util.Date().toLocaleString();
	//     String date ="dewff";
	culture.setCulture_time(date);
	request.setCharacterEncoding("utf-8");
	String culture_title = request.getParameter("culture_title").trim();//标题
	String culture_content = request.getParameter("culture_content").trim(); //内容
	culture.setCulture_title(culture_title);
	culture.setCulture_content(culture_content);
	culture.setCulture_picture(culture_picture);
	flag = addculture.Add_Culture(culture_title, culture_content, time1, date);



	if (flag.equals("sucess")) {
		out.println("发表成功!!");
	} else if (flag.equals("exist")) {
		out.println("已存在");
	} else {
		out.println("发表失败!!!");
	}
%>