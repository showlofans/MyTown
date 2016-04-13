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
import com.mycountry.domain.Business;
import com.mycountry.domain.Culture;
import com.mycountry.domain.Fruit;
import com.mycountry.domain.Ganhuo;
import com.mycountry.domain.Green;
import com.mycountry.domain.Liangyou;
import com.mycountry.domain.Meat;
import com.mycountry.domain.Push;
import com.mycountry.domain.Push1;
import com.mycountry.domain.Push2;
import com.mycountry.domain.Push3;
import com.mycountry.domain.Push4;
import com.mycountry.domain.Techan;
import com.mycountry.domain.Tour;
import com.mycountry.domain.Vegetable;
import com.mycountry.domain.Wine;
import com.mycountry.service.BusinessService;
import com.mycountry.service.CultureService;
import com.mycountry.service.FruitService;
import com.mycountry.service.GanhuoService;
import com.mycountry.service.GreenService;
import com.mycountry.service.LiangyouService;
import com.mycountry.service.MeatService;
import com.mycountry.service.Push1Service;
import com.mycountry.service.Push2Service;
import com.mycountry.service.Push3Service;
import com.mycountry.service.Push4Service;
import com.mycountry.service.PushService;
import com.mycountry.service.TechanService;
import com.mycountry.service.TourService;
import com.mycountry.service.VegetableService;
import com.mycountry.service.WineService;

public class SearchServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("utf-8");
		// try {
		PrintWriter out = response.getWriter();
		String title = request.getParameter("search");
		Gson gson = new Gson();

		List<Business> businesss = new ArrayList(); // ����JoinService�����
		BusinessService dao1 = new BusinessService();
		businesss = dao1.Serch(title);
		String x1 = gson.toJson(businesss);
		log(x1);

		List<Green> greens = new ArrayList(); // ����JoinService�����
		GreenService dao2 = new GreenService();
		greens = dao2.Serch(title);
		String x2 = gson.toJson(greens);
		log(x2);

		List<Fruit> fruits = new ArrayList(); // ����FruitService�����
		FruitService dao3 = new FruitService();
		fruits = dao3.Serch(title);
		String x3 = gson.toJson(fruits);
		log(x3);
		
		List<Ganhuo> ganhuos = new ArrayList(); // ����JoinService�����
		GanhuoService dao4 = new GanhuoService();
		ganhuos = dao4.Serch(title);
		String x4 = gson.toJson(ganhuos);
		log(x4);

		List<Liangyou> liangyous = new ArrayList();
		LiangyouService dao5 = new LiangyouService();
		liangyous = dao5.Serch(title);
		String x5 = gson.toJson(liangyous);
		log(x5);

		List<Meat> meats = new ArrayList(); // ����JoinService�����
		MeatService dao6 = new MeatService();
		meats = dao6.Serch(title);
		String x6 = gson.toJson(meats);
		log(x6);

		List<Push1> push1 = new ArrayList();
		Push1Service dao7 = new Push1Service();
		push1 = dao7.Serch(title);
		String x7 = gson.toJson(push1);
		log(x7);

		List<Push2> push2 = new ArrayList();
		Push2Service dao8 = new Push2Service();
		push2 = dao8.Serch(title);
		String x8 = gson.toJson(push2);
		log(x8);

		List<Push3> push3 = new ArrayList();
		Push3Service dao9 = new Push3Service();
		push3 = dao9.Serch(title);
		String x9 = gson.toJson(push3);
		log(x9);

		List<Push4> push4 = new ArrayList();
		Push4Service dao11 = new Push4Service();
		push4 = dao11.Serch(title);
		String x11 = gson.toJson(push4);
		log(x11);

		List<Push> pushs = new ArrayList(); // ����JoinService�����
		PushService dao12 = new PushService();
		pushs = dao12.Serch(title);
		String x12 = gson.toJson(pushs);
		log(x12);

		List<Techan> techans = new ArrayList(); // ����JoinService�����
		TechanService dao13 = new TechanService();
		techans = dao13.Serch(title);
		String x13 = gson.toJson(techans);
		log(x13);

		List<Tour> tours = new ArrayList(); // ����JoinService�����
		TourService dao14 = new TourService();
		tours = dao14.Serch(title);
		String x14 = gson.toJson(tours);
		log(x14);

		List<Vegetable> vegetables = new ArrayList(); // ����JoinService�����
		VegetableService dao15 = new VegetableService();
		vegetables = dao15.Serch(title);
		String x15 = gson.toJson(vegetables);
		log(x15);

		List<Wine> wines = new ArrayList(); // ����JoinService�����
		WineService dao16 = new WineService();
		wines = dao16.find();
		String x16 = gson.toJson(wines);
		log(x16);

		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append(x1);
		sBuffer.append(x2);
		sBuffer.append(x3);
		sBuffer.append(x4);
		sBuffer.append(x5);
		sBuffer.append(x6);
		sBuffer.append(x7);
		sBuffer.append(x8);
		sBuffer.append(x9);
		sBuffer.append(x11);
		sBuffer.append(x12);
		sBuffer.append(x13);
		sBuffer.append(x14);
		sBuffer.append(x15);
		sBuffer.append(x16);

		String y = sBuffer.toString();
		log(y);
		out.write(new String(y));
		out.flush();
		out.close();
		// }
		// catch (Exception e) {
		// System.out.println(e);
		// e.printStackTrace();
		// }

	}

}
