package com.wechatservice.service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;





import com.wechat.AdminInfo;
import com.wechat.CommonConstant;

/** 
 * ��ʼ��servlet 
 *  
 * @author liuyq 
 * @date 2013-05-02 
 */  
public class InitServlet extends HttpServlet {  
    private static final long serialVersionUID = 1L;  
  //  private static Logger log = Logger.getLogger(InitServlet.class);  
  
    public void init() throws ServletException {  
        // ��ȡweb.xml�����õĲ���  
        TokenThread.appid = AdminInfo.APPID;  
        TokenThread.appsecret = AdminInfo.APPSECRET;  
        
        System.out.println("weixin api appid:{}"+ TokenThread.appid);  
        System.out.println("weixin api appsecret:{}"+TokenThread.appsecret);  
  
        // δ����appid��appsecretʱ������ʾ  
        if ("".equals(TokenThread.appid) || "".equals(TokenThread.appsecret)) {  
        	 System.out.println("appid and appsecret configuration error, please check carefully.");  
        } else {  
            // ������ʱ��ȡaccess_token���߳�  
            new Thread(new TokenThread()).start();  
        }  
    }  
} 
