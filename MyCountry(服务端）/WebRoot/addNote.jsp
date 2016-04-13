<%@ page contentType="text/html; charset=utf-8" language="java"
	pageEncoding="utf-8"%>
<%@ page
	import="com.mycountry.add.*,com.mycountry.util.*,java.util.*,com.mycountry.domain.Note,java.io.*, java.text.SimpleDateFormat"%>

<%
	//此页面为由Android端填写学生信息，提交至服务器端的页面
	String param = request.getParameter("httpclient");//获取参数值
	String strImage1 = request.getParameter("strImage1");
	
	String flag = null;
	Note note = new Note();
	AddNote addnote = new AddNote();
	File2StringUtil file2StringUtil = new File2StringUtil(); //创建图片操作类
	
	SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
	String time = df.format(new Date());// new Date()为获取当前系统时间
   	file2StringUtil.byte2Image(strImage1, time);//存图片
	
	String date = new java.util.Date().toLocaleString();
	note.setNote_time(date);
	request.setCharacterEncoding("utf-8");
	String note_title = request.getParameter("note_title").trim();//标题
	String note_content = request.getParameter("note_content").trim(); //内容
	note.setNote_title(note_title);
	note.setNote_content(note_content);
	flag = addnote.Add_Note(note_title,note_content,strImage1,date);

	//String usertype =request.getParameter("sex").trim(); //用户类别

	//name=new String(name.getBytes("iso-8859-1"),"utf-8");
	//  sex=new String(sex.getBytes("iso-8859-1"),"utf-8");
	//   name=new String(name.getBytes("iso-8859-1"),"utf-8");
	/*
	 String namen=MyConverter.escape(name);
	 String phonenumbern=MyConverter.escape(phonenumber);
	 String passwordn=MyConverter.escape(password);
	 String sexn=MyConverter.escape(sex);
	 String emailn=MyConverter.escape(email);*/

	if (flag.equals("sucess")) {
		out.println("发表成功!!");
	} else if (flag.equals("exist")) {
		out.println("已存在");
	} else {
		out.println("发表失败!!!");
	}
%>