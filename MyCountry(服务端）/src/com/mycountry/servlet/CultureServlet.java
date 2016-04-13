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
import com.mycountry.domain.Culture;
import com.mycountry.service.CultureService;

public class CultureServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		try {
			PrintWriter out = response.getWriter();
			List<Culture> cultures = new ArrayList(); // 返回JoinService的数据
			CultureService dao = new CultureService();
			cultures = dao.find();
			Gson gson = new Gson();
			String x = gson.toJson(cultures);
			out.write(new String(x));
			out.flush();
			out.close();// 关闭
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
