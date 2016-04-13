<%@ page language="java" import="java.util.*,com.mycountry.util.*,java.sql.*" pageEncoding="utf-8"%>

<%
   request.setCharacterEncoding("utf-8");
   
   String note_id=request.getParameter("note_id");
   
   String note_title =request.getParameter("note_title");
      
   String note_content =request.getParameter("note_content");
      
   //String scollege =request.getParameter("scollege");
      
   //String sgrade =request.getParameter("sgrade");
      
  // String ssex =request.getParameter("ssex");
      
   int sstatus =Integer.parseInt(request.getParameter("sstatus"));
      
   //定义添加学生信息
   
   String sql="insert into student values('"+note_id+"','"+note_title+"','"+note_content+"')";
   
   
   
  // String sql="update student set sname='"+sname+"',   sclass='"+sclass+"', scollege='"+scollege+"', sgrade='"+sgrade+"', ssex='"+ssex+"', sstatus='"+sstatus+"'  where sno="+sno;
    DB db=new DB();
  String flag=db.execUpdate(sql);
   
   if(flag.equals("success"))
   {
      out.println("你添加成功");
     
   }else
   out.print("添加失败");
     %>
      <a href="../index.jsp" >返回到主界面</a>
  
      
      <%
    
  


%>