package com.mycountry.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionFactory {
	 private Connection conn=null; 
	   ResultSet rs=null;
	   Statement stmt=null;
	   PreparedStatement ps=null;
	public ConnectionFactory() {
		super();
	}

	public static Connection getConnection()
	{
		//����������ݿ�·��
		//������ݿ��û��������
		//����������ݿ������
		
		//����sqlserver2005��ݿ�������д��
		String CLASSFORNAME="com.microsoft.sqlserver.jdbc.SQLServerDriver";	
		
		//����URL����ݿ���ʵĵ�ַ
		  String DBURL="jdbc:sqlserver://192.168.56.1:1433;DatabaseName=mycountry";    
//		  String DBURL="jdbc:sqlserver://192.168.43.225:1433;DatabaseName=mycountry";    
		  
		  //������ݿ��û��������	//100.73.80.118
		  String DBUSER="sa";
		  String DBPWD="jefferson2";
		  
		  Connection conn=null;
		  
		  try{
			  //1 ������ͬʱ�������������
			  Class.forName(CLASSFORNAME);//�ڳ���������jdbc�����ࣨ���䣩
			  //	  
				//2��DriverManager��������ݿ����ӣ�
			   conn=DriverManager.getConnection(DBURL, DBUSER, DBPWD);
			  
		  }catch(Exception ex){ex.printStackTrace();}
		  return conn;
	}
	public static void close(Connection conn, Statement stm, ResultSet rs){
		try {
			if (rs != null)
				rs.close();
			if (stm != null)
				stm.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			System.out.println("�رճ���");
			e.printStackTrace();
		}
	
	}
	public static void main(String[] args) {
		System.out.println(getConnection());
		getConnection();
	}
	
}
