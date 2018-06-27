package com.wechatservice.message;

import java.util.TreeMap;

public class WechatTemplateMsg {
	private String touser;//������openid
	private String template_id;//ģ��ID
	private String url;//ģ����ת����
	private TreeMap<String,TreeMap<String,String>> data;
	public static TreeMap<String,String> item(String value,String color){
		TreeMap<String,String> params=new TreeMap<String,String>();
		params.put("value", value);
		params.put("color", color);
		return params;
	}

	public String getTouser() {
		return touser;
	}

	public void setTouser(String touser) {
		this.touser = touser;
	}

	public String getTemplate_id() {
		return template_id;
	}
	public void setTemplate_id(String templateId) {
		template_id = templateId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public TreeMap<String, TreeMap<String, String>> getData() {
		return data;
	}
	public void setData(TreeMap<String, TreeMap<String, String>> data) {
		this.data = data;
	}
	
}
