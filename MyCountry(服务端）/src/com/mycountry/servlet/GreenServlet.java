package com.mycountry.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.mycountry.domain.Green;
import com.mycountry.service.GreenService;

public class GreenServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		try {
			PrintWriter out = response.getWriter();
			List<Green> greens = new ArrayList(); // ����JoinService�����
			GreenService dao = new GreenService();
			greens = dao.find();
			Gson gson = new Gson();
			String x = gson.toJson(greens);
//			StringBuffer sBuffer= new StringBuffer();
//			sBuffer.append(x);
//			String y = sBuffer.toString();
			out.write(new String(x));
			out.flush();
			out.close();// �ر�
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("utf-8");
		String title = request.getParameter("search");
		List<Green> greens = new ArrayList(); // ����JoinService�����
		GreenService dao = new GreenService();
		Gson gson = new Gson();
		greens = dao.Serch(title);
		if (greens == null) {
			log("ABC");
			out.write("ABC");
		} else {
			String x = gson.toJson(greens);
			out.write(new String(x));
			log(x);
		}
		out.flush();
		out.close();// �ر�
	}

}
