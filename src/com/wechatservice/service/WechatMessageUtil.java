package com.wechatservice.service;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.entity.Article;
import com.entity.User;
import com.thoughtworks.xstream.XStream;
import com.wechat.CommonConstant;
import com.wechatservice.message.NewsMessage;
import com.wechatservice.message.TextMessage;
import com.wechatservice.message.TsMessage;

public class WechatMessageUtil {
    // ������Ϣ����,����ɨ����ά���¼�
    /**
     * �ı���Ϣ
     */
    public static final String MESSAGE_TEXT = "text";
    /**
     * ͼƬ��Ϣ
     */
    public static final String MESSAtGE_IMAGE = "image";
    /**
     * ͼ����Ϣ
     */
    public static final String MESSAGE_NEWS = "news";
    /**
     * ������Ϣ
     */
    public static final String MESSAGE_VOICE = "voice";
    /**
     * ��Ƶ��Ϣ
     */
    public static final String MESSAGE_VIDEO = "video";
    /**
     * С��Ƶ��Ϣ
     */
    public static final String MESSAGE_SHORTVIDEO = "shortvideo";
    /**
     * ����λ����Ϣ
     */
    public static final String MESSAGE_LOCATION = "location";
    /**
     * ������Ϣ
     */
    public static final String MESSAGE_LINK = "link";
    /**
     * �¼�������Ϣ
     */
    public static final String MESSAGE_EVENT = "event";
    /**
     * �¼�������Ϣ��,�¼����ͣ�subscribe(����)
     */
    public static final String MESSAGE_EVENT_SUBSCRIBE = "subscribe";
    /**
     * �¼�������Ϣ��,�¼����ͣ�unsubscribe(ȡ������)
     */
    public static final String MESSAGE_EVENT_UNSUBSCRIBE = "unsubscribe";
    /**
     * �¼�������Ϣ��,�ϱ�����λ���¼�
     */
    public static final String MESSAGE_EVENT_LOCATION_UP = "location";
    /**
     * �¼�������Ϣ��,�Զ���˵��¼�,����˵���ȡ��Ϣʱ���¼�����
     */
    public static final String MESSAGE_EVENT_CLICK = "CLICK";
    /**
     * �¼�������Ϣ��,�Զ���˵��¼�,����˵���ת����ʱ���¼�����
     */
    public static final String MESSAGE_EVENT_VIEW = "VIEW";
    /**
     * �¼�������Ϣ��,�Զ���˵��¼�,ɨ���¼�����
     */
    public static final String MESSAGE_EVENT_SCANCODE = "scancode_push";

    /**
     * ��xmlת��ΪMap����
     * 
     * @param request
     * @return
     */
    public static Map<String, String> xmlToMap(HttpServletRequest request) {
        Map<String, String> map = new HashMap<String, String>();
        SAXReader reader = new SAXReader();
        InputStream ins = null;
        try {
            ins = request.getInputStream();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        Document doc = null;
        try {
            doc = reader.read(ins);
        } catch (DocumentException e1) {
            e1.printStackTrace();
        }
        Element root = doc.getRootElement();
        @SuppressWarnings("unchecked")
        List<Element> list = root.elements();
        for (Element e : list) {
            map.put(e.getName(), e.getText());
        }
        try {
            ins.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return map;
    }

    /**
     * �ı���Ϣת��Ϊxml
     * 
     * @param textMessage
     * @return
     */
    public static String textMessageToXml(TextMessage textMessage) {
        XStream xstream = new XStream();
        xstream.alias("xml", textMessage.getClass());
        return xstream.toXML(textMessage);

    }
    //���ĺ�չʾ���ı���Ϣ
    /**
     * ���ĺ�չʾ���ı���Ϣ
     * 
     */
    public static String menuText(){
        StringBuffer sb = new StringBuffer();
        sb.append("��л���Ĺ�ע���밴�ղ˵��������в�����\n\n");
        sb.append("1�������ڼ��\n");
        sb.append("2�������ڷ�չ��ʷ\n");
        sb.append("3�������ڽ���\n");
        sb.append("�ظ��������˲˵���");
        return sb.toString();
    }
   //��ʼ���ı���Ϣת�ɱ���
    /**
     * ��ʼ���ı���Ϣת�ɱ���
     * 
     */
    public static String initText(String toUserName,String fromUserName,String content){
        TextMessage text = new TextMessage();
        text.setFromUserName(toUserName);
        text.setToUserName(fromUserName);
        text.setMsgType(WechatMessageUtil.MESSAGE_TEXT);
        text.setCreateTime(new Date().getTime());
        text.setContent(content);
        return textMessageToXml(text);
    }
    //�ظ�1���ص��ı���Ϣ
    /**
     * �ظ�1���ص��ı���Ϣ
     * 
     */
    public static String Text1(){
    	StringBuffer sb = new StringBuffer();
        sb.append("�����ڣ�ȫ�ƣ���������Ϣ�����ɷ�");
        sb.append("���޹�˾���ù�˾��2009��6��29");
        sb.append("�����������ι�˾��������ʽ����");
        sb.append("Ϊ�ɷ����޹�˾�����������й�����");
        sb.append("��Ҫ��������ҵ��Ϣ�������ṩ�̡�");
        sb.append("��˾����������������������ṫ��");
        sb.append("����Ҫ�ṩ���Ͷ����籣Ϊ���ĵ���");
        sb.append("����ҵ��Ϣ�����񣬾߱������Ĳ�Ʒ");
        sb.append("�������Ƿ������ȫ�档");
        return sb.toString();
    }
  //�ظ�2���ص��ı���Ϣ
    /**
     * �ظ�2���ص��ı���Ϣ
     * 
     */
    public static String Text2(){
    	StringBuffer sb = new StringBuffer();
        sb.append("��������Ϣ�����ɷ����޹�˾��2009��6��29��\n");
        sb.append("���������ι�˾��������ʽ����Ϊ�ɷ����޹�˾��\n");
        sb.append("��˾�Գ���������������Ϣ������֪ʶ����������\n");
        sb.append("�����ڻݼ�����Ⱥ�����ϲ�������ϵ����г��չ��������ҵ��\n");
        sb.append("�ں��ļ����������ҵģʽ�ϱ��ֳ������������£�\n");
        sb.append("�Խ���˾��չ��Ϊ�й���רҵ��������ҵӦ�ý�������ṩ�̺�\n");
        sb.append("���ȵ�������Ϣ�����ṩ�̡�Ϊս��Ŀ�ꡣ");
        return sb.toString();
    }
    //�ظ�����ֵ���ص��ı���Ϣ
    /**
     * �ظ�����ֵ���ص��ı���Ϣ
     * 
     */
    public static String TextOther(){
    	StringBuffer sb = new StringBuffer();
        sb.append("ֻ������1��2��");
        return sb.toString();
    }
    //�����û���Ϣ�ı���
    /**
     * �����û���Ϣ�ı���
     * 
     */
    public static String TextUser(String toUserName,String fromUserName,User user){
    	 
    	StringBuffer sb = new StringBuffer();
        sb.append("�ǳƣ�"+user.getNickname()+"\n");
        sb.append("�Ա�"+user.getSex()+"\n");
        sb.append("���ڳ��У�"+user.getCity()+"\n");
        sb.append("���ڹ��ң�"+user.getCountry()+"\n");
        sb.append("����ʡ�ݣ�"+user.getProvince()+"\n");
        TextMessage text = new TextMessage();
        text.setFromUserName(toUserName);
        text.setToUserName(fromUserName);
        text.setMsgType(WechatMessageUtil.MESSAGE_TEXT);
        text.setCreateTime(new Date().getTime());
        text.setContent(sb.toString());
        return textMessageToXml(text);
    }
    
    /**
     * ͼ����Ϣת��Ϊxml
     * 
     * @param newsMessage
     * @return
     */
    public static String newsMessageToXml(NewsMessage newsMessage) {
        XStream xstream = new XStream();
        xstream.alias("xml", newsMessage.getClass());
        xstream.alias("item", new Article().getClass());
        return xstream.toXML(newsMessage);

    }
    //�ظ�3չʾ��ͼ����Ϣת���ɵı�����Ϣ
    /**
     * �ظ�3չʾ��ͼ����Ϣת���ɵı�����Ϣ
     * 
     */
    public static String initNewsMessage(String toUserName,String fromUserName){
    	List<Article> list=new ArrayList<Article>();
    	NewsMessage news = new NewsMessage();
    	Article article=new Article();
    	
    	article.setTitle("�й�");
    	article.setDescription("�л����񹲺͹�λ�����޶�����̫ƽ������  ���ǹ��˽׼��쵼�ġ��Թ�ũ����Ϊ��������������ר��������������  ��1949�꣨�����꣩10��1�ճ���   �������Ǻ���Ϊ����  �������¾���������Ϊ����   ���������ݰ������졢�찲�š����ֺ�����  ���׶����� ��ʡ����������Ϊ23��ʡ��5����������4��ֱϽ�С�2���ر�������  ����һ���Ժ���Ϊ�������壬��56�����幹�ɵ�ͳһ��������ң�����ռ���˿ڵ�91.51%   ��");
    	article.setPicUrl("http://mmbiz.qpic.cn/mmbiz_jpg/E7Pia6sicWbLuh60Mgwnx5NWMGbu96kc9G7wUeAnibibyslrYmaC6ibutXotIianaQbXt0Yw5WGl16J7dk9EjlkY1TGg/0?wx_fmt=jpeg");
    	article.setUrl("http://mp.weixin.qq.com/s?__biz=MzU4NDU4Mjk2MA==&mid=100000008&idx=1&sn=dec354e2d7ec5c20daec71d1f71d50c6&chksm=7d96d3574ae15a413a4b6e4c7255f287354a542af64ba264191c00e2274ce00c08a4726668f1#rd");
    	list.add(article);
        Article article2=new Article();
    	
    	article2.setTitle("ɽ��");
    	article2.setDescription("ɽ�����л����񹲺͹�ʡ����������ʡ��̫ԭ�У����̫��ɽ֮������������ơ�����������̫��ɽ��������������ɽ���ƺӣ��������ǣ���ӱ������ϡ����������ɹŵ�ʡ��Ϊ�硣���ڱ�γ34��34�䡪40��44�䣬����110��14�䡪114��33��֮�䣬�����15.67��ƽ��ǧ�ף�ɽ�����Լռ�������80%���ϡ�ɽ���ֳơ����������ųƺӶ������л����巢���֮һ�������ּ��ص���ʷ����ǧ�꣬����Ϊ����������ҡ���������С��й��Ŵ��Ļ�����ݡ�֮�ơ�����Ԫ��֮Ϊ������ɽ�ӡ���");
    	article2.setPicUrl("http://mmbiz.qpic.cn/mmbiz_jpg/E7Pia6sicWbLuh60Mgwnx5NWMGbu96kc9GTNEJ9SU5KugP3Dbuo21aVydy26KjZ8XYO2l2OIhQW8b6TkItz951nA/0?wx_fmt=jpeg");
    	article2.setUrl("http://mp.weixin.qq.com/s?__biz=MzU4NDU4Mjk2MA==&mid=100000008&idx=2&sn=a05bd97fab5086bb2c97b96bfcea50ed&chksm=7d96d3574ae15a41e9a1b8876588a8e3c337786167f3e33ee395d95bd2e4372affb9f426732a#rd");
    	list.add(article2);
        Article article3=new Article();
    	
    	article3.setTitle("̫ԭ");
    	article3.setDescription("̫ԭ��ɽ��ʡʡ�ᣬ��ơ�����b��ng��������Ʋ��ݣ��ųƽ�����Ҳ�����ǣ����й��������γ��С�������ʷ�Ļ����ǡ�����԰�ֳ��С��в�������Ҫ�����ĳ��С�̫ԭ����Ȧ���ĳ��У�ɽ��ʡ���Ρ����á��Ļ�����ͨ�͹��ʽ������ģ���һ������4700������ʷ��2500�꽨��ʷ�����ش�ɽ�ӣ�������֮�米������������֮Ҫ�壬����ԭ֮���ء�����ʷ�Ŷ���̫ԭ�����滷ɽ���ƺӵڶ���֧���ں��Ա������������Թž��С�����̫ԭ�ǡ������������й��������¡��Ļ�����������̶��ᣬ�й���Դ���ع�ҵ����֮һ��̫ԭ�ĳ��о����ǰ��ݡ��е¡��編�����š�׿Խ��");
    	article3.setPicUrl("http://mmbiz.qpic.cn/mmbiz_jpg/E7Pia6sicWbLuh60Mgwnx5NWMGbu96kc9GsqoSl6c7kqfa7L9czCRC1wQN1mzbUWuuXq9tlbK0pySsiaSBJdTrXIA/0?wx_fmt=jpeg");
    	article3.setUrl("http://mp.weixin.qq.com/s?__biz=MzU4NDU4Mjk2MA==&mid=100000008&idx=3&sn=7c7f5a4139a14710ee6abc7d29daf61b&chksm=7d96d3574ae15a413f628cf4046b552f5695ca26263b4c2a7c399b74792d453dc95ad3fa070f#rd");
    	list.add(article3);
        Article article4=new Article();
    	
    	article4.setTitle("����");
    	article4.setDescription("���Σ��ų��ϵ���º�ݡ�º�����ȡ������Ρ�ԭΪº���������������������������ξ����꣨1529�꣩��ȡ���ξð�֮�⡣���εش������ϣ�����ԥ��ʡ���磬ȫ��λ����̫��ɽ̫��ɽ���ƶ��ɵ��ϵ�����С�������ʷ�ƾã���������ʮһ�꣨ǰ348�꣩�����ڴ������ϵ�������������ʮ���꣨ǰ221�꣩��һͳ����������Ϊ��ʮ�������ϵ���Ϊ��һ�������������й��ϵ���������ϵ��ź͹����ִ��ģ��������߳�408�׵ĳ�����º����������������ȫ����������   ���й��������γ���   ������ɭ�ֳ���  ������԰�ֳ���   ��������������  ���й�ʮ���������С��й���������  �����ҹ����Ļ�������ϵʾ����  ��");
    	article4.setPicUrl("http://mmbiz.qpic.cn/mmbiz_jpg/E7Pia6sicWbLuh60Mgwnx5NWMGbu96kc9G0ib2ia7IX7Q8UdToUISTicmDIUBm20wzgEqUMU4iaTjj5Pj3R6owiaAaLjA/0?wx_fmt=jpeg");
    	article4.setUrl("http://mp.weixin.qq.com/s?__biz=MzU4NDU4Mjk2MA==&mid=100000008&idx=4&sn=759a103f570d753dc70cdc5219ad09db&chksm=7d96d3574ae15a417e0478829d14c02c8fbef6db83161c11ed1ff26badf3f5a2be85c0418f09#rd");
    	list.add(article4);
    	news.setFromUserName(toUserName);
    	news.setToUserName(fromUserName);
    	news.setMsgType(WechatMessageUtil.MESSAGE_NEWS);
    	news.setCreateTime(new Date().getTime());
    	news.setArticleCount(list.size());
    	news.setArticles(list);
    	return newsMessageToXml(news);
    }
    public static String initMod(String toUserName,String fromUserName){
    	List<Article> list=new ArrayList<Article>();
    	NewsMessage news = new NewsMessage();
    	Article article=new Article();
    	
    	article.setTitle("�����ڽ���");
    	article.setDescription("��������Ϣ�����ɷ����޹�˾��2009��6��29��\n���������ι�˾��������ʽ����Ϊ�ɷ����޹�˾��\n��˾�Գ���������������Ϣ������֪ʶ����������\n�����ڻݼ�����Ⱥ�����ϲ�������ϵ����г��չ��������ҵ��\n");
    	article.setPicUrl(CommonConstant.NETWORK_URL+"/images/ylz.png");
    	article.setUrl("DwFbB-Bhupu0Au_XPs3Mywgk8ulZSVZswPGBhzESE5E");
    	//article.setUrl("http://sx.msyos.com/pc/htm/index.htm");
    	list.add(article);
        Article article2=new Article();
    	
    	article2.setTitle("�����ڷ�չ��ʷ");
    	article2.setDescription("�����ڣ�ȫ�ƣ���������Ϣ�����ɷ����޹�˾���ù�˾��2009��6��29�����������ι�˾��������ʽ����Ϊ�ɷ����޹�˾�����������й�����Ϊ�ɷ����޹�˾�����������й�������Ҫ��������ҵ��Ϣ�������ṩ�̡�");
    	article2.setPicUrl(CommonConstant.NETWORK_URL+"/images/sbk.png");
    	article2.setUrl("http://www.sxylzinfo.com/");
    	list.add(article2);
    	news.setFromUserName(toUserName);
    	news.setToUserName(fromUserName);
    	news.setMsgType(WechatMessageUtil.MESSAGE_NEWS);
    	news.setCreateTime(new Date().getTime());
    	news.setArticleCount(list.size());
    	news.setArticles(list);
    	return newsMessageToXml(news);
    }
    
    /**
     * �ı���Ϣת��Ϊxml
     * 
     * @param textMessage
     * @return
     */
    public static String TsMessageToXml(TsMessage tsMessage) {
        XStream xstream = new XStream();
        xstream.alias("xml", tsMessage.getClass());
        return xstream.toXML(tsMessage);

    }
}


