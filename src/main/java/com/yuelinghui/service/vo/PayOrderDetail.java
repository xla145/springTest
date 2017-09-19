package com.yuelinghui.service.vo;
import java.util.Date;

import cn.assist.easydao.annotation.Id;
import cn.assist.easydao.annotation.Temporary;
import cn.assist.easydao.pojo.BasePojo;

/**
 * 支付单
 *
 * @author caixb
 */
public class PayOrderDetail extends BasePojo{
	@Temporary
	private static final long serialVersionUID = 1L;
	
	@Id
	private String payId;
	private String orderId;				//支付订单id
	private String payOrderId;			//支付单id
	private Integer payType;			//支付方式，1；微信支付  2：支付宝支付  3：代金券抵扣 4：xxoo
	private String payAccount;			//支付者账号 支付宝：支付宝账号
	private String openId;				//支付者账号 微信：openId
	private Double payAmount;			//支付金额
	private String mcid;				//代金券id
	private Date createTime;			//创建时间
	private Date updateTime;			//更新时间
	private Integer status;				//0:支付未完成， 10:支付成功, 20:支付失败，30已退费
	private Date paySuccessTime;		//支付成功时间
	private String payFailMsg;			//支付失败原因
	private String wxTradeType;			//交易类型，取值为：JSAPI，NATIVE，APP等，说明详见参数规定
	private String wxPrepayId;			//微信生成的预支付会话标识，用于后续接口调用中使用，该值有效期为2小时
	private String wxCodeUrl;			//trade_type为NATIVE时有返回，用于生成二维码，展示给用户进行扫码支付
	private String wxJsapiParam;		//trade_type为JSAPI时生成jsapi调起微信支付的参数 
	private String wxUnifiedOrderXml;	//微信统一下单参数结果
	private String remark;				//备注
	
	
	
	public String getPayId() {
		return payId;
	}
	public void setPayId(String payId) {
		this.payId = payId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getPayOrderId() {
		return payOrderId;
	}
	public void setPayOrderId(String payOrderId) {
		this.payOrderId = payOrderId;
	}
	public Integer getPayType() {
		return payType;
	}
	public void setPayType(Integer payType) {
		this.payType = payType;
	}
	public String getPayAccount() {
		return payAccount;
	}
	public void setPayAccount(String payAccount) {
		this.payAccount = payAccount;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public Double getPayAmount() {
		return payAmount;
	}
	public void setPayAmount(Double payAmount) {
		this.payAmount = payAmount;
	}
	public String getMcid() {
		return mcid;
	}
	public void setMcid(String mcid) {
		this.mcid = mcid;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getPaySuccessTime() {
		return paySuccessTime;
	}
	public void setPaySuccessTime(Date paySuccessTime) {
		this.paySuccessTime = paySuccessTime;
	}
	public String getPayFailMsg() {
		return payFailMsg;
	}
	public void setPayFailMsg(String payFailMsg) {
		this.payFailMsg = payFailMsg;
	}
	public String getWxTradeType() {
		return wxTradeType;
	}
	public void setWxTradeType(String wxTradeType) {
		this.wxTradeType = wxTradeType;
	}
	public String getWxPrepayId() {
		return wxPrepayId;
	}
	public void setWxPrepayId(String wxPrepayId) {
		this.wxPrepayId = wxPrepayId;
	}
	public String getWxCodeUrl() {
		return wxCodeUrl;
	}
	public void setWxCodeUrl(String wxCodeUrl) {
		this.wxCodeUrl = wxCodeUrl;
	}
	public String getWxJsapiParam() {
		return wxJsapiParam;
	}
	public void setWxJsapiParam(String wxJsapiParam) {
		this.wxJsapiParam = wxJsapiParam;
	}
	public String getWxUnifiedOrderXml() {
		return wxUnifiedOrderXml;
	}
	public void setWxUnifiedOrderXml(String wxUnifiedOrderXml) {
		this.wxUnifiedOrderXml = wxUnifiedOrderXml;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "PayOrderDetail [payId=" + payId + ", orderId=" + orderId
				+ ", payOrderId=" + payOrderId + ", payType=" + payType
				+ ", payAccount=" + payAccount + ", openId=" + openId
				+ ", payAmount=" + payAmount + ", mcid=" + mcid
				+ ", createTime=" + createTime + ", updateTime=" + updateTime
				+ ", status=" + status + ", paySuccessTime=" + paySuccessTime
				+ ", payFailMsg=" + payFailMsg + ", wxTradeType=" + wxTradeType
				+ ", wxPrepayId=" + wxPrepayId + ", wxCodeUrl=" + wxCodeUrl
				+ ", wxJsapiParam=" + wxJsapiParam + ", wxUnifiedOrderXml="
				+ wxUnifiedOrderXml + ", remark=" + remark + "]";
	}

	
	
}
