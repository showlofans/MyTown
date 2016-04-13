package com.mycountry.add;
import java.sql.*;

import com.mycountry.util.*;


public class AddCultivation {

		Connection conn=null;
		DB db=new DB();
		private String cultivation_title;
		private String cultivation_content ;
	
	
		public String getCultivationcontent() {
			return cultivation_content ;
		}
		public void setCultivationcontent(String cultivation_content ) {
			this.cultivation_content  = cultivation_content ;
		}
	
		public String getCultivationtitle() {
			return cultivation_title;
		}
		public void setCultivationtitle(String cultivation_title){
			this.cultivation_title = cultivation_title;
		}
	
		
		public AddCultivation(){
			
			conn=db.getConn();
		}
		
		/**
		 * Ê∑ªÂä†Â≠¶Áîü‰ø°ÊÅØ
		 * @param username
		 * @param password
		 * @return
		 */
		public String Add_Cultivation(String cultivation_title,String cultivations_content ){
		
		    String flag2=existCultivation(cultivation_title);			  	
			if(flag2.equals("notexist")){
				String sql="Insert into cultivation(cultivation_title,cultivation_content) values(";
				sql=sql+"'"+cultivation_title+"',"+"'"+cultivations_content +"')";	
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
		
		public String existCultivation(String cultivation_title){
		    String sqla="select * from  cultivation  where cultivation_title ='"+cultivation_title+"'";
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
		public String mod_Cultivation(int cultivation_id,String cultivation,String note_content){
			
		     String flag2="";
				String sql="update note set cultivation_title='"+cultivation_title+"', cultivation_content='"+cultivation_content+"',  where cultivation_id='"+cultivation_id+"'";
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
	
		public String delete_Cultivation(int cultivation_id){
			
		     String flag2="";
				String sql="delete note where cultivation_id='"+cultivation_id+"'";
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

