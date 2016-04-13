package com.mycountry.add;
import java.sql.*;

import com.mycountry.util.*;


public class AddPifa {

		Connection conn=null;
		DB db=new DB();
		private String pifa_title;
		private String pifa_content ;
	
	
		public String getPifacontent() {
			return pifa_content ;
		}
		public void setPifacontent(String pifa_content ) {
			this.pifa_content  = pifa_content ;
		}
	
		public String getPifatitle() {
			return pifa_title;
		}
		public void setPifatitle(String pifa_title){
			this.pifa_title = pifa_title;
		}
	
		
		public AddPifa(){
			
			conn=db.getConn();
		}
		
		/**
		 * Ê∑ªÂä†Â≠¶Áîü‰ø°ÊÅØ
		 * @param username
		 * @param password
		 * @return
		 */
		public String Add_Pifa(String pifa_title,String pifa_content ){
		
		    String flag2=existPifa(pifa_title);			  	
			if(flag2.equals("notexist")){
				String sql="Insert into note(pifa_title,pifa_content) values(";
				sql=sql+"'"+pifa_title+"',"+"'"+pifa_content +"')";	
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
		
		public String existPifa(String pifa_title){
		    String sqla="select * from  pifa  where pifa_title ='"+pifa_title+"'";
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
		public String mod_Pifa(int pifa_id,String pifa_title,String pifa_content){
			
		     String flag2="";
				String sql="update pifa set pifa_title='"+pifa_title+"', pifa_content='"+pifa_content+"',  where pifa_id='"+pifa_id+"'";
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
	
		public String delete_Pifa(int pifa_id){
			
		     String flag2="";
				String sql="delete note where pifa_id='"+pifa_id+"'";
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

