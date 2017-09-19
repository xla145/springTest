package com.yuelinghui.base.helper;

import com.alibaba.fastjson.JSONObject;


/**
 * response json格式
 * 
 * @author caixb
 *
 */
public class JsonBean {

	public static final int ERR = -1;
	public static final int OK = 0;

	public static JSONObject error(String msg) {
		JSONObject json = new JSONObject();
		json.put("code", JsonBean.ERR);
		json.put("msg", msg);
		return json;
	}

	public static JSONObject error(int code, String msg) {
		JSONObject json = new JSONObject();
		json.put("code", code);
		json.put("msg", msg);
		return json;
	}

	public static JSONObject error(int code, String msg, String data) {
		JSONObject json = new JSONObject();
		json.put("code", code);
		json.put("msg", msg);
		json.put("data", data);
		return json;
	}
	
	public static JSONObject success(String msg) {
		JSONObject json = new JSONObject();
		json.put("code", JsonBean.OK);
		json.put("msg", msg);
		return json;
	}
	
	public static JSONObject success(String msg, Object data) {
		JSONObject json = new JSONObject();
		json.put("code", JsonBean.OK);
		json.put("msg", msg);
		json.put("data", data);
		return json;
	}
}
