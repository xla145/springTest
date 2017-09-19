package com.yuelinghui.service.vo;
import java.util.Date;
import java.util.List;

import cn.assist.easydao.annotation.Id;
import cn.assist.easydao.annotation.Temporary;
import cn.assist.easydao.pojo.BasePojo;

/**
 * 支付单
 *
 * @author caixb
 */
public class PayOrder extends BasePojo{
	@Temporary
	private static final long serialVersionUID = 1L;
	
	@Id
	private String payOrderId;              //支付单id
	private String orderId;                 //支付订单id
	private Integer orderSellUid;			//收款者UID
	private Integer orderBuyUid;			//支付者UID
	private Date expireTime;         		//支付过期时间，过期需退款
	private Double totalAmount;        		//支付商品总金额（单价*数量）
	private Integer productGroupId;			//商品一级分类
	private String productName;				//商品名称
	private String productDetail;           //商品详情
	private Double productSinglePrice; 		//支付商品单价 
	private Integer productCount;     		//支付订单商品数量
	private Double payCash;       			//订单现金支付金额 
	private Double payNoncash;  			//订单非现金支付金额 
	private Integer payStatus;      		//支付单状态。0:未支付， 10:支付成功, 20:支付失败，30已退费
	private Date createTime;				//创建时间
	private Date updateTime;				//更新时间
	private String payRemark;				//支付备注
	
	@Temporary
	List<PayOrderDetail> payWay;			//支付单支付方式列表
	
	public String getPayOrderId() {
		return payOrderId;
	}
	public void setPayOrderId(String payOrderId) {
		this.payOrderId = payOrderId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Integer getOrderSellUid() {
		return orderSellUid;
	}
	public void setOrderSellUid(Integer orderSellUid) {
		this.orderSellUid = orderSellUid;
	}
	public Integer getOrderBuyUid() {
		return orderBuyUid;
	}
	public void setOrderBuyUid(Integer orderBuyUid) {
		this.orderBuyUid = orderBuyUid;
	}
	public Date getExpireTime() {
		return expireTime;
	}
	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Integer getProductGroupId() {
		return productGroupId;
	}
	public void setProductGroupId(Integer productGroupId) {
		this.productGroupId = productGroupId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDetail() {
		return productDetail;
	}
	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}
	public Double getProductSinglePrice() {
		return productSinglePrice;
	}
	public void setProductSinglePrice(Double productSinglePrice) {
		this.productSinglePrice = productSinglePrice;
	}
	public Integer getProductCount() {
		return productCount;
	}
	public void setProductCount(Integer productCount) {
		this.productCount = productCount;
	}
	public Double getPayCash() {
		return payCash;
	}
	public void setPayCash(Double payCash) {
		this.payCash = payCash;
	}
	public Double getPayNoncash() {
		return payNoncash;
	}
	public void setPayNoncash(Double payNoncash) {
		this.payNoncash = payNoncash;
	}
	public Integer getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
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
	public String getPayRemark() {
		return payRemark;
	}
	public void setPayRemark(String payRemark) {
		this.payRemark = payRemark;
	}
	public List<PayOrderDetail> getPayWay() {
		return payWay;
	}
	public void setPayWay(List<PayOrderDetail> payWay) {
		this.payWay = payWay;
	}
	@Override
	public String toString() {
		return "PayOrder [payOrderId=" + payOrderId + ", orderId=" + orderId
				+ ", orderSellUid=" + orderSellUid + ", orderBuyUid="
				+ orderBuyUid + ", expireTime=" + expireTime + ", totalAmount="
				+ totalAmount + ", productName=" + productName
				+ ", productDetail=" + productDetail + ", productSinglePrice="
				+ productSinglePrice + ", productCount=" + productCount
				+ ", payCash=" + payCash + ", payNoncash=" + payNoncash
				+ ", payStatus=" + payStatus + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + ", payRemark=" + payRemark
				+ ", payWay=" + payWay + "]";
	}

	
}
