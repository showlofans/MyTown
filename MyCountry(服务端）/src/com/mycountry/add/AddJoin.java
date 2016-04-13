package com.mycountry.add;
import java.sql.*;

import com.mycountry.util.*;


public class AddJoin {

		Connection conn=null;
		DB db=new DB();
		private String join_title;
		private String join_content ;
	
	
		public String getJoincontent() {
			return join_content ;
		}
		public void setJoincontent(String join_content ) {
			this.join_content  = join_content ;
		}
	
		public String getJointitle() {
			return join_title;
		}
		public void setJointitle(String join_title){
			this.join_title = join_title;
		}
	
		
		public AddJoin(){
			
			conn=db.getConn();
		}
		
		/**
		 * Ê∑ªÂä†Â≠¶Áîü‰ø°ÊÅØ
		 * @param username
		 * @param password
		 * @return
		 */
		public String Add_Join(String join_title,String join_content ){
		
		    String flag2=existJoin(join_title);			  	
			if(flag2.equals("notexist")){
				String sql="Insert into _join(join_title,join_content) values(";
				sql=sql+"'"+join_title+"',"+"'"+join_content +"')";	
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
		
		public String existJoin(String join_title){
		    String sqla="select * from  _join  where join_title ='"+join_title+"'";
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
		public String mod_Join(int join_id,String join_title,String join_content){
			
		     String flag2="";
				String sql="update _join set join_title='"+join_title+"', join_content='"+join_content+"',  where join_id='"+join_id+"'";
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
	
		public String delete_Join(int join_id){
			
		     String flag2="";
				String sql="delete _join where join_id='"+join_id+"'";
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

