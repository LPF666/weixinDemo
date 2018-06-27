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
    // 各种消息类型,除了扫带二维码事件
    /**
     * 文本消息
     */
    public static final String MESSAGE_TEXT = "text";
    /**
     * 图片消息
     */
    public static final String MESSAtGE_IMAGE = "image";
    /**
     * 图文消息
     */
    public static final String MESSAGE_NEWS = "news";
    /**
     * 语音消息
     */
    public static final String MESSAGE_VOICE = "voice";
    /**
     * 视频消息
     */
    public static final String MESSAGE_VIDEO = "video";
    /**
     * 小视频消息
     */
    public static final String MESSAGE_SHORTVIDEO = "shortvideo";
    /**
     * 地理位置消息
     */
    public static final String MESSAGE_LOCATION = "location";
    /**
     * 链接消息
     */
    public static final String MESSAGE_LINK = "link";
    /**
     * 事件推送消息
     */
    public static final String MESSAGE_EVENT = "event";
    /**
     * 事件推送消息中,事件类型，subscribe(订阅)
     */
    public static final String MESSAGE_EVENT_SUBSCRIBE = "subscribe";
    /**
     * 事件推送消息中,事件类型，unsubscribe(取消订阅)
     */
    public static final String MESSAGE_EVENT_UNSUBSCRIBE = "unsubscribe";
    /**
     * 事件推送消息中,上报地理位置事件
     */
    public static final String MESSAGE_EVENT_LOCATION_UP = "location";
    /**
     * 事件推送消息中,自定义菜单事件,点击菜单拉取消息时的事件推送
     */
    public static final String MESSAGE_EVENT_CLICK = "CLICK";
    /**
     * 事件推送消息中,自定义菜单事件,点击菜单跳转链接时的事件推送
     */
    public static final String MESSAGE_EVENT_VIEW = "VIEW";
    /**
     * 事件推送消息中,自定义菜单事件,扫码事件推送
     */
    public static final String MESSAGE_EVENT_SCANCODE = "scancode_push";

    /**
     * 将xml转化为Map集合
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
     * 文本消息转化为xml
     * 
     * @param textMessage
     * @return
     */
    public static String textMessageToXml(TextMessage textMessage) {
        XStream xstream = new XStream();
        xstream.alias("xml", textMessage.getClass());
        return xstream.toXML(textMessage);

    }
    //订阅后展示的文本消息
    /**
     * 订阅后展示的文本消息
     * 
     */
    public static String menuText(){
        StringBuffer sb = new StringBuffer();
        sb.append("感谢您的关注，请按照菜单提升进行操作：\n\n");
        sb.append("1、易联众简介\n");
        sb.append("2、易联众发展历史\n");
        sb.append("3、易联众介绍\n");
        sb.append("回复？调出此菜单。");
        return sb.toString();
    }
   //初始化文本信息转成报文
    /**
     * 初始化文本信息转成报文
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
    //回复1返回的文本信息
    /**
     * 回复1返回的文本信息
     * 
     */
    public static String Text1(){
    	StringBuffer sb = new StringBuffer();
        sb.append("易联众，全称：易联众信息技术股份");
        sb.append("有限公司，该公司于2009年6月29");
        sb.append("日以有限责任公司整体变更方式设立");
        sb.append("为股份有限公司。易联众是中国国内");
        sb.append("主要的民生行业信息化服务提供商。");
        sb.append("公司面向政府、衍生机构及社会公众");
        sb.append("，主要提供以劳动和社保为核心的民");
        sb.append("生行业信息化服务，具备完整的产品");
        sb.append("链，覆盖服务对象全面。");
        return sb.toString();
    }
  //回复2返回的文本信息
    /**
     * 回复2返回的文本信息
     * 
     */
    public static String Text2(){
    	StringBuffer sb = new StringBuffer();
        sb.append("易联众信息技术股份有限公司于2009年6月29日\n");
        sb.append("以有限责任公司整体变更方式设立为股份有限公司。\n");
        sb.append("公司自成立以来，依托信息技术和知识管理能力，\n");
        sb.append("立足于惠及人民群众生老病死、关系社会和谐发展的民生行业，\n");
        sb.append("在核心技术领域和商业模式上保持持续的自主创新，\n");
        sb.append("以将公司发展成为中国最专业的民生行业应用解决方案提供商和\n");
        sb.append("领先的民生信息服务提供商”为战略目标。");
        return sb.toString();
    }
    //回复其它值返回的文本信息
    /**
     * 回复其它值返回的文本信息
     * 
     */
    public static String TextOther(){
    	StringBuffer sb = new StringBuffer();
        sb.append("只能输入1和2。");
        return sb.toString();
    }
    //返回用户信息的报文
    /**
     * 返回用户信息的报文
     * 
     */
    public static String TextUser(String toUserName,String fromUserName,User user){
    	 
    	StringBuffer sb = new StringBuffer();
        sb.append("昵称："+user.getNickname()+"\n");
        sb.append("性别："+user.getSex()+"\n");
        sb.append("所在城市："+user.getCity()+"\n");
        sb.append("所在国家："+user.getCountry()+"\n");
        sb.append("所在省份："+user.getProvince()+"\n");
        TextMessage text = new TextMessage();
        text.setFromUserName(toUserName);
        text.setToUserName(fromUserName);
        text.setMsgType(WechatMessageUtil.MESSAGE_TEXT);
        text.setCreateTime(new Date().getTime());
        text.setContent(sb.toString());
        return textMessageToXml(text);
    }
    
    /**
     * 图本消息转化为xml
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
    //回复3展示的图文消息转换成的报文信息
    /**
     * 回复3展示的图文消息转换成的报文信息
     * 
     */
    public static String initNewsMessage(String toUserName,String fromUserName){
    	List<Article> list=new ArrayList<Article>();
    	NewsMessage news = new NewsMessage();
    	Article article=new Article();
    	
    	article.setTitle("中国");
    	article.setDescription("中华人民共和国位于亚洲东部，太平洋西岸  ，是工人阶级领导的、以工农联盟为基础的人民民主专政的社会主义国家  。1949年（己丑年）10月1日成立   ，以五星红旗为国旗  ，《义勇军进行曲》为国歌   ，国徽内容包括国旗、天安门、齿轮和麦稻穗  ，首都北京 ，省级行政区划为23个省、5个自治区、4个直辖市、2个特别行政区  ，是一个以汉族为主体民族，由56个民族构成的统一多民族国家，汉族占总人口的91.51%   。");
    	article.setPicUrl("http://mmbiz.qpic.cn/mmbiz_jpg/E7Pia6sicWbLuh60Mgwnx5NWMGbu96kc9G7wUeAnibibyslrYmaC6ibutXotIianaQbXt0Yw5WGl16J7dk9EjlkY1TGg/0?wx_fmt=jpeg");
    	article.setUrl("http://mp.weixin.qq.com/s?__biz=MzU4NDU4Mjk2MA==&mid=100000008&idx=1&sn=dec354e2d7ec5c20daec71d1f71d50c6&chksm=7d96d3574ae15a413a4b6e4c7255f287354a542af64ba264191c00e2274ce00c08a4726668f1#rd");
    	list.add(article);
        Article article2=new Article();
    	
    	article2.setTitle("山西");
    	article2.setDescription("山西，中华人民共和国省级行政区，省会太原市，因居太行山之西而得名，简称“晋”，东依太行山，西、南依吕梁山、黄河，北依长城，与河北、河南、陕西、内蒙古等省区为界。介于北纬34°34′—40°44′，东经110°14′—114°33′之间，总面积15.67万平方千米，山区面积约占总面积的80%以上。山西又称“三晋”，古称河东，是中华民族发祥地之一，有文字记载的历史达三千年，被誉为“华夏文明摇篮”，素有“中国古代文化博物馆”之称。柳宗元称之为“表里山河”。");
    	article2.setPicUrl("http://mmbiz.qpic.cn/mmbiz_jpg/E7Pia6sicWbLuh60Mgwnx5NWMGbu96kc9GTNEJ9SU5KugP3Dbuo21aVydy26KjZ8XYO2l2OIhQW8b6TkItz951nA/0?wx_fmt=jpeg");
    	article2.setUrl("http://mp.weixin.qq.com/s?__biz=MzU4NDU4Mjk2MA==&mid=100000008&idx=2&sn=a05bd97fab5086bb2c97b96bfcea50ed&chksm=7d96d3574ae15a41e9a1b8876588a8e3c337786167f3e33ee395d95bd2e4372affb9f426732a#rd");
    	list.add(article2);
        Article article3=new Article();
    	
    	article3.setTitle("太原");
    	article3.setDescription("太原，山西省省会，简称“并（bīng）”，别称并州，古称晋阳，也称龙城，是中国优秀旅游城市、国家历史文化名城、国家园林城市、中部地区重要的中心城市、太原都市圈核心城市，山西省政治、经济、文化、交通和国际交流中心，是一座具有4700多年历史，2500年建城史，“控带山河，踞天下之肩背”，“襟四塞之要冲，控五原之都邑”的历史古都。太原市三面环山，黄河第二大支流汾河自北向南流经，自古就有“锦绣太原城”的美誉，是中国北方军事、文化重镇，世界晋商都会，中国能源、重工业基地之一。太原的城市精神是包容、尚德、崇法、诚信、卓越。");
    	article3.setPicUrl("http://mmbiz.qpic.cn/mmbiz_jpg/E7Pia6sicWbLuh60Mgwnx5NWMGbu96kc9GsqoSl6c7kqfa7L9czCRC1wQN1mzbUWuuXq9tlbK0pySsiaSBJdTrXIA/0?wx_fmt=jpeg");
    	article3.setUrl("http://mp.weixin.qq.com/s?__biz=MzU4NDU4Mjk2MA==&mid=100000008&idx=3&sn=7c7f5a4139a14710ee6abc7d29daf61b&chksm=7d96d3574ae15a413f628cf4046b552f5695ca26263b4c2a7c399b74792d453dc95ad3fa070f#rd");
    	list.add(article3);
        Article article4=new Article();
    	
    	article4.setTitle("长治");
    	article4.setDescription("长治，古称上党、潞州、潞安府等。“长治”原为潞安府府治所在县名，得名于明嘉靖八年（1529年），取长治久安之意。长治地处晋东南，晋冀豫三省交界，全境位于由太行山太岳山环绕而成的上党盆地中。长治历史悠久，周显王二十一年（前348年）韩国在此首置上党郡，秦王政二十六年（前221年）秦一统六国分天下为三十六郡，上党郡为其一，市区内留存有古上党郡署大门上党门和国内现存规模最大、中轴线长408米的城隍庙潞安府城隍庙。长治是全国文明城市   、中国优秀旅游城市   、国家森林城市  、国家园林城市   、国家卫生城市  、中国十大魅力城市、中国曲艺名城  、国家公共文化服务体系示范区  。");
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
    	
    	article.setTitle("易联众介绍");
    	article.setDescription("易联众信息技术股份有限公司于2009年6月29日\n以有限责任公司整体变更方式设立为股份有限公司。\n公司自成立以来，依托信息技术和知识管理能力，\n立足于惠及人民群众生老病死、关系社会和谐发展的民生行业，\n");
    	article.setPicUrl(CommonConstant.NETWORK_URL+"/images/ylz.png");
    	article.setUrl("DwFbB-Bhupu0Au_XPs3Mywgk8ulZSVZswPGBhzESE5E");
    	//article.setUrl("http://sx.msyos.com/pc/htm/index.htm");
    	list.add(article);
        Article article2=new Article();
    	
    	article2.setTitle("易联众发展历史");
    	article2.setDescription("易联众，全称：易联众信息技术股份有限公司，该公司于2009年6月29日以有限责任公司整体变更方式设立为股份有限公司。易联众是中国国内为股份有限公司。易联众是中国国内主要的民生行业信息化服务提供商。");
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
     * 文本消息转化为xml
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


