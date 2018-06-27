package com.wechatservice.service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;





import com.wechat.AdminInfo;
import com.wechat.CommonConstant;

/** 
 * 初始化servlet 
 *  
 * @author liuyq 
 * @date 2013-05-02 
 */  
public class InitServlet extends HttpServlet {  
    private static final long serialVersionUID = 1L;  
  //  private static Logger log = Logger.getLogger(InitServlet.class);  
  
    public void init() throws ServletException {  
        // 获取web.xml中配置的参数  
        TokenThread.appid = AdminInfo.APPID;  
        TokenThread.appsecret = AdminInfo.APPSECRET;  
        
        System.out.println("weixin api appid:{}"+ TokenThread.appid);  
        System.out.println("weixin api appsecret:{}"+TokenThread.appsecret);  
  
        // 未配置appid、appsecret时给出提示  
        if ("".equals(TokenThread.appid) || "".equals(TokenThread.appsecret)) {  
        	 System.out.println("appid and appsecret configuration error, please check carefully.");  
        } else {  
            // 启动定时获取access_token的线程  
            new Thread(new TokenThread()).start();  
        }  
    }  
} 
