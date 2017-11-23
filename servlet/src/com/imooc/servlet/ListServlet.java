package com.imooc.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.bean.Message;
import com.imooc.service.ListService;

/**
 * 列表页面初始化控制
 */
@SuppressWarnings("serial")
public class ListServlet extends HttpServlet {
      @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
    	  //编码格式
    	  req.setCharacterEncoding("UTF-8");
    	  //接受页面传值
		  String command=req.getParameter("command");
		  String description=req.getParameter("description");
		   //传值给页面
		  req.setAttribute("command", command);
		  req.setAttribute("description", description);
		  //调用service
    	  ListService listService=new ListService();
    	  //查詢消息列表并传值给前台
		  req.setAttribute("messageList", listService.chaxun(command, description));
		  //页面跳转
    	  req.getRequestDispatcher("aa.jsp").forward(req,resp);
    }
      @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	this.doGet(req, resp);
    }
}
