<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="text/html; charset=utf-8" import="com.mycountry.business.*,com.mycountry.util.*,java.util.*" language="java"%>
<%
  
  String parame=request.getParameter("parame1");
  
  if(parame.equals("wok"))
  {
  //创建一个字符串数组向量
  
  Vector<String[]> v=new Vector<String[]>();
  String sqla="select sno,sname,scollege,ssex from student";
  StringBuffer sb=new StringBuffer();//创建一个缓冲区
  v=WorkerManage.getWorkerList(sqla);
 
  for(String [] s:v){
     sb.append("   ");
     sb.append(s[0]);//用户编号
     sb.append("|");
     sb.append("   ");
     sb.append(s[1]);//用户姓名
     sb.append("|");
     sb.append("   ");
     sb.append(s[2]);//用户性别
       sb.append("|");
     sb.append("   ");
       sb.append(s[3]);//用户电话号吗
        sb.append("|");
  }
  String s=sb.toString();
  out.println(s);
 }else
 {
   out.println("找不到信息");
 }
  
  
  
%>