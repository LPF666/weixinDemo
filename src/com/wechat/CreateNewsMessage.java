package com.wechat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.entity.AccessToken;
import com.entity.Article;
import com.entity.DownSc;
import com.entity.GetSc;
import com.entity.News_item;
import com.entity.Sc;
import com.entity.Tw;
import com.entity.Uint32;
import com.sun.org.apache.regexp.internal.recompile;
import com.wechatservice.message.NewsMessage;
import com.wechatservice.service.TokenThread;
import com.wechatservice.service.WechatMessageUtil;

public class CreateNewsMessage {


	
	 /**
     * �ظ�3չʾ��ͼ����Ϣת���ɵı�����Ϣ
     * 
     */
    public static Sc initNewsMessage(){
    	Uint32 b = new Uint32(0);
        Uint32 c = new Uint32(1);
    	Sc sc=new Sc();
    	Tw tw=new Tw();
    	tw.setTitle("�й�");
    	tw.setThumb_media_id("wa0KMjHBE3YcxdpCC7gKdfC2Zs46gQpxy8OhjIEUhoM");
    	tw.setAuthor("�ϸ���");
    	tw.setDigest("�л����񹲺͹�λ�����޶�����̫ƽ���������ǹ��˽׼��쵼�ġ��Թ�ũ����Ϊ��������������ר��������������");
    	tw.setShow_cover_pic("1");
    	tw.setContent("�л����񹲺͹�λ�����޶�����̫ƽ������  ���ǹ��˽׼��쵼�ġ��Թ�ũ����Ϊ��������������ר��������������  ��1949�꣨�����꣩10��1�ճ���   �������Ǻ���Ϊ����  �������¾���������Ϊ����   ���������ݰ������졢�찲�š����ֺ�����  ���׶����� ��ʡ����������Ϊ23��ʡ��5����������4��ֱϽ�С�2���ر�������  ����һ���Ժ���Ϊ�������壬��56�����幹�ɵ�ͳһ��������ң�����ռ���˿ڵ�91.51%   ��");
    	tw.setContent_source_url("https://mp.weixin.qq.com/s/daVWj8yREyDqUZO4bC2lpw");
    	tw.setNeed_open_comment(new Uint32(1));
    	tw.setOnly_fans_can_comment(new Uint32(0));
    	Tw tw1=new Tw();
    	tw1.setTitle("ɽ��");
    	tw1.setThumb_media_id("wa0KMjHBE3YcxdpCC7gKdXSpNa1QYNDV8YES_byMW5s");
    	tw1.setAuthor("�ϸ���");
    	tw1.setDigest("ɽ�����л����񹲺͹�ʡ����������ʡ��̫ԭ�У����̫��ɽ֮������������ơ�����");
    	tw1.setShow_cover_pic("1");
    	tw1.setContent("ɽ�����л����񹲺͹�ʡ����������ʡ��̫ԭ�У����̫��ɽ֮������������ơ�����������̫��ɽ��������������ɽ���ƺӣ��������ǣ���ӱ������ϡ����������ɹŵ�ʡ��Ϊ�硣���ڱ�γ34��34�䡪40��44�䣬����110��14�䡪114��33��֮�䣬�����15.67��ƽ��ǧ�ף�ɽ�����Լռ�������80%���ϡ�ɽ���ֳơ����������ųƺӶ������л����巢���֮һ�������ּ��ص���ʷ����ǧ�꣬����Ϊ����������ҡ���������С��й��Ŵ��Ļ�����ݡ�֮�ơ�����Ԫ��֮Ϊ������ɽ�ӡ���");
    	tw1.setContent_source_url("https://mp.weixin.qq.com/s/daVWj8yREyDqUZO4bC2lpw");
    	tw1.setNeed_open_comment(new Uint32(1));
    	tw1.setOnly_fans_can_comment(new Uint32(0));
    	Tw tw2=new Tw();
    	tw2.setTitle("̫ԭ");
    	tw2.setThumb_media_id("wa0KMjHBE3YcxdpCC7gKdcaZwTKaIR3-ShydJmaTVFY");
    	tw2.setAuthor("�ϸ���");
    	tw2.setDigest("̫ԭ��ɽ��ʡʡ�ᣬ��ơ�����b��ng��������Ʋ��ݣ��ųƽ�����Ҳ������");
    	tw2.setShow_cover_pic("1");
    	tw2.setContent("̫ԭ��ɽ��ʡʡ�ᣬ��ơ�����b��ng��������Ʋ��ݣ��ųƽ�����Ҳ�����ǣ����й��������γ��С�������ʷ�Ļ����ǡ�����԰�ֳ��С��в�������Ҫ�����ĳ��С�̫ԭ����Ȧ���ĳ��У�ɽ��ʡ���Ρ����á��Ļ�����ͨ�͹��ʽ������ģ���һ������4700������ʷ��2500�꽨��ʷ�����ش�ɽ�ӣ�������֮�米������������֮Ҫ�壬����ԭ֮���ء�����ʷ�Ŷ���̫ԭ�����滷ɽ���ƺӵڶ���֧���ں��Ա������������Թž��С�����̫ԭ�ǡ������������й��������¡��Ļ�����������̶��ᣬ�й���Դ���ع�ҵ����֮һ��̫ԭ�ĳ��о����ǰ��ݡ��е¡��編�����š�׿Խ��");
    	tw2.setContent_source_url("https://mp.weixin.qq.com/s/daVWj8yREyDqUZO4bC2lpw");
    	tw2.setNeed_open_comment(new Uint32(1));
    	tw2.setOnly_fans_can_comment(new Uint32(0));
    	Tw tw3=new Tw();
    	tw3.setTitle("����");
    	tw3.setThumb_media_id("wa0KMjHBE3YcxdpCC7gKdTBUYg9R3tdI7yYgirluOYg");
    	tw3.setAuthor("�ϸ���");
    	tw3.setDigest("���Σ��ų��ϵ���º�ݡ�º�����ȡ������Ρ�ԭΪº���������������������������ξ����꣨1529�꣩��ȡ���ξð�֮�⡣");
    	tw3.setShow_cover_pic("1");
    	tw3.setContent("���Σ��ų��ϵ���º�ݡ�º�����ȡ������Ρ�ԭΪº���������������������������ξ����꣨1529�꣩��ȡ���ξð�֮�⡣���εش������ϣ�����ԥ��ʡ���磬ȫ��λ����̫��ɽ̫��ɽ���ƶ��ɵ��ϵ�����С�������ʷ�ƾã���������ʮһ�꣨ǰ348�꣩�����ڴ������ϵ�������������ʮ���꣨ǰ221�꣩��һͳ����������Ϊ��ʮ�������ϵ���Ϊ��һ�������������й��ϵ���������ϵ��ź͹����ִ��ģ��������߳�408�׵ĳ�����º����������������ȫ����������   ���й��������γ���   ������ɭ�ֳ���  ������԰�ֳ���   ��������������  ���й�ʮ���������С��й���������  �����ҹ����Ļ�������ϵʾ����  ��");
    	tw3.setContent_source_url("https://mp.weixin.qq.com/s/daVWj8yREyDqUZO4bC2lpw");
    	tw3.setNeed_open_comment(new Uint32(1));
    	tw3.setOnly_fans_can_comment(new Uint32(0));
        sc.setArticles(new Tw[]{tw,tw1,tw2,tw3});
    	return sc;
    }
    public static  DownSc initDownSc (String media_id){
    	DownSc sc=new DownSc();
    	sc.setMedia_id(media_id);
    	return sc;
    }
    public static  GetSc initSc (){
    	GetSc sc=new GetSc();
    	sc.setType("news");
    	sc.setOffset(0);
    	sc.setCount(4);
    	return sc;
    }
  //�ϴ�ͼ��
    public static int createNews(String token, String news){
        String url = CommonConstant.ADD_TW_URL.replace("ACCESS_TOKEN", token);
        int result = 0;
        JSONObject jsonObject = CommonMethod.doPostStr(url, news);
        if(jsonObject != null){
            result = jsonObject.getInt("errcode");
        }
        return result;
    }
    

    /**
     * �ϴ�ͼ���زķ���media_id
     * 
     * */
    public static String uploadNews(String token, String news){
        String url = CommonConstant.ADD_TW_URL.replace("ACCESS_TOKEN", token);
        String result = "";
        JSONObject jsonObject = CommonMethod.doPostStr(url, news);
        if(jsonObject != null){
            result = jsonObject.getString("media_id");
        }
        return result;
    }
    /**
     * �ϴ�ͼ���زĻ�ȡmedia_id
     * 
     * */
    public static String uploadNewsGetMedia_Id(){
    	 AccessToken token=CommonMethod.getAccessToken();

 		String news=JSONObject.fromObject(initNewsMessage()).toString();
 		String media_id=uploadNews(token.getToken(), news);
 		return media_id;
    }
    /**
     * ����media_id��ȡͼ���ز�url
     * 
     * */
    public static News_item downNews(String token, String downsc,Integer i){
    	News_item item=new News_item();
        String url = CommonConstant.DOWN_TW_URL.replace("ACCESS_TOKEN", token);
        String result = "";
        JSONObject jsonObject = CommonMethod.doPostStr(url, downsc);
        if(jsonObject != null){
            result = jsonObject.getString("news_item");
            JSONArray array=(JSONArray)jsonObject.get("news_item");
            result=JSONObject.fromObject(array.get(i)).get("url").toString();
            String title=JSONObject.fromObject(array.get(i)).get("title").toString();
        	String thumb_media_id=JSONObject.fromObject(array.get(i)).get("thumb_media_id").toString();
        	String show_cover_pic=JSONObject.fromObject(array.get(i)).get("show_cover_pic").toString();
        	String author=JSONObject.fromObject(array.get(i)).get("author").toString();
        	String digest=JSONObject.fromObject(array.get(i)).get("digest").toString();
        	String content=JSONObject.fromObject(array.get(i)).get("content").toString();
        	String url1=JSONObject.fromObject(array.get(i)).get("url").toString();
        	String content_source_url=JSONObject.fromObject(array.get(i)).get("content_source_url").toString();
        	String thumb_url=JSONObject.fromObject(array.get(i)).get("thumb_url").toString();
        	item.setTitle(title);
        	item.setThumb_media_id(thumb_media_id);
        	item.setShow_cover_pic(show_cover_pic);
        	item.setAuthor(author);
        	item.setDigest(digest);
        	item.setContent(content);
        	item.setUrl(url1);
        	item.setContent_source_url(content_source_url);
        	item.setThumb_url(thumb_url);
        }
        return item;
    }
    /**
     * ����media_id��ȡͼ���زĵ�url
     * 
     * */
    public static News_item downNewsMedia_Id(String token,String media_id,Integer i){
//    	 AccessToken token=CommonMethod.getAccessToken();
//        media_id="tnwdFvwGUyxL3hPnxP9BAIWhZBDi2nf9I9wc";
 		String downsc=JSONObject.fromObject(initDownSc(media_id)).toString();
 		News_item item =downNews(token, downsc,i);
 		return item;
    }
  //��ȡ�ز��б�
    public static JSONObject GetScList(String token, String getsc){
        String url = CommonConstant.GET_TW_URL.replace("ACCESS_TOKEN", token);
        String result = "";
        JSONObject jsonObject = CommonMethod.doPostStr(url, getsc);
        if(jsonObject != null){
        		
        }
        return jsonObject;
    }
    /**
     * ��ȡͼ���زĵ�List
     * 
     * */
    public static JSONObject GetNewsList(String token){
    	String getsc=JSONObject.fromObject(initSc()).toString();
		JSONObject json=GetScList(CommonConstant.AccessToken(), getsc);
		return json;
    }
    /**
     * ��ȡͼ���زĵ�media_id
     * 
     * */
    public static String GetNewsMediaId(String token,Integer i){
    	JSONObject json= GetNewsList(token);
    	JSONArray array=(JSONArray)json.get("item");
    	String media_id=JSONObject.fromObject(array.get(i)).get("media_id").toString();
    	return media_id;
    }
    /**
     * ��ȡͼ���زĵ�ͼ������
     * 
     * */
    public static News_item GetNews_item(String token,Integer i,Integer j){
    	News_item item=new News_item();
    	JSONObject json= GetNewsList(token);
//    	JSONObject json=JSONObject.fromObject("");
    	JSONArray array=(JSONArray)json.get("item");
    	JSONObject json1=JSONObject.fromObject(JSONObject.fromObject(array.get(i)).get("content"));
    	JSONArray array1=(JSONArray)json1.get("news_item");
    	String title=JSONObject.fromObject(array1.get(j)).get("title").toString();
    	String thumb_media_id=JSONObject.fromObject(array1.get(j)).get("thumb_media_id").toString();
    	String show_cover_pic=JSONObject.fromObject(array1.get(j)).get("show_cover_pic").toString();
    	String author=JSONObject.fromObject(array1.get(j)).get("author").toString();
    	String digest=JSONObject.fromObject(array1.get(j)).get("digest").toString();
    	String content=JSONObject.fromObject(array1.get(j)).get("content").toString();
    	String url=JSONObject.fromObject(array1.get(j)).get("url").toString();
    	String content_source_url=JSONObject.fromObject(array1.get(j)).get("content_source_url").toString();
    	String thumb_url=JSONObject.fromObject(array1.get(j)).get("thumb_url").toString();
    	String need_open_comment=JSONObject.fromObject(array1.get(j)).get("need_open_comment").toString();
    	String only_fans_can_comment=JSONObject.fromObject(array1.get(j)).get("only_fans_can_comment").toString();
    	item.setTitle(title);
    	item.setThumb_media_id(thumb_media_id);
    	item.setShow_cover_pic(show_cover_pic);
    	item.setAuthor(author);
    	item.setDigest(digest);
    	item.setContent(content);
    	item.setUrl(url);
    	item.setContent_source_url(content_source_url);
    	item.setThumb_url(thumb_url);
    	item.setNeed_open_comment(new Uint32(Long.valueOf(need_open_comment)));
    	item.setOnly_fans_can_comment(new Uint32(Long.valueOf(only_fans_can_comment)));
    	return item;

    }

    
    /**
     * ����media_idɾ��ͼ���ز�
     * 
     * */
    public static JSONObject deleteNewsMedia_Id(String token,String media_id){
//    	 AccessToken token=CommonMethod.getAccessToken();
     //   media_id="ZMpRVp_tnwdFvwGUyxL3hIEbxYVzjUCYbDLg4WCjX1U";
 		String downsc=JSONObject.fromObject(initDownSc(media_id)).toString();

 		String url = CommonConstant.DEL_TW_URL.replace("ACCESS_TOKEN", token);
        JSONObject jsonObject = CommonMethod.doPostStr(url, downsc);
 		return jsonObject;
    }
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		AccessToken token=CommonMethod.getAccessToken();
		CreateNewsMessage test=new CreateNewsMessage();
		News_item getNewsItem = test.GetNews_item(token.getToken(), 0, 3);
		System.out.println(getNewsItem.toString());
		String media= test.uploadNewsGetMedia_Id();
//		System.out.println(media);
//		String Media="wa0KMjHBE3YcxdpCC7gKdRwZM9T2g3UDOPN2twsnGf8";
//		News_item downNewsMediaId = test.downNewsMedia_Id(token.getToken(), Media, 0);
//		System.out.println(downNewsMediaId);
//		JSONObject jsonObject=test.deleteNewsMedia_Id(token.getToken(),Media);
//		System.out.println("need_open_comment="+item.getNeed_open_comment());
//		String media=test.uploadNewsGetMedia_Id();
//		System.out.println(media);
	}
	
}
