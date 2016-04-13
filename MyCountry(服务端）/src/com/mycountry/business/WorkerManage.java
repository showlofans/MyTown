package com.mycountry.business;

import java.sql.*;

import com.mycountry.util.DB;



import java.util.*;

public class WorkerManage {
	Connection conn = null;
	static DB db = new DB();

	public WorkerManage() {

		conn = db.getConn();
	}

	// 获取学生列表
	public static Vector<String[]> getWorkerList(String sqla)// 得到用户添加的学生信�?
	{
		Vector<String[]> v = new Vector<String[]>();// 创建返回向量
		try {
			ResultSet rs = db.execSelect(sqla);
			while (rs.next()) {// 遍历结果�?
				String s[] = new String[4];
				for (int i = 0; i < s.length; i++) {// 对信息进行转
					s[i] = new String(rs.getString(i + 1));
					// s[i] = new
					// String(rs.getString(i+1).getBytes("iso8859-1"),"utf-8");
					// / System.out.println(s[i]);
				}
				v.add(s);// 将员工信息添加进返回向量
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return v;
	}

	// 根据员工编号获取员工�?��信息
	public static Vector<String[]> getWorkerInfo(String sqla)// 得到用户添加的员工信�?
	{
		Vector<String[]> v = new Vector<String[]>();// 创建返回向量
		try {
			ResultSet rs = db.execSelect(sqla);
			while (rs.next()) {// 遍历结果�?
				String s[] = new String[5];
				for (int i = 0; i < s.length; i++) {// 对信息进行转
					s[i] = new String(rs.getString(i + 1));
					// s[i] = new
					// String(rs.getString(i+1).getBytes("iso8859-1"),"utf-8");
					// / System.out.println(s[i]);
				}
				v.add(s);// 将员工信息添加进返回向量
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return v;
	}

}
