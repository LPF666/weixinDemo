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
     * 回复3展示的图文消息转换成的报文信息
     * 
     */
    public static Sc initNewsMessage(){
    	Uint32 b = new Uint32(0);
        Uint32 c = new Uint32(1);
    	Sc sc=new Sc();
    	Tw tw=new Tw();
    	tw.setTitle("中国");
    	tw.setThumb_media_id("wa0KMjHBE3YcxdpCC7gKdfC2Zs46gQpxy8OhjIEUhoM");
    	tw.setAuthor("严福晶");
    	tw.setDigest("中华人民共和国位于亚洲东部，太平洋西岸，是工人阶级领导的、以工农联盟为基础的人民民主专政的社会主义国家");
    	tw.setShow_cover_pic("1");
    	tw.setContent("中华人民共和国位于亚洲东部，太平洋西岸  ，是工人阶级领导的、以工农联盟为基础的人民民主专政的社会主义国家  。1949年（己丑年）10月1日成立   ，以五星红旗为国旗  ，《义勇军进行曲》为国歌   ，国徽内容包括国旗、天安门、齿轮和麦稻穗  ，首都北京 ，省级行政区划为23个省、5个自治区、4个直辖市、2个特别行政区  ，是一个以汉族为主体民族，由56个民族构成的统一多民族国家，汉族占总人口的91.51%   。");
    	tw.setContent_source_url("https://mp.weixin.qq.com/s/daVWj8yREyDqUZO4bC2lpw");
    	tw.setNeed_open_comment(new Uint32(1));
    	tw.setOnly_fans_can_comment(new Uint32(0));
    	Tw tw1=new Tw();
    	tw1.setTitle("山西");
    	tw1.setThumb_media_id("wa0KMjHBE3YcxdpCC7gKdXSpNa1QYNDV8YES_byMW5s");
    	tw1.setAuthor("严福晶");
    	tw1.setDigest("山西，中华人民共和国省级行政区，省会太原市，因居太行山之西而得名，简称“晋”");
    	tw1.setShow_cover_pic("1");
    	tw1.setContent("山西，中华人民共和国省级行政区，省会太原市，因居太行山之西而得名，简称“晋”，东依太行山，西、南依吕梁山、黄河，北依长城，与河北、河南、陕西、内蒙古等省区为界。介于北纬34°34′—40°44′，东经110°14′—114°33′之间，总面积15.67万平方千米，山区面积约占总面积的80%以上。山西又称“三晋”，古称河东，是中华民族发祥地之一，有文字记载的历史达三千年，被誉为“华夏文明摇篮”，素有“中国古代文化博物馆”之称。柳宗元称之为“表里山河”。");
    	tw1.setContent_source_url("https://mp.weixin.qq.com/s/daVWj8yREyDqUZO4bC2lpw");
    	tw1.setNeed_open_comment(new Uint32(1));
    	tw1.setOnly_fans_can_comment(new Uint32(0));
    	Tw tw2=new Tw();
    	tw2.setTitle("太原");
    	tw2.setThumb_media_id("wa0KMjHBE3YcxdpCC7gKdcaZwTKaIR3-ShydJmaTVFY");
    	tw2.setAuthor("严福晶");
    	tw2.setDigest("太原，山西省省会，简称“并（bīng）”，别称并州，古称晋阳，也称龙城");
    	tw2.setShow_cover_pic("1");
    	tw2.setContent("太原，山西省省会，简称“并（bīng）”，别称并州，古称晋阳，也称龙城，是中国优秀旅游城市、国家历史文化名城、国家园林城市、中部地区重要的中心城市、太原都市圈核心城市，山西省政治、经济、文化、交通和国际交流中心，是一座具有4700多年历史，2500年建城史，“控带山河，踞天下之肩背”，“襟四塞之要冲，控五原之都邑”的历史古都。太原市三面环山，黄河第二大支流汾河自北向南流经，自古就有“锦绣太原城”的美誉，是中国北方军事、文化重镇，世界晋商都会，中国能源、重工业基地之一。太原的城市精神是包容、尚德、崇法、诚信、卓越。");
    	tw2.setContent_source_url("https://mp.weixin.qq.com/s/daVWj8yREyDqUZO4bC2lpw");
    	tw2.setNeed_open_comment(new Uint32(1));
    	tw2.setOnly_fans_can_comment(new Uint32(0));
    	Tw tw3=new Tw();
    	tw3.setTitle("长治");
    	tw3.setThumb_media_id("wa0KMjHBE3YcxdpCC7gKdTBUYg9R3tdI7yYgirluOYg");
    	tw3.setAuthor("严福晶");
    	tw3.setDigest("长治，古称上党、潞州、潞安府等。“长治”原为潞安府府治所在县名，得名于明嘉靖八年（1529年），取长治久安之意。");
    	tw3.setShow_cover_pic("1");
    	tw3.setContent("长治，古称上党、潞州、潞安府等。“长治”原为潞安府府治所在县名，得名于明嘉靖八年（1529年），取长治久安之意。长治地处晋东南，晋冀豫三省交界，全境位于由太行山太岳山环绕而成的上党盆地中。长治历史悠久，周显王二十一年（前348年）韩国在此首置上党郡，秦王政二十六年（前221年）秦一统六国分天下为三十六郡，上党郡为其一，市区内留存有古上党郡署大门上党门和国内现存规模最大、中轴线长408米的城隍庙潞安府城隍庙。长治是全国文明城市   、中国优秀旅游城市   、国家森林城市  、国家园林城市   、国家卫生城市  、中国十大魅力城市、中国曲艺名城  、国家公共文化服务体系示范区  。");
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
  //上传图文
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
     * 上传图文素材返回media_id
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
     * 上传图文素材获取media_id
     * 
     * */
    public static String uploadNewsGetMedia_Id(){
    	 AccessToken token=CommonMethod.getAccessToken();

 		String news=JSONObject.fromObject(initNewsMessage()).toString();
 		String media_id=uploadNews(token.getToken(), news);
 		return media_id;
    }
    /**
     * 根据media_id获取图文素材url
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
     * 根据media_id获取图文素材的url
     * 
     * */
    public static News_item downNewsMedia_Id(String token,String media_id,Integer i){
//    	 AccessToken token=CommonMethod.getAccessToken();
//        media_id="tnwdFvwGUyxL3hPnxP9BAIWhZBDi2nf9I9wc";
 		String downsc=JSONObject.fromObject(initDownSc(media_id)).toString();
 		News_item item =downNews(token, downsc,i);
 		return item;
    }
  //获取素材列表
    public static JSONObject GetScList(String token, String getsc){
        String url = CommonConstant.GET_TW_URL.replace("ACCESS_TOKEN", token);
        String result = "";
        JSONObject jsonObject = CommonMethod.doPostStr(url, getsc);
        if(jsonObject != null){
        		
        }
        return jsonObject;
    }
    /**
     * 获取图文素材的List
     * 
     * */
    public static JSONObject GetNewsList(String token){
    	String getsc=JSONObject.fromObject(initSc()).toString();
		JSONObject json=GetScList(CommonConstant.AccessToken(), getsc);
		return json;
    }
    /**
     * 获取图文素材的media_id
     * 
     * */
    public static String GetNewsMediaId(String token,Integer i){
    	JSONObject json= GetNewsList(token);
    	JSONArray array=(JSONArray)json.get("item");
    	String media_id=JSONObject.fromObject(array.get(i)).get("media_id").toString();
    	return media_id;
    }
    /**
     * 获取图文素材的图文属性
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
     * 根据media_id删除图文素材
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
