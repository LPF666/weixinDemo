package com.wechat;



import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONObject;

import com.entity.AccessToken;
import com.entity.Button;
import com.entity.ClickButton;
import com.entity.Menu;
import com.entity.Mould;
import com.entity.User;
import com.entity.ViewButton;

public class CreateMenu {
	
	//初始化菜单
    public static Menu initMenu(){
    	Menu menu=new Menu();
    	ClickButton button11=new ClickButton();
    	button11.setName("click菜单1");
    	button11.setType("click");
    	button11.setKey("11");
    	ClickButton button12=new ClickButton();
    	button12.setName("click菜单2");
    	button12.setType("click");
    	button12.setKey("12");
    	Button button1=new Button();
    	button1.setName("click菜单");
    	button1.setSub_button(new Button[]{button11,button12});
    	ViewButton button21=new ViewButton();
    	button21.setName("view菜单");
    	button21.setType("view");
    	button21.setUrl(CommonMethod.Getcode());
    	ClickButton button31=new ClickButton();
    	button31.setName("扫描事件");
    	button31.setType("scancode_push");
    	button31.setKey("31");
    	ClickButton button32=new ClickButton();
    	button32.setName("地理位置");
    	button32.setType("location_select");
    	button32.setKey("32");
    	Button button=new Button();
    	button.setName("菜单");
    	button.setSub_button(new Button[]{button31,button32});
    	menu.setButton(new Button []{button1,button21,button});
    	return menu;
    	
    }
    
  //创建菜单的url拼接
    public static int createMenu(String token, String menu){
        String url = CommonConstant.CREATE_MENU_URL.replace("ACCESS_TOKEN", token);
        int result = 0;
        JSONObject jsonObject = CommonMethod.doPostStr(url, menu);
        if(jsonObject != null){
            result = jsonObject.getInt("errcode");
        }
        return result;
    }
   
    	
	public static void main(String[] args) {
		CreateMenu test = new CreateMenu();
        AccessToken token=CommonMethod.getAccessToken();
        System.out.println("票据"+token.getToken());
        System.out.println("有效时间"+token.getExpiresIn());
		String menu=JSONObject.fromObject(test.initMenu()).toString();
		int result=test.createMenu(token.getToken(), menu);
		if(result==0){
			System.out.println("创建菜单成功");
		}else{
			System.out.println(""+result);
			System.out.println(""+menu);
		}
	}
}
