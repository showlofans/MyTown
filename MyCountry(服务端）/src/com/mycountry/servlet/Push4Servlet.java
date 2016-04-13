package com.mycountry.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.mycountry.domain.Push4;
import com.mycountry.service.Push4Service;

public class Push4Servlet extends HttpServlet{
	public void doGet(HttpServletRequest resquest,HttpServletResponse response)
			throws ServletException, IOException{
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		try {
			PrintWriter out = response.getWriter();
			List<Push4> push4 = new ArrayList();
			Push4Service dao = new Push4Service();
			push4 = dao.find();
			Gson gson = new Gson();
			String x = gson.toJson(push4);
			
			out.write(new String(x));
			out.flush();
			out.close();// ¹Ø±Õ
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
