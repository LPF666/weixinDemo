package com.wechatservice.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.entity.AccessToken;
import com.entity.User;
import com.wechat.CommonMethod;
import com.wechat.CreateMenu;
import com.wechat.CreateMould;
import com.wechatservice.message.TextMessage;
import com.wechatservice.message.TsMessage;


public class WechatService {
    private static Logger log = Logger.getLogger(WechatService.class);
    
     //生成发给微信的报文
    /**
     * 生成发给微信的报文
     * 
     */
    public String processRequest(HttpServletRequest request) {
        Map<String, String> map = WechatMessageUtil.xmlToMap(request);
        log.info(map);
        // 发送方帐号（一个OpenID）
        String fromUserName = map.get("FromUserName");
        // 开发者微信号
        String toUserName = map.get("ToUserName");
        // 消息类型
        String msgType = map.get("MsgType");
        // 默认回复一个"success"
        String responseMessage = "success";
        // 对消息进行处理
        if (WechatMessageUtil.MESSAGE_TEXT.equals(msgType)) {// 文本消息
        	if(map.get("Content").equals("2")){
        		String sb2=WechatMessageUtil.Text2();//获取返回的消息
        		TextMessage textMessage = new TextMessage();
                textMessage.setMsgType(WechatMessageUtil.MESSAGE_TEXT);
                textMessage.setToUserName(fromUserName);
                textMessage.setFromUserName(toUserName);
                textMessage.setCreateTime(System.currentTimeMillis());
                textMessage.setContent(sb2);
                responseMessage = WechatMessageUtil.textMessageToXml(textMessage);	
        	}else if(map.get("Content").equals("1")){
        		String sb1=WechatMessageUtil.Text1();//获取返回的消息
        		TextMessage textMessage = new TextMessage();
                textMessage.setMsgType(WechatMessageUtil.MESSAGE_TEXT);
                textMessage.setToUserName(fromUserName);
                textMessage.setFromUserName(toUserName);
                textMessage.setCreateTime(System.currentTimeMillis());
                textMessage.setContent(sb1);
                responseMessage = WechatMessageUtil.textMessageToXml(textMessage);	
        	}else if(map.get("Content").equals("3")){
        		
                responseMessage = WechatMessageUtil.initNewsMessage(toUserName, fromUserName);	
        	}else{
        		String sb3=WechatMessageUtil.TextOther();//获取返回的消息
        		TextMessage textMessage = new TextMessage();
                textMessage.setMsgType(WechatMessageUtil.MESSAGE_TEXT);
                textMessage.setToUserName(fromUserName);
                textMessage.setFromUserName(toUserName);
                textMessage.setCreateTime(System.currentTimeMillis());
                textMessage.setContent(sb3);
                responseMessage = WechatMessageUtil.textMessageToXml(textMessage);
        	}
        	
        }else if(WechatMessageUtil.MESSAtGE_IMAGE.equals(msgType)){// 图片消息
        	
        }else if(WechatMessageUtil.MESSAGE_NEWS.equals(msgType)){// 图文消息
        	
        }else if (WechatMessageUtil.MESSAGE_EVENT.equals(msgType)) {//是否是事件类型
			String eventType=map.get("Event");
			if (WechatMessageUtil.MESSAGE_EVENT_SUBSCRIBE.equals(eventType)) {//订阅事件
				responseMessage = WechatMessageUtil.initText(toUserName, fromUserName, WechatMessageUtil.menuText());
			}else if (WechatMessageUtil.MESSAGE_EVENT_CLICK.equals(eventType)) {//菜单点击事件
				
				String eventtype=map.get("EventKey");
				if(eventtype.equals("11")){
//				AccessToken token=CommonMethod.getAccessToken();//获取access_token
					System.out.println("dfgd"+TokenThread.accessToken.getToken());
				User user=CommonMethod.getUser(fromUserName, TokenThread.accessToken.getToken());//获取用户信息
				
				responseMessage = WechatMessageUtil.TextUser(toUserName, fromUserName, user);
//				responseMessage = WechatMessageUtil.initText(toUserName, fromUserName, WechatMessageUtil.menuText());
				}else if(eventtype.equals("12")){
					CreateMould mould=new 	CreateMould();
		    		mould.sendTemplate(fromUserName);	//发送模板消息
				}
			}else if (WechatMessageUtil.MESSAGE_EVENT_VIEW.equals(eventType)) {//菜单跳转链接
				String url=map.get("EventKey");
				responseMessage = WechatMessageUtil.initText(toUserName, fromUserName, url);
			}else if (WechatMessageUtil.MESSAGE_EVENT_SCANCODE.equals(eventType)) {//扫码事件
//				String key=map.get("EventKey");
				AccessToken token=CommonMethod.getAccessToken();
				User user=CommonMethod.getUser(fromUserName, token.getToken());
				responseMessage = WechatMessageUtil.TextUser(toUserName, fromUserName, user);
			}
		}else if (WechatMessageUtil.MESSAGE_EVENT_LOCATION_UP.equals(msgType)) {//上报地理位置事件
			String label=map.get("Label");
			responseMessage = WechatMessageUtil.initText(toUserName, fromUserName, label);
		}

        
        log.info(responseMessage);
        System.out.println(responseMessage);
        return responseMessage;

    }

}
