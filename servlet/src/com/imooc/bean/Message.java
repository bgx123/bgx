package com.imooc.bean;
/**
 *与消息表对应的实体类
 */
public class Message {
   private String id; //id
   private String commend;  //指令名称
   private String description;  //描述
   private String content;  // 内容
   
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getCommend() {
	return commend;
}
public void setCommend(String commend) {
	this.commend = commend;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
}
