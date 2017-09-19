package com.yuelinghui.base.helper;

/**
 * 响应请求消息对象
 * 
 * @author caixb
 *
 */
public class RecordBean {

	public static final int ERR = -1;
	public static final int OK = 0;
	
	private int code;
	
	private String msg;
	
	private Object data;
	
	public RecordBean(int code, String msg){
		this.code = code;
		this.msg = msg;
	}
	
	public RecordBean(int code, String msg, Object data){
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}
