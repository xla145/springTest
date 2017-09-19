package com.yuelinghui.base.helper;

/**
 * xxoo 词穷
 * 
 * @author caixb
 *
 */
public class NoticeBean {

	private String pageType;
	private String msg;
	private String btnText;
	private String btnUrl;
	private int veerTime;
	private String veerUrl;
	public NoticeBean(){}
	public NoticeBean(String pageType, String msg, String btnText, String btnUrl){
		this.pageType = pageType;
		this.msg = msg;
		this.btnText = btnText;
		this.btnUrl = btnUrl;
	}
	public String getPageType() {
		return pageType;
	}
	public void setPageType(String pageType) {
		this.pageType = pageType;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getBtnText() {
		return btnText;
	}
	public void setBtnText(String btnText) {
		this.btnText = btnText;
	}
	public String getBtnUrl() {
		return btnUrl;
	}
	public void setBtnUrl(String btnUrl) {
		this.btnUrl = btnUrl;
	}
	public int getVeerTime() {
		return veerTime;
	}
	public void setVeerTime(int veerTime) {
		this.veerTime = veerTime;
	}
	public String getVeerUrl() {
		return veerUrl;
	}
	public void setVeerUrl(String veerUrl) {
		this.veerUrl = veerUrl;
	}
	
}
