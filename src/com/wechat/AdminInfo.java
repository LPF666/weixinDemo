package com.wechat;

import com.entity.AccessToken;

public class AdminInfo {
	 //公众号的appid
	public static final String APPID="wxfedb3e37199405fd";
	//公众号的appsecret
	public static final String APPSECRET="3b9675e3251c9e0b410b5ab5bf0c72f7";
	//外网映射地址
	public static final String NETWORK_URL="http://lpf.free.ngrok.cc/weixinDemo";
	public static String AccessToken(){
		 AccessToken token=CommonMethod.getAccessToken();
		 return token.getToken();
	}
}
