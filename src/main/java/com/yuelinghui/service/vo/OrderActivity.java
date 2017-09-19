package com.yuelinghui.service.vo;
import java.util.Date;

import cn.assist.easydao.annotation.Id;
import cn.assist.easydao.annotation.Temporary;
import cn.assist.easydao.pojo.BasePojo;

/**
 * 活动订单
 *
 * @author caixb
 */
public class OrderActivity extends BasePojo{

	@Temporary
	private static final long serialVersionUID = 1L;
	
	
	@Id
	private String orderId;					//订单id
	private String activityAddr;			//活动地点
	private String activityInfo;			//活动详细信息
	private Integer orderActivityStatus;	//活动订单状态 0：初始状态   10：待开始 12:已开始  15：已结束  20：已取消
	private Integer inviteCount;			//陪同人数 为0表示不可免费邀请同行人
	private Date activityStartTime;			//活动开始时间
	private Date activityEndTime;			//活动结束时间
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getActivityAddr() {
		return activityAddr;
	}
	public void setActivityAddr(String activityAddr) {
		this.activityAddr = activityAddr;
	}
	public String getActivityInfo() {
		return activityInfo;
	}
	public void setActivityInfo(String activityInfo) {
		this.activityInfo = activityInfo;
	}
	public Integer getOrderActivityStatus() {
		return orderActivityStatus;
	}
	public void setOrderActivityStatus(Integer orderActivityStatus) {
		this.orderActivityStatus = orderActivityStatus;
	}
	public Integer getInviteCount() {
		return inviteCount;
	}
	public void setInviteCount(Integer inviteCount) {
		this.inviteCount = inviteCount;
	}
	public Date getActivityStartTime() {
		return activityStartTime;
	}
	public void setActivityStartTime(Date activityStartTime) {
		this.activityStartTime = activityStartTime;
	}
	public Date getActivityEndTime() {
		return activityEndTime;
	}
	public void setActivityEndTime(Date activityEndTime) {
		this.activityEndTime = activityEndTime;
	}
	@Override
	public String toString() {
		return "OrderActivityPage [orderId=" + orderId + ", activityAddr="
				+ activityAddr + ", activityInfo=" + activityInfo
				+ ", orderActivityStatus=" + orderActivityStatus
				+ ", inviteCount=" + inviteCount + ", activityStartTime="
				+ activityStartTime + ", activityEndTime=" + activityEndTime
				+ "]";
	}
	
	
	
}
