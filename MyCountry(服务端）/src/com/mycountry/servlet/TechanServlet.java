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
import com.mycountry.domain.Techan;
import com.mycountry.service.TechanService;




public class TechanServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		try {
			PrintWriter out = response.getWriter();
			List<Techan> techans = new ArrayList(); // ����JoinService������
			TechanService dao = new TechanService();
			techans = dao.find();
			Gson gson = new Gson();
			String x = gson.toJson(techans);
//			StringBuffer sb = new StringBuffer();// ���ݻ���
//			sb.append('[');

//			for (Pifa pifa : pifas) {// person.getName(),person.getAddress()�����������ַ��һЩ����ת��Ϊchar
//			// �������=> {"name":"����","address":"��ַ","age":����},
//				sb.append('{').append("\"pifa_id\":")
//						.append("\"" + pifa.getPifa_id() + "\"").append(",");
//				sb.append("\"pifa_title\":")
//						.append("\"" + pifa.getPifa_title() + "\"").append(",");
//				sb.append("\"pifa_content\":").append(pifa.getPifa_content());
//				sb.append('}').append(",");
//				sb.append("\"pifa_picture\":")
//				.append("\"" + pifa.getPifa_picture() + "\"").append(",");
//				sb.append("\"pifa_time\":")
//				.append("\"" + pifa.getPifa_time() + "\"").append(",");
//			}
//			sb.deleteCharAt(sb.length() - 1);
//			sb.append(']');
			
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