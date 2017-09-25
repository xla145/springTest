package com.yuelinghui.service.vo;
import java.math.BigDecimal;
import java.util.Date;

import cn.assist.easydao.annotation.Id;
import cn.assist.easydao.annotation.Table;
import cn.assist.easydao.annotation.Temporary;
import cn.assist.easydao.pojo.BasePojo;

/**
* 用户代金券
*
* @author caixb
*/
@Table(name = "member_coupon")
public class MemberCoupon extends BasePojo {
	@Temporary
	private static final long serialVersionUID = 1L;
	
	@Id
	private String mcid;
	private Integer uid;
	private String couponCid;
	private String couponName;
	private String couponInfo;
	private Integer couponType;
	private String couponMsg;
	private BigDecimal couponAmount;
	private Date startTime;
	private Date endTime;
	private Integer status;
	
	
	public String getMcid() {
		return mcid;
	}
	public void setMcid(String mcid) {
		this.mcid = mcid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getCouponCid() {
		return couponCid;
	}
	public void setCouponCid(String couponCid) {
		this.couponCid = couponCid;
	}
	public String getCouponName() {
		return couponName;
	}
	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}
	public String getCouponInfo() {
		return couponInfo;
	}
	public void setCouponInfo(String couponInfo) {
		this.couponInfo = couponInfo;
	}
	public Integer getCouponType() {
		return couponType;
	}
	public void setCouponType(Integer couponType) {
		this.couponType = couponType;
	}
	public String getCouponMsg() {
		return couponMsg;
	}
	public void setCouponMsg(String couponMsg) {
		this.couponMsg = couponMsg;
	}
	public BigDecimal getCouponAmount() {
		return couponAmount;
	}
	public void setCouponAmount(BigDecimal couponAmount) {
		this.couponAmount = couponAmount;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	
}

