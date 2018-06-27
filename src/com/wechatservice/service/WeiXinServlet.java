package com.wechatservice.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONObject;

import com.entity.AccessToken;
import com.entity.Button;
import com.entity.ClickButton;
import com.entity.Menu;
import com.entity.Mould;
import com.entity.User;
import com.entity.ViewButton;
import com.lbs.brick.AppContext;
import com.wechat.SignUtil;
import com.wechatservice.service.WechatService;

import common.Logger;




public class WeiXinServlet  extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(WeiXinServlet.class);
	
	protected WechatService Wechatservice=new WechatService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");

        //微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp，nonce参数
        String signature = request.getParameter("signature");
        //时间戳
        String timestamp = request.getParameter("timestamp");
        //随机数
        String nonce = request.getParameter("nonce");
        //随机字符串
        String echostr = request.getParameter("echostr");
        response.setCharacterEncoding("utf-8");

        PrintWriter out=response.getWriter();

        if (SignUtil.checkSignature(signature, timestamp, nonce)) {
            logger.info("[signature: "+signature + "]<-->[timestamp: "+ timestamp+"]<-->[nonce: "+nonce+"]<-->[echostr: "+echostr+"]");
            out.println(echostr);
        }
        out.close();
        out=null;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒  
        System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒 
    	req.setCharacterEncoding("utf-8");
    	resp.setCharacterEncoding("utf-8");
    	String xmlStr=Wechatservice.processRequest(req);
    	PrintWriter out=resp.getWriter();
    	out.print(xmlStr);
        out.close();
    }
    
}
