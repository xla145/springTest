package com.yuelinghui.service.vo;
import java.util.Date;

import cn.assist.easydao.annotation.Temporary;
import cn.assist.easydao.pojo.BasePojo;

/**
 * 用户代金券
 *
 * @author caixb
 */
public class MemberCouponPage extends BasePojo{
	
	@Temporary
	private static final long serialVersionUID = 1L;
	
	private String mcid;		//用户代金券id
	private Integer uid;		//用户id
	private String cid;			//代金券id
	private Integer status;		//代金券状态	0 无效 10：有效        
	private Integer mcStatus;	//用户代金券状态	0：未使用 10：使用 15 已过期  
	private String name;		//优惠券名字 
	private String info;		//代金券描述
	private Integer type;		//优惠券类型
	private String msg;			//优惠券使用提示信
	private Double price;		//优惠券面额  
	private String remark;
	private Date endTime;		//结束时间
	private Date startTime;		//开始时间
	
	
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
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getMcStatus() {
		return mcStatus;
	}
	public void setMcStatus(Integer mcStatus) {
		this.mcStatus = mcStatus;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	@Override
	public String toString() {
		return "MemberCouponPage [mcid=" + mcid + ", uid=" + uid + ", cid=" + cid + ", status=" + status + ", mcStatus=" + mcStatus + ", name=" + name + ", info=" + info + ", type=" + type + ", msg=" + msg + ", price=" + price + ", remark=" + remark + ", endTime=" + endTime + ", startTime=" + startTime + "]";
	}
	
}
