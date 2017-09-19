package com.yuelinghui.base.constant;

/**
 * 全局 Constant
 *
 * @author caixb
 */
public class GlobalConstant {
	
	/**
	 * 登录session uid
	 */
	public static final String SESSION_UID = "uid";
	
	/**
	 * 登录用户cookie key
	 */
	public static final String COOKIE_KEY = "auto-token";

	
	/**用户 登录token 租期(小时为单位)**/
	public static final int MEMBER_LOGIN_TOKEN_TENANCYTERM  = 720; //30天有效
	
	
	
	/**消息通知类型**/
	public static final String NOTICE_SUCCESS = "success";
	public static final String NOTICE_ERROR = "error";
	public static final String NOTICE_WARN = "warn";
	
}
