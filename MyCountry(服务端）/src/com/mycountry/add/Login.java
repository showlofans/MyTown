package com.mycountry.add;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.mycountry.util.DB;


public class Login {

	 //灞炴�
	  //鏂规硶
	DB db=null; //鎿嶄綔鏁版嵁搴撶被
	private String username;
	private String userpwd;
	private int usertype;//鐢ㄦ埛绫诲瀷(1琛ㄧず瀛︾敓,2琛ㄧず鏁欏笀绠＄悊鍛�

	//鏋勯�鏂规硶
	
	public Login()
	{
		db=new DB();
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public int getUsertype() {
		return usertype;
	}

	public void setUsertype(int usertype) {
		this.usertype = usertype;
	}
	
	
	//鐧诲綍鏂规硶
	
	public String DengLu()
	{
		String sql="select * from userinfo where username='"+this.getUsername()+"'";
	
		ResultSet rs=db.execSelect(sql);
	 String flag="";
		try {
			if(rs.next())
			{
				
				if(rs.getString("userpwd").equals(this.getUserpwd()))
				
				    flag="success";
				else 
					flag="error";
			}else
				flag="error";
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return flag;
		
	}	
	
}
