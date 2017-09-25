package com.yuelinghui.service.vo;
import java.util.Date;

import cn.assist.easydao.annotation.Table;
import cn.assist.easydao.annotation.Temporary;
import cn.assist.easydao.pojo.BasePojo;

/**
 * 支付单
 *
 * @author caixb
 */
@Table(name = "pay_order_detail")
public class PayInfo extends BasePojo{
	
	@Temporary
	private static final long serialVersionUID = 1L;
	
	private String payId;				//支付id
	private String orderId;				//订单id
	private Integer payWay;				//支付方式，1：微信支付  2：支付宝支付  3：代金券抵扣 
	private Integer payType;			//支付类型，1：支付单  2：差价单
	private Double payAmount;			//支付金额
	private String mcid;				//代金券id
	private Date createTime;			//创建时间
	private Date updateTime;			//更新时间
	private Integer status;				//0:支付未完成， 10:支付成功, 20:支付失败，30已退费
	private Date paySuccessTime;		//支付成功时间
	private String payFailMsg;			//支付失败原因
	
	
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
	public Integer getPayWay() {
		return payWay;
	}
	public void setPayWay(Integer payWay) {
		this.payWay = payWay;
	}
	public Integer getPayType() {
		return payType;
	}
	public void setPayType(Integer payType) {
		this.payType = payType;
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
}
