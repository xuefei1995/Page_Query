package com.xuefei.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xuefei.entity.PageBean;
import com.xuefei.entity.StuQuery;
import com.xuefei.service.StuService;
import com.xuefei.serviceImpl.StuServiceImpl;
import com.xuefei.util.WebUtil;

public class ListStuServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		StuQuery query = WebUtil.copyRequestToBean(request, StuQuery.class);

		//获取当前页
		String currentpage=request.getParameter("currentPage");
		if(currentpage==null || currentpage.equals("")){
			currentpage="1";
		}
		//获取每页显示数据数
		String pageSize=request.getParameter("pageSize");
		if(pageSize==null || pageSize.equals("")){
			pageSize="5";
		}
		//获取pagebean
		StuService ss=new StuServiceImpl();
		PageBean pagebean = ss.getPageBean(Integer.parseInt(currentpage),Integer.parseInt(pageSize),query);
		
		//将pagebean放入域对象中
		request.setAttribute("pageBean", pagebean);
		request.getRequestDispatcher("/ListStu.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
