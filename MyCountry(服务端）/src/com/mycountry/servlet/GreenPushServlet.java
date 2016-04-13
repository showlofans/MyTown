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
import com.mycountry.domain.GreenPush;
import com.mycountry.service.GreenPushService;

public class GreenPushServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		try {
			PrintWriter out = response.getWriter();
			List<GreenPush> pushs = new ArrayList(); // ����JoinService������
			GreenPushService dao = new GreenPushService();
			pushs = dao.find();
			Gson gson = new Gson();
			String x = gson.toJson(pushs);
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
		doGet(request, response);
	}

}
