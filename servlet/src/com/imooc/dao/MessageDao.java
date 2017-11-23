package com.imooc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.imooc.bean.Message;
/**
 * 和message表相关的数据操作
 *
 */
public class MessageDao {
	/**
	 * 根据条件查询列表
	 */
	public  List<Message> chaxun(String command,String description){
	    List<Message> messageList =new ArrayList<Message>();
	try {
		Class.forName("com.mysql.jdbc.Driver");
	    Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/aa?useUnicode=true&characterEncoding=UTF-8","root","123456");
        StringBuilder sql=new StringBuilder("select ID,COMMAND,DESCRIPTION,CONTENT from message where 1=1");
        List<String> paramList = new ArrayList<String>();
    if(command!=null&&!"".equals(command.trim())){
    	sql.append(" and COMMAND=?");
    	paramList.add(command);
    }
    if(description!=null&&!"".equals(description.trim())){
    	sql.append(" and DESCRIPTION like '%' ? '%'");
    	paramList.add(description);
    }
    PreparedStatement statement = conn.prepareStatement(sql.toString());
    for(int i=0;i<paramList.size();i++){
    	statement.setString(i+1,paramList.get(i));
    }
    ResultSet rs=statement.executeQuery();
    while(rs.next()){
    	Message message = new Message();
    	messageList.add(message);
    	message.setId(rs.getString("ID"));
    	message.setCommend(rs.getString("COMMAND"));
    	message.setDescription(rs.getString("DESCRIPTION"));
    	message.setContent(rs.getString("CONTENT"));	
    }
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return messageList;
}
}