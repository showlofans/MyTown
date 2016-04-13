package com.mycountry.add;
import java.sql.*;

import com.mycountry.util.*;


public class AddGroup {

		Connection conn=null;
		DB db=new DB();
		private String group_title;
		private String group_content ;
	
	
		public String getGroupcontent() {
			return group_content ;
		}
		public void setGroupcontent(String group_content ) {
			this.group_content  = group_content ;
		}
	
		public String group() {
			return group_title;
		}
		public void setGrouptitle(String group_title){
			this.group_title = group_title;
		}
	
		
		public AddGroup(){
			
			conn=db.getConn();
		}
		
		/**
		 * Ê∑ªÂä†Â≠¶Áîü‰ø°ÊÅØ
		 * @param username
		 * @param password
		 * @return
		 */
		public String Add_Group(String group_title,String group_content ){
		
		    String flag2=existGroup(group_title);			  	
			if(flag2.equals("notexist")){
				String sql="Insert into group_buying(group_title,group_content) values(";
				sql=sql+"'"+group_title+"',"+"'"+group_content +"')";	
				//System.out.println(sql);
				try{   			
					db.execUpdate(sql);			
					flag2="sucess";		
				}catch(Exception e){
					e.printStackTrace();
					flag2="error1";		
				}
			}else
				flag2="exist";
			return flag2;
		}	
		
		/**
		 * ≈–∂œ–≈œ¢ «∑Ò¥Ê‘⁄÷ÿ∏¥º«¬º
		 */
		
		public String existGroup(String group_title){
		    String sqla="select * from  group_buying  where group_title ='"+group_title+"'";
		    String f="notexist";
		    ResultSet rs=null;
		    try{   			
				rs=db.execSelect(sqla);			
				if(rs.next())
				{
					f="exist";
				}
				
			}catch(Exception e){
				e.printStackTrace();
				f="notexist";
				
			}
			return f;  	
		}
	   
		
		
		
		/*********************************************/
		//–ﬁ∏ƒ
		public String mod_Group(int group_id,String group_title,String group_content){
			
		     String flag2="";
				String sql="update group_buying set group_title='"+group_title+"', group_content='"+group_content+"',  where group_id='"+group_id+"'";
				try{   			
					db.execUpdate(sql);			
					flag2="sucess";		
				}catch(Exception e){
					e.printStackTrace();
					flag2="error";		
				}
		
			return flag2;
		}	
		
		
		//…æ≥˝
	
		public String delete_Group(int group_id){
			
		     String flag2="";
				String sql="delete group_buying where group_id='"+group_id+"'";
				try{   			
					db.execUpdate(sql);			
					flag2="sucess";		
				}catch(Exception e){
					e.printStackTrace();
					flag2="error";		
				}
		
			return flag2;
		}	
		
	
		public void setConnClose(){
			if(conn!=null){
				try{conn.close();}catch(Exception ex){}
			}
			
		}
		
		
	}

