package com.yuelinghui.service.vo;
import java.util.Date;

import cn.assist.easydao.annotation.Id;
import cn.assist.easydao.annotation.Temporary;

/**
 * 
 * 产品---> 活动
 *
 * @author caixb
 */
public class ProductActivity extends Product{
	@Temporary
	private static final long serialVersionUID = 1L;
	@Id
	private Integer id;
	private Integer browse;
	private String pid;
	private String address;
	private Date applyStartTime;//活动报名开始时间
	private Date applyEndTime;//活动报名结束时间
	private Date activityStartTime;//活动开始时间
	private Date activityEndTime;//活动结束时间
	private Integer wantNumber;//想去的人数
	private Integer carryNumber;//是否可以携带人
	private Integer activityStatus; //0：初始状态 10：报名中， 20：进行中， 30已结束  
	private Integer applyMax; //报名人数最大限制                                                       
	private Integer applyCurrent;//当前报名人数 
	
	
	public void setId(Integer id){
		this.id=id;
	}
	public Integer getId(){
		return id;
	}
	
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public void setAddress(String address){
		this.address=address;
	}
	public String getAddress(){
		return address;
	}
	public Integer getActivityStatus() {
		return activityStatus;
	}
	public void setActivityStatus(Integer activityStatus) {
		this.activityStatus = activityStatus;
	}
	public Integer getBrowse() {
		return browse;
	}
	public void setBrowse(Integer browse) {
		this.browse = browse;
	}
	public Integer getWantNumber() {
		return wantNumber;
	}
	public void setWantNumber(Integer wantNumber) {
		this.wantNumber = wantNumber;
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
	public Integer getCarryNumber() {
		return carryNumber;
	}
	public void setCarryNumber(Integer carryNumber) {
		this.carryNumber = carryNumber;
	}
	public Integer getApplyMax() {
		return applyMax;
	}
	public void setApplyMax(Integer applyMax) {
		this.applyMax = applyMax;
	}
	public Integer getApplyCurrent() {
		return applyCurrent;
	}
	public void setApplyCurrent(Integer applyCurrent) {
		this.applyCurrent = applyCurrent;
	}
	public Date getApplyStartTime() {
		return applyStartTime;
	}
	public void setApplyStartTime(Date applyStartTime) {
		this.applyStartTime = applyStartTime;
	}
	public Date getApplyEndTime() {
		return applyEndTime;
	}
	public void setApplyEndTime(Date applyEndTime) {
		this.applyEndTime = applyEndTime;
	}
	
}

