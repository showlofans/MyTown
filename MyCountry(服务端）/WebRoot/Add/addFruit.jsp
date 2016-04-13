<%@ page contentType="text/html; charset=utf-8" language="java"
	pageEncoding="utf-8"%>
<%@ page
import="com.mycountry.add.*,com.mycountry.util.*,java.util.*,com.mycountry.domain.*,java.io.*, java.text.SimpleDateFormat"%>

<%
	//此页面为由Android端填写学生信息，提交至服务器端的页面
	//fruit_type, fcountry_name,fruit_titles,fruit_content,fruit_price,fruit_picture;
	
	String flag = null;
	Fruit fruit = new Fruit();
	AddFruit addfruit = new AddFruit();
	File2StringUtil file2StringUtil = new File2StringUtil(); //创建图片操作类
    String fruit_picture = request.getParameter("fruit_picture").trim(); //图片
    log(fruit_picture);
	SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
	String time = df.format(new Date());// new Date()为获取当前系统时间
	file2StringUtil.byte2Image(fruit_picture, time);//存图片
	String time1 = "image/" + time + ".jpg";

	String date = new java.util.Date().toLocaleString();
	request.setCharacterEncoding("utf-8");
	String fromtype = request.getParameter("fromtype").trim();//标题
	String fruit_titles = request.getParameter("fruit_titles").trim();//标题
	String fruit_content = request.getParameter("fruit_content").trim(); //内容
	String fruit_price = request.getParameter("fruit_price").trim();//价格
	String fruit_sales = request.getParameter("fruit_sales").trim();//销量
	String fruit_type = request.getParameter("fruit_type").trim();//种类
	fruit.setFruit_time(date);
	fruit.setFruit_title(fruit_titles);
	fruit.setFruit_content(fruit_content);
	fruit.setFruit_sales(fruit_sales);
	fruit.setFruit_type(fruit_type);
	fruit.setFruit_price(fruit_price);
	fruit.setFruit_picture(fruit_picture);
	fruit_type = new String(fruit_type.getBytes("iso-8859-1"), "utf-8");
	log(fromtype);
	//水果
	if (fromtype.matches("fruit")) {
		flag = addfruit.Add_Fruit(fruit_type,fruit_sales,fruit_titles,fruit_content,time1, date,fruit_price);
	} else if (fromtype.matches("vegetable")) {
		Vegetable vegetable = new Vegetable();
		vegetable.setVegetable_title(fruit_titles);
		vegetable.setVegetable_content(fruit_content);
		vegetable.setVegetable_price(fruit_price);
		vegetable.setVegetable_sales(fruit_sales);
		vegetable.setVegetable_type(fruit_type);
		vegetable.setVegetable_picture(fruit_picture);
		AddVegetable addvegetable = new AddVegetable();
		flag = addvegetable.Add_Vegetable(fruit_type,fruit_sales,fruit_titles,fruit_content,time1, date,fruit_price);
	} else if (fromtype.matches("meat")) {
		Meat meat = new Meat();
		meat.setMeat_title(fruit_titles);
		meat.setMeat_content(fruit_content);
		meat.setMeat_price(fruit_price);
		meat.setMeat_sales(fruit_sales);
		meat.setMeat_type(fruit_type);
		meat.setMeat_picture(fruit_picture);
		AddMeat addmeat = new AddMeat();
		flag = addmeat.Add_Meat(fruit_type,fruit_sales,fruit_titles,fruit_content,time1,date,fruit_price);
	} else if (fromtype.matches("wine")) {
		Wine wine = new Wine();
		wine.setWine_title(fruit_titles);
		wine.setWine_content(fruit_content);
		wine.setWine_price(fruit_price);
		wine.setWine_sales(fruit_sales);
		wine.setWine_type(fruit_type);
		wine.setWine_picture(fruit_picture);
		AddWine addwine = new AddWine();
		flag = addwine.Add_Wine(fruit_type,fruit_sales,fruit_titles,fruit_content,time1, date,fruit_price);
	} else if (fromtype.matches("liangyou")) {
		Liangyou liangyou = new Liangyou();
		liangyou.setLiangyou_title(fruit_titles);
		liangyou.setLiangyou_content(fruit_content);
		liangyou.setLiangyou_price(fruit_price);
		liangyou.setLiangyou_sales(fruit_sales);
		liangyou.setLiangyou_type(fruit_type);
		liangyou.setLiangyou_picture(fruit_picture);
		AddLiangyou addliangyou = new AddLiangyou();
		flag = addliangyou.Add_Liangyou(fruit_type,fruit_sales,fruit_titles,fruit_content,time1, date,fruit_price);
	} else if (fromtype.matches("techan")) {
		Techan techan = new Techan();
		techan.setTechan_title(fruit_titles);
		techan.setTechan_content(fruit_content);
		techan.setTechan_price(fruit_price);
		techan.setTechan_sales(fruit_sales);
		techan.setTechan_type(fruit_type);
		techan.setTechan_picture(fruit_picture);
		AddTechan addtechan = new AddTechan();
		flag = addtechan.Add_Techan(fruit_type,fruit_sales,fruit_titles,fruit_content,time1, date,fruit_price);
	} else if (fromtype.matches("tour")) {//旅游
		Tour tour = new Tour();
		tour.setTour_title(fruit_titles);
		tour.setTour_content(fruit_content);
		tour.setTour_price(fruit_price);
		tour.setTour_sales(fruit_sales);
		tour.setTour_type(fruit_type);
		tour.setTour_picture(fruit_picture);
		AddTour addtour = new AddTour();
		flag = addtour.Add_Tour(fruit_type,fruit_sales,fruit_titles,fruit_content,time1, date,fruit_price);
	} else if (fromtype.matches("ganhuo")) {//旅游
		Ganhuo ganhuo = new Ganhuo();
		ganhuo.setGanhuo_title(fruit_titles);
		ganhuo.setGanhuo_content(fruit_content);
		ganhuo.setGanhuo_price(fruit_price);
		ganhuo.setGanhuo_sales(fruit_sales);
		ganhuo.setGanhuo_type(fruit_type);
		ganhuo.setGanhuo_picture(fruit_picture);
		AddGanhuo addganhuo = new AddGanhuo();
		flag = addganhuo.Add_Ganhuo(fruit_type,fruit_sales,fruit_titles,fruit_content,time1, date,fruit_price);
	} else {
		out.println("没有值");
	}

	if (flag.equals("sucess")) {
		out.println("发表成功!!");
	} else if (flag.equals("exist")) {
		out.println("已存在");
	} else {
		out.println("发表失败!!!");
	}
%>