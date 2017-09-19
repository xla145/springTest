package com.yuelinghui.base.constant;

/**
 * 微信接口api
 *
 * @author caixb
 * 2017年7月11日
 */
public class ApiUrlConstant {

	/**
	 * 微信网页授权接口
	 */
	public static final String AUTHORIZE_URI = "https://open.weixin.qq.com/connect/oauth2/authorize";
	
	/**
	 * 微信网页授权接口 --> 通过code换取网页授权access_token
	 */
	public static final String AUTHORIZE_GETACCESSTOKEN = "https://api.weixin.qq.com/sns/oauth2/access_token";
	
	/**
	 * 微信api接口 --> 获取 jsapi_ticket接口 
	 */
	public static final String WEIXIN_API_GETJSAPITICKET = "https://api.weixin.qq.com/cgi-bin/ticket/getticket";
	
	/**
	 * 微信api接口 --> 获取 access token接口 
	 * 
	 */
	public static final String WEIXIN_API_GETACCESSTOKEN = "https://api.weixin.qq.com/cgi-bin/token";
	
	/**
	 * 微信api接口 --> 创建菜单接口
	 */
	public static final String WEIXIN_API_CREATEMENU = "https://api.weixin.qq.com/cgi-bin/menu/create";
	
	/**
	 * 微信api接口 --> 统一下单接口
	 */
	public static final String WEIXIN_API_UNIFIEDORDER = "https://api.mch.weixin.qq.com/pay/unifiedorder";
	
	
	
}
