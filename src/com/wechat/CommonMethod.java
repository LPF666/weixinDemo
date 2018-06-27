package com.wechat;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import net.sf.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;

import com.entity.AccessToken;
import com.entity.User;

public class CommonMethod {
	 /**
     * 微信接口的get请求返回的json数据,不传参
     * @param url
     * @return
     */
    public static JSONObject doGetStr(String url) {
    	DefaultHttpClient httpClient = new DefaultHttpClient();
    	HttpGet httpGet = new HttpGet(url);
    	JSONObject jsonObject = null;
    	try {
    	HttpResponse response = httpClient.execute(httpGet);
    	HttpEntity entity = response.getEntity();
    	if (entity != null) {
    	String result = EntityUtils.toString(entity, "utf-8");
    	jsonObject = JSONObject.fromObject(result);

    	}
    	} catch (ClientProtocolException e) {
    	// TODO Auto-generated catch block
    	e.printStackTrace();
    	} catch (IOException e) {
    	// TODO Auto-generated catch block
    	e.printStackTrace();
    	}
    	return jsonObject;
    	}
    	/**
    	 * 微信接口的post请求返回的json数据，传参
    	 * @param url
    	 * @param outStr
    	 * @return
    	 */
    	public static JSONObject doPostStr(String url, String outStr) {
	    		DefaultHttpClient httpClient = new DefaultHttpClient();
		    	
		    	HttpPost httpPost = new HttpPost(url);
		    	JSONObject jsonObject = null;
		    	httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT,3000);//连接时间
		    	httpPost.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 3000);//数据传输时间
	    	try {
		    	httpPost.setEntity(new StringEntity(outStr, "utf-8"));
		    	HttpResponse response = httpClient.execute(httpPost);
		    	String result = EntityUtils.toString(response.getEntity(), "utf-8");
		    	jsonObject = JSONObject.fromObject(result);
		    	} catch (Exception e) {
		    	e.printStackTrace();
		    	}
		    	return jsonObject;
    	}
    	//获取access_token
    	public static AccessToken getAccessToken(){

    		AccessToken token=new AccessToken();
    		String url=CommonConstant.ACCESS_TOKEN_URL.replace("APPID", CommonConstant.APPID).replace("APPSECRET", CommonConstant.APPSECRET);
    		JSONObject jsonObject=doGetStr(url);
    		System.out.println("aas "+jsonObject.getString("access_token"));
            System.out.println("aac "+jsonObject.getInt("expires_in"));
    		if(jsonObject != null){
                token.setToken(jsonObject.getString("access_token"));
                token.setExpiresIn(jsonObject.getInt("expires_in"));
                
            }
            return token;
    	}
    	//获取access_token
    	public static AccessToken getAccessToken1(String appid,String appsecret){

    		AccessToken token=new AccessToken();
    		String url=CommonConstant.ACCESS_TOKEN_URL.replace("APPID", appid).replace("APPSECRET", appsecret);
    		JSONObject jsonObject=doGetStr(url);
    		System.out.println("aas "+jsonObject.getString("access_token"));
            System.out.println("aac "+jsonObject.getInt("expires_in"));
    		if(jsonObject != null){
                token.setToken(jsonObject.getString("access_token"));
                token.setExpiresIn(jsonObject.getInt("expires_in"));
                
            }
            return token;
    	}
    	//获取用户信息
    	public static User getUser(String openid,String access_token){

    		User user=new User();
    		String url=CommonConstant.ACCESS_TOKEN_OPENID_URL.replace("ACCESS_TOKEN", access_token).replace("OPENID", openid);
    		JSONObject jsonObject=doGetStr(url);
    		System.out.println("jsonObject"+jsonObject.toString());
    		if(jsonObject != null){
    			user.setSubscribe(jsonObject.getInt("subscribe"));
    			user.setOpenid(jsonObject.getString("openid"));
    			user.setNickname(jsonObject.getString("nickname"));
    			user.setSex(jsonObject.getInt("sex"));
    			user.setCity(jsonObject.getString("city"));
    			user.setCountry(jsonObject.getString("country"));
    			user.setProvince(jsonObject.getString("province"));
    			user.setHeadimgurl(jsonObject.getString("headimgurl"));
            }
            return user;
    	}
    	//查询模板的url的拼接
        public static String Getcode() {
      	    String url1=CommonConstant.NETWORK_URL;
			try {
				java.net.URLEncoder.encode(url1, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
            String url = CommonConstant.SELECT_CODE_URL.replace("APPID", CommonConstant.APPID).replace("REDIRECT_URI", url1).replace("SCOPE", "snsapi_userinfo").replace("STATE", "123");
            System.out.println("url："+url);
            return url;
        } 
}
