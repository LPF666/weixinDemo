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
    
     //���ɷ���΢�ŵı���
    /**
     * ���ɷ���΢�ŵı���
     * 
     */
    public String processRequest(HttpServletRequest request) {
        Map<String, String> map = WechatMessageUtil.xmlToMap(request);
        log.info(map);
        // ���ͷ��ʺţ�һ��OpenID��
        String fromUserName = map.get("FromUserName");
        // ������΢�ź�
        String toUserName = map.get("ToUserName");
        // ��Ϣ����
        String msgType = map.get("MsgType");
        // Ĭ�ϻظ�һ��"success"
        String responseMessage = "success";
        // ����Ϣ���д���
        if (WechatMessageUtil.MESSAGE_TEXT.equals(msgType)) {// �ı���Ϣ
        	if(map.get("Content").equals("2")){
        		String sb2=WechatMessageUtil.Text2();//��ȡ���ص���Ϣ
        		TextMessage textMessage = new TextMessage();
                textMessage.setMsgType(WechatMessageUtil.MESSAGE_TEXT);
                textMessage.setToUserName(fromUserName);
                textMessage.setFromUserName(toUserName);
                textMessage.setCreateTime(System.currentTimeMillis());
                textMessage.setContent(sb2);
                responseMessage = WechatMessageUtil.textMessageToXml(textMessage);	
        	}else if(map.get("Content").equals("1")){
        		String sb1=WechatMessageUtil.Text1();//��ȡ���ص���Ϣ
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
        		String sb3=WechatMessageUtil.TextOther();//��ȡ���ص���Ϣ
        		TextMessage textMessage = new TextMessage();
                textMessage.setMsgType(WechatMessageUtil.MESSAGE_TEXT);
                textMessage.setToUserName(fromUserName);
                textMessage.setFromUserName(toUserName);
                textMessage.setCreateTime(System.currentTimeMillis());
                textMessage.setContent(sb3);
                responseMessage = WechatMessageUtil.textMessageToXml(textMessage);
        	}
        	
        }else if(WechatMessageUtil.MESSAtGE_IMAGE.equals(msgType)){// ͼƬ��Ϣ
        	
        }else if(WechatMessageUtil.MESSAGE_NEWS.equals(msgType)){// ͼ����Ϣ
        	
        }else if (WechatMessageUtil.MESSAGE_EVENT.equals(msgType)) {//�Ƿ����¼�����
			String eventType=map.get("Event");
			if (WechatMessageUtil.MESSAGE_EVENT_SUBSCRIBE.equals(eventType)) {//�����¼�
				responseMessage = WechatMessageUtil.initText(toUserName, fromUserName, WechatMessageUtil.menuText());
			}else if (WechatMessageUtil.MESSAGE_EVENT_CLICK.equals(eventType)) {//�˵�����¼�
				
				String eventtype=map.get("EventKey");
				if(eventtype.equals("11")){
//				AccessToken token=CommonMethod.getAccessToken();//��ȡaccess_token
					System.out.println("dfgd"+TokenThread.accessToken.getToken());
				User user=CommonMethod.getUser(fromUserName, TokenThread.accessToken.getToken());//��ȡ�û���Ϣ
				
				responseMessage = WechatMessageUtil.TextUser(toUserName, fromUserName, user);
//				responseMessage = WechatMessageUtil.initText(toUserName, fromUserName, WechatMessageUtil.menuText());
				}else if(eventtype.equals("12")){
					CreateMould mould=new 	CreateMould();
		    		mould.sendTemplate(fromUserName);	//����ģ����Ϣ
				}
			}else if (WechatMessageUtil.MESSAGE_EVENT_VIEW.equals(eventType)) {//�˵���ת����
				String url=map.get("EventKey");
				responseMessage = WechatMessageUtil.initText(toUserName, fromUserName, url);
			}else if (WechatMessageUtil.MESSAGE_EVENT_SCANCODE.equals(eventType)) {//ɨ���¼�
//				String key=map.get("EventKey");
				AccessToken token=CommonMethod.getAccessToken();
				User user=CommonMethod.getUser(fromUserName, token.getToken());
				responseMessage = WechatMessageUtil.TextUser(toUserName, fromUserName, user);
			}
		}else if (WechatMessageUtil.MESSAGE_EVENT_LOCATION_UP.equals(msgType)) {//�ϱ�����λ���¼�
			String label=map.get("Label");
			responseMessage = WechatMessageUtil.initText(toUserName, fromUserName, label);
		}

        
        log.info(responseMessage);
        System.out.println(responseMessage);
        return responseMessage;

    }

}
