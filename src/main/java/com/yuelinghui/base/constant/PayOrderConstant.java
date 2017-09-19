package com.yuelinghui.base.constant;

/**
 * 支付单相关的常量
 * 
 *
 * @author caixb
 */
public class PayOrderConstant {

	/**微信**/
	public static final int PAY_TYPE_WX = 1;
	/**支付宝**/
	public static final int PAY_TYPE_ALIPAY = 2;
	/**代金券**/
	public static final int PAY_TYPE_DAIJQ = 3;
	
	/********************************支付订单***********************************/
	/**支付单未支付**/
	public static final int PAY_ORDER_STATUS_NOPAY = 0;
	/**支付单支付成功**/
	public static final int PAY_ORDER_STATUS_SUCCESS = 10;
	/**支付单支付失败**/
	public static final int PAY_ORDER_STATUS_FAIL = 20;
	/**支付单已退费**/
	public static final int PAY_ORDER_STATUS_REFUND = 30;
	
	/********************************支付详情***********************************/
	/**未支付**/
	public static final int PAY_STATUS_NOPAY = 0;
	/**支付成功**/
	public static final int PAY_STATUS_SUCCESS = 10;
	/**支付失败**/
	public static final int PAY_STATUS_FAIL = 20;
	/**已退费**/
	public static final int PAY_STATUS_REFUND = 30;
}
