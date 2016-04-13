<%@ page language="java" import="java.util.*,com.mycountry.util.*,java.sql.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'modfiyPerson.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>

<% 
 //获取sno  
  
 
 %>


  <center>
  <form  action="personManage/addPerson_do.jsp" method="post" name="fdfd">
     <table border="1">
      <tr>
           <td colspan="2">添加学生信息</td> 
         </tr>  
       <tr>
           <td>学号</td> <td><input type="text" name="sno"  value="" /></td>
         </tr>  
        
         <tr>
           <td>姓名</td> <td><input type="text" name="sname" value="" /></td>
         </tr>  
          
              <tr>
           <td>班级</td> <td><input type="text" name="sclass"value=""/></td>
         </tr>  
         
             <tr>
           <td>学院</td> <td><input type="text" name="scollege" value=""/></td>
         </tr>  
             <tr>
           <td>年级</td> <td><input type="text" name="sgrade" value=""/></td>
         </tr>  
             <tr>
           <td>性别</td> <td><input type="text" name="ssex" value=""/></td>
         </tr>  
             <tr>
           <td>状态</td> <td><input type="text" name="sstatus" value="" /></td>
         </tr>     
           
        
        <tr><td><input type="submit" value="添加学生信息" /></td></tr>
       
       </table>
       </form>
       </center>








 <center>
     <table border="1">
       <tr>
           <td>学号</td>
           <td>姓名 </td>
            <td>班级 </td>
             <td>学院 </td>
              <td>年级 </td>
               <td>性别 </td>
                <td>状态 </td>
                
       </tr>
       
       <%
       
        DB db=new DB();
          String sql="select * from student";
          ResultSet rs=db.execSelect(sql);
          
          while(rs.next())
          {
              %>
         <tr>
           <td><%=rs.getString("sno") %></td>
           <td><%=rs.getString("sname") %> </td>
            <td><%=rs.getString("sclass") %></td>
             <td><%=rs.getString("scollege") %> </td>
              <td><%=rs.getString("sgrade") %> </td>
               <td><%=rs.getString("ssex") %> </td>
                <td><%=rs.getString("sstatus") %> </td>
                  
            </tr>
           <% 
          
          }
          
          rs.close();
          
       
       
       
        %>
       
     
     </table>
    
    
    
    </center>









  </body>
</html>
