package com.wechat;

public class CommonConstant extends AdminInfo{
	//�����˵���url
	public static final String CREATE_MENU_URL="https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

	//��ȡaccess_token��url
	public static final String ACCESS_TOKEN_URL="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	//��ȡ�û���Ϣ��url
	public static final String ACCESS_TOKEN_OPENID_URL="https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	//������ҵ
	public static final String CREATE_MOULD_URL="https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=ACCESS_TOKEN";
	//����ģ��
	public static final String SELECT_MOULD_URL="https://api.weixin.qq.com/cgi-bin/template/get_industry?access_token=ACCESS_TOKEN";

	//��ȡ��ҳȨ��
	public static final String SELECT_CODE_URL=
				"https://open.weixin.qq.com/connect/oauth2/authorize?" +
				"appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
	//��ȡģ��id
	public static final String QUERY_MOULD_URL="https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=ACCESS_TOKEN";
	//��ȡģ���б�
	public static final String QUERY_MOULD_LIST_URL="https://api.weixin.qq.com/cgi-bin/template/get_all_private_template?access_token=ACCESS_TOKEN";
	//����ģ����Ϣ
	public static final String SEND_MOULD_URL="https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
	//�����ز�
	public static final String ADD_SC_URL="https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=ACCESS_TOKEN&type=TYPE";
	//����ͼ���ز�
	public static final String ADD_TW_URL="https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=ACCESS_TOKEN";
	//����ͼ���ز�
	public static final String DOWN_TW_URL="https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=ACCESS_TOKEN";
	//��ȡ�ز��б�
	public static final String GET_TW_URL="https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=ACCESS_TOKEN";
	//ɾ���ز�
	public static final String DEL_TW_URL="https://api.weixin.qq.com/cgi-bin/material/del_material?access_token=ACCESS_TOKEN";
}
