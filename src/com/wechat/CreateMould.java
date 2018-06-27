package com.wechat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TreeMap;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.entity.AccessToken;
import com.entity.Mould;

import com.wechatservice.message.WechatTemplateMsg;

public class CreateMould {
	//����ģ���urlƴ��
    public String createMould(String token, String mould){
        String url = CommonConstant.CREATE_MOULD_URL.replace("ACCESS_TOKEN", token);

        JSONObject jsonObject = CommonMethod.doPostStr(url, mould);
        if(jsonObject != null){
           
        }
        return null;
    }
    
  //��ʼ����ҵ����
    public Mould initMould(){
    	Mould mould=new Mould();
    	mould.setIndustry_id1("2");
    	mould.setIndustry_id2("3");
    	return mould;
    	
    }
    
  //��ѯģ���url��ƴ��
  public JSONObject queryMould(String token){
      String url = CommonConstant.SELECT_MOULD_URL.replace("ACCESS_TOKEN", token);
      JSONObject jsonObject = CommonMethod.doGetStr(url);
      return jsonObject;
  }
//  //������ҵ
  public static void main(String[] args) {
		CreateMould test = new CreateMould();
      AccessToken token=CommonMethod.getAccessToken();
//      System.out.println("Ʊ��"+token.getToken());
//      System.out.println("��Чʱ��"+token.getExpiresIn());
////		String mould=JSONObject.fromObject(test.initMould()).toString();
////		System.out.println(mould);
////		test.createMould(token.getToken(), mould);
//		@SuppressWarnings("unused")
////		JSONObject jsonObject=test.queryMould(token.getToken());
////		System.out.println(jsonObject.get("primary_industry"));
////		System.out.println(JSONObject.fromObject(jsonObject.get("primary_industry")).get("first_class"));
////		System.out.println(JSONObject.fromObject(jsonObject.get("primary_industry")).get("second_class"));
////		System.out.println(jsonObject.get("secondary_industry"));
////		System.out.println(JSONObject.fromObject(jsonObject.get("secondary_industry")).get("first_class"));
////		System.out.println(JSONObject.fromObject(jsonObject.get("secondary_industry")).get("second_class"));
		JSONObject jsonObject=test.queryMouldList(token.getToken());
		
		JSONArray array=(JSONArray)jsonObject.get("template_list");
//		System.out.println(array.get(0));
//		System.out.println(array.get(1));
//		System.out.println(JSONObject.fromObject(array.get(0)).get("template_id"));
//		System.out.println(JSONObject.fromObject(array.get(0)).get("title"));
//		System.out.println(JSONObject.fromObject(array.get(0)).get("primary_industry"));
//		System.out.println(JSONObject.fromObject(array.get(0)).get("deputy_industry"));
//		System.out.println(JSONObject.fromObject(array.get(0)).get("content"));
//		System.out.println(JSONObject.fromObject(array.get(0)).get("example"));
//		test.sendTemplate("");
		
	}
  
//��ȡģ���б�
  public JSONObject queryMouldList(String token){
      String url = CommonConstant.QUERY_MOULD_LIST_URL.replace("ACCESS_TOKEN", token);
      JSONObject jsonObject = CommonMethod.doGetStr(url);
      return jsonObject;
  }
  public Long sendTemplate1(String accessToken,String data){
	  String url = CommonConstant.SEND_MOULD_URL.replace("ACCESS_TOKEN", accessToken);
	  long result=0l;
      JSONObject jsonObject = CommonMethod.doPostStr(url, data);
      if(jsonObject != null){
    	   result=Long.valueOf(jsonObject.get("errcode").toString());
         if(result==0l){
        	 System.out.println("���ͳɹ�");
        	 result=Long.valueOf(jsonObject.get("msgid").toString());
         }
      }
      return result;
  }
  
//  /** 
//   * ����ģ����Ϣ 
//   *  
//   * @param accessToken 
//   * @param data 
//   * @return ״̬ 
//   */  
//  @Override  
//  public TemplateMsgResult sendTemplate(String accessToken, String data) {  
//      TemplateMsgResult templateMsgResult = null;  
//      TreeMap<String, String> params = new TreeMap<String, String>();  
//      params.put("access_token", accessToken);  
//      String result = HttpReqUtil.HttpsDefaultExecute(SystemConfig.POST_METHOD, WechatConfig.SEND_TEMPLATE_MESSAGE,  
//              params, data);  
//      templateMsgResult = JsonUtil.fromJsonString(result, TemplateMsgResult.class);  
//      //log.....  
//      return templateMsgResult;  
//  } 
  
  
  public Long sendTemplate(String fromUserName){
	  AccessToken token=CommonMethod.getAccessToken();

      TreeMap<String,TreeMap<String,String>> params = new TreeMap<String,TreeMap<String,String>>();  
      //���ݾ���ģ�������װ  
      params.put("first",WechatTemplateMsg.item("��ӭʹ�ù��������ں�ƽ̨", "#FF3333"));  
      params.put("shebaoID",WechatTemplateMsg.item("A123456", "#0044BB"));  
      params.put("name",WechatTemplateMsg.item("��ĳ", "#0044BB"));  
      params.put("money",WechatTemplateMsg.item("50Ԫ", "#FF3333")); 
      SimpleDateFormat s=new SimpleDateFormat("yyyy��MM��dd�� hh:mm");
      params.put("type",WechatTemplateMsg.item("����ҩ�걨��", "#0044BB")); 
      params.put("YuMoney",WechatTemplateMsg.item("1000Ԫ", "#FF3333")); 
      params.put("time",WechatTemplateMsg.item(s.format(new Date()) , "#0044BB")); 
      params.put("remark",WechatTemplateMsg.item("������ʱ��ע������ϸ��", "#AAAAAA"));  
      WechatTemplateMsg wechatTemplateMsg = new WechatTemplateMsg();  
      wechatTemplateMsg.setTemplate_id("N5HpdIeKp6aNcVqDIvjPGvUXKDnm74HWPB8mxd-RXhc");    
      wechatTemplateMsg.setTouser(fromUserName);
      wechatTemplateMsg.setUrl("http://music.163.com/#/song?id=27867140");  
      wechatTemplateMsg.setData(params);  
      String data = JSONObject.fromObject(wechatTemplateMsg).toString();
//      this.sendTemplate(token.getToken(), data);
      Long result=  sendTemplate1(token.getToken(), data);  
      return result;  
  }
}
