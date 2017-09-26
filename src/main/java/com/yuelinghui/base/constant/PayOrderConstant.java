package com.yuelinghui.base.constant;

/**
 * 支付单相关常量
 *
 * @author caixb
 */
public class PayOrderConstant {

	/********************************支付订单类型***********************************/
	/**支付单**/
	public static final int PAY_TYPE_BASIC = 1;
	/**差价单**/
	public static final int PAY_TYPE_REPLENISH = 2;

	
	
	/********************************支付订单方式***********************************/
	/**微信**/
	public static final int PAY_WAY_WX = 1;
	/**支付宝**/
	public static final int PAY_WAY_ALIPAY = 2;
	/**代金券**/
	public static final int PAY_WAY_DAIJQ = 3;
	/**网银**/
	public static final int PAY_WAY_CHINABANK = 4;
	/**银联转账**/
	public static final int PAY_WAY_UNIONPAY = 5;
	
	
	/********************************支付订单状态***********************************/
	/**支付单未支付**/
	public static final int PAY_ORDER_STATUS_NOPAY = 0;
	/**支付单支付成功**/
	public static final int PAY_ORDER_STATUS_SUCCESS = 10;
	/**支付单支付失败**/
	public static final int PAY_ORDER_STATUS_FAIL = 20;
	
	/********************************支付明细状态***********************************/
	/**未支付**/
	public static final int PAY_STATUS_NOPAY = 0;
	/**支付成功**/
	public static final int PAY_STATUS_SUCCESS = 10;
	/**支付失败**/
	public static final int PAY_STATUS_FAIL = 20;
	
	
}
