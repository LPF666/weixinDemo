package com.wechat;

public class CommonConstant extends AdminInfo{
	//创建菜单的url
	public static final String CREATE_MENU_URL="https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

	//获取access_token的url
	public static final String ACCESS_TOKEN_URL="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	//获取用户信息的url
	public static final String ACCESS_TOKEN_OPENID_URL="https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	//创建行业
	public static final String CREATE_MOULD_URL="https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=ACCESS_TOKEN";
	//创建模板
	public static final String SELECT_MOULD_URL="https://api.weixin.qq.com/cgi-bin/template/get_industry?access_token=ACCESS_TOKEN";

	//获取网页权限
	public static final String SELECT_CODE_URL=
				"https://open.weixin.qq.com/connect/oauth2/authorize?" +
				"appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
	//获取模板id
	public static final String QUERY_MOULD_URL="https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=ACCESS_TOKEN";
	//获取模板列表
	public static final String QUERY_MOULD_LIST_URL="https://api.weixin.qq.com/cgi-bin/template/get_all_private_template?access_token=ACCESS_TOKEN";
	//发送模板消息
	public static final String SEND_MOULD_URL="https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
	//新增素材
	public static final String ADD_SC_URL="https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=ACCESS_TOKEN&type=TYPE";
	//新增图文素材
	public static final String ADD_TW_URL="https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=ACCESS_TOKEN";
	//下载图文素材
	public static final String DOWN_TW_URL="https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=ACCESS_TOKEN";
	//获取素材列表
	public static final String GET_TW_URL="https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=ACCESS_TOKEN";
	//删除素材
	public static final String DEL_TW_URL="https://api.weixin.qq.com/cgi-bin/material/del_material?access_token=ACCESS_TOKEN";
}
