package com.mycountry.util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DB {
  	   private Connection conn=null; 
	   ResultSet rs=null;
	   Statement stmt=null;
	   PreparedStatement ps=null;
  public  DB(){
	 this.conn=ConnectionFactory.getConnection();
	}
	
	public Connection getConn()
	{
		return this.conn;		
	}
	
	
	public ResultSet execSelect(String sql){

		try{
			stmt=conn.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_READ_ONLY);
			rs=stmt.executeQuery(sql);
		}catch(SQLException se){
			
			System.out.print(se.getMessage());
		}
		
		return rs;
	}
	
	
	public String execUpdate(String sql) {
		Statement stmt=null;
		String flag="";
		try{
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			stmt.executeUpdate(sql);
			flag="success";
		}catch(SQLException se){
			System.out.print(se.getMessage());
			
			flag="error";
		}
	
		return flag;
	}

	public String exec(String sql) {
		Statement stmt=null;
		String flag="";
		try{
			stmt=conn.createStatement();
			stmt.execute(sql);			
			flag="success";
		}catch(SQLException se){
			System.out.print(se.getMessage());
			
			flag="error";
		}
	
		return flag;
	}
	
    /**
	 * �ر�conn
	 */
    
    public void setConnClose() {
        try{
	            
        	conn.close();
		    }catch (Exception e) {}
	}
   
    public void freeCon(){
        try {
          if (rs!=null)
            rs.close() ;
          if (ps!=null)
            ps.close() ;
          if(conn!=null)
          	conn.close();
        }
        catch (SQLException ex) {
        }
    }

   /* public static void  main(String[] args){
    	ResultSet rs11=null;
    	DB db1=new DB();
    	Statement stmt=null;
    	String sql="select * from userinfo  ";
        try{	
           stmt=db1.getConn().createStatement(); 
    	   rs11=stmt.executeQuery(sql);
    	   while(rs11.next())
    	   {
    		   
    		  String i=rs11.getString("username");
    		  String j=rs11.getString("userpwd");
                   System.out.println(i);
                   System.out.println(j);
            }  
        }catch(Exception ex)
        { ex.printStackTrace() ;}
        
        }
  */
    
    
}
