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
 * �б�ҳ���ʼ������
 */
@SuppressWarnings("serial")
public class ListServlet extends HttpServlet {
      @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
    	  //�����ʽ
    	  req.setCharacterEncoding("UTF-8");
    	  //����ҳ�洫ֵ
		  String command=req.getParameter("command");
		  String description=req.getParameter("description");
		   //��ֵ��ҳ��
		  req.setAttribute("command", command);
		  req.setAttribute("description", description);
		  //����service
    	  ListService listService=new ListService();
    	  //��ԃ��Ϣ�б���ֵ��ǰ̨
		  req.setAttribute("messageList", listService.chaxun(command, description));
		  //ҳ����ת
    	  req.getRequestDispatcher("aa.jsp").forward(req,resp);
    }
      @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	this.doGet(req, resp);
    }
}
