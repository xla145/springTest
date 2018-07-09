package com.yuelinghui.service.vo;

import cn.assist.easydao.annotation.Temporary;
import cn.assist.easydao.pojo.BasePojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 
 * 
 * @author XXXX
 * @email xxx@yuelinghui.com
 * @date 2018-06-25 14:27:28
 */
public class Coupon extends BasePojo {
	@Temporary
	private static final long serialVersionUID = 1L;
	
	//优惠劵编号
	private String cid;
	//优惠券名字
	private String name;
	//代金券描述
	private String info;
	//优惠券类型 1:好玩券 2：好物券  99：通用券
	private Integer type;
	//优惠券使用提示信息
	private String msg;
	//优惠券面额
	private BigDecimal price;
	//生成总张数
	private Integer stock;
	//剩余数
	private Integer remaining;
	//状态 0 无效 10：有效
	private Integer status;
	//备注
	private String remark;
	//优惠券有效期结束时间
	private Date endTime;
	//有效期的开始时间
	private Date startTime;
	//创建时间
	private Date createTime;
	//更新时间
	private Date updateTime;
	//使用范围  0：普通型 1 ：卡包类型
	private Integer useRange;
	//有效期
	private Integer aging;
	//链接地址
	private String url;

	/**
	 * 设置：优惠劵编号
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}
	/**
	 * 获取：优惠劵编号
	 */
	public String getCid() {
		return cid;
	}
	/**
	 * 设置：优惠券名字
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：优惠券名字
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：代金券描述
	 */
	public void setInfo(String info) {
		this.info = info;
	}
	/**
	 * 获取：代金券描述
	 */
	public String getInfo() {
		return info;
	}
	/**
	 * 设置：优惠券类型 1:好玩券 2：好物券  99：通用券
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：优惠券类型 1:好玩券 2：好物券  99：通用券
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：优惠券使用提示信息
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	/**
	 * 获取：优惠券使用提示信息
	 */
	public String getMsg() {
		return msg;
	}
	/**
	 * 设置：优惠券面额
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * 获取：优惠券面额
	 */
	public BigDecimal getPrice() {
		return price;
	}
	/**
	 * 设置：生成总张数
	 */
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	/**
	 * 获取：生成总张数
	 */
	public Integer getStock() {
		return stock;
	}
	/**
	 * 设置：剩余数
	 */
	public void setRemaining(Integer remaining) {
		this.remaining = remaining;
	}
	/**
	 * 获取：剩余数
	 */
	public Integer getRemaining() {
		return remaining;
	}
	/**
	 * 设置：状态 0 无效 10：有效
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态 0 无效 10：有效
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：优惠券有效期结束时间
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	/**
	 * 获取：优惠券有效期结束时间
	 */
	public Date getEndTime() {
		return endTime;
	}
	/**
	 * 设置：有效期的开始时间
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	/**
	 * 获取：有效期的开始时间
	 */
	public Date getStartTime() {
		return startTime;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：使用范围  0：普通型 1 ：卡包类型
	 */
	public void setUseRange(Integer useRange) {
		this.useRange = useRange;
	}
	/**
	 * 获取：使用范围  0：普通型 1 ：卡包类型
	 */
	public Integer getUseRange() {
		return useRange;
	}
	/**
	 * 设置：有效期
	 */
	public void setAging(Integer aging) {
		this.aging = aging;
	}
	/**
	 * 获取：有效期
	 */
	public Integer getAging() {
		return aging;
	}
	/**
	 * 设置：链接地址
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取：链接地址
	 */
	public String getUrl() {
		return url;
	}
}
