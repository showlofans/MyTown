<%@ page contentType="text/html; charset=utf-8" import="com.mycountry.add.*,com.mycountry.util.*" language="java"%>
<%
   //此页面为由Android端填写学生信息，提交至服务器端的页面


  request.setCharacterEncoding("utf-8");
  String join_title=request.getParameter("join_title").trim();//标题
  String join_content=request.getParameter("join_content").trim(); //内容
 
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
   
  AddJoin aw=new AddJoin(); 
  String k=aw.Add_Join(join_title,join_content);
  if(k.equals("sucess"))
  {
    out.print("发表成功!!");
  }else{
     out.print("发表失败!!!");
  }

%>