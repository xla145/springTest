package com.yuelinghui.service.vo;
import java.util.Date;

import cn.assist.easydao.annotation.Id;
import cn.assist.easydao.annotation.Temporary;
import cn.assist.easydao.pojo.BasePojo;

/**
 * 
 * 订单
 *
 * @author caixb
 */
public class Order extends BasePojo{

	@Temporary
	private static final long serialVersionUID = 1L;
	
	@Id
	private String orderId;				//订单id
	private String orderName;			//订单名称
	private Integer buyUid;				//买家uid
	private String buyMobile;			//买家手机号
	private Integer sellUid;			//卖家uid
	private Integer payStatus;			//支付状态 0：未支付   6：已支付   10 ：订单已取消支付
	private Integer isSmsNotice;		//支付成功是否短信通知0 不通知， 1：通知
	private String pid;					//商品id                                                 
	private String productImg;                       
	private int productGroupType;		//商品一级分类id
	private int catId;					//商品一级分类id
	private String productName;			//商品名称
	private String productInfo;			//商品详细信息
	private Double productPrice;		//商品售价
	private Double productOriginalPrice;//商品原价
	private Integer buyCount;			//购买数量
	private Double totalAmount;			//订单总额（售价*数量）
	private Date createTime;			//订单创建时间
	private Date updateTime;			//订单更新时间
	private Date expireTime;			//订单超时时间
	private Date finishTime;			//订单完成时间
	
	private String skuId;				//规格id
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public Integer getBuyUid() {
		return buyUid;
	}
	public void setBuyUid(Integer buyUid) {
		this.buyUid = buyUid;
	}
	public String getBuyMobile() {
		return buyMobile;
	}
	public void setBuyMobile(String buyMobile) {
		this.buyMobile = buyMobile;
	}
	public Integer getSellUid() {
		return sellUid;
	}
	public void setSellUid(Integer sellUid) {
		this.sellUid = sellUid;
	}
	public Integer getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}
	public Integer getIsSmsNotice() {
		return isSmsNotice;
	}
	public void setIsSmsNotice(Integer isSmsNotice) {
		this.isSmsNotice = isSmsNotice;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getProductImg() {
		return productImg;
	}
	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductInfo() {
		return productInfo;
	}
	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}
	public Double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	public Double getProductOriginalPrice() {
		return productOriginalPrice;
	}
	public void setProductOriginalPrice(Double productOriginalPrice) {
		this.productOriginalPrice = productOriginalPrice;
	}
	public Integer getBuyCount() {
		return buyCount;
	}
	public void setBuyCount(Integer buyCount) {
		this.buyCount = buyCount;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
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
	public Date getExpireTime() {
		return expireTime;
	}
	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}
	public Date getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}
	public int getProductGroupType() {
		return productGroupType;
	}
	public void setProductGroupType(int productGroupType) {
		this.productGroupType = productGroupType;
	}
	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}
	
	public String getSkuId() {
		return skuId;
	}
	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}
	@Override
	public String toString() {
		return "OrderPage [orderId=" + orderId + ", orderName=" + orderName
				+ ", buyUid=" + buyUid + ", buyMobile=" + buyMobile
				+ ", sellUid=" + sellUid + ", payStatus=" + payStatus
				+ ", isSmsNotice=" + isSmsNotice + ", pid=" + pid
				+ ", productImg=" + productImg + ", productGroupType="
				+ productGroupType + ", productName=" + productName
				+ ", productInfo=" + productInfo + ", productPrice="
				+ productPrice + ", productOriginalPrice="
				+ productOriginalPrice + ", buyCount=" + buyCount
				+ ", totalAmount=" + totalAmount + ",  createTime=" + createTime
				+ ", updateTime=" + updateTime + ", expireTime=" + expireTime
				+ ", finishTime=" + finishTime + "]";
	}

	
	
}
