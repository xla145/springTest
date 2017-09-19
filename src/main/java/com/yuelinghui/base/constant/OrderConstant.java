package com.yuelinghui.base.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 订单相关的常量
 * 
 *
 * @author caixb
 */
public class OrderConstant {

	/**订单未支付**/
	public static final int ORDER_PAY_STATUS_NOPAY = 0;
	
	/**订单已支付**/
	public static final int ORDER_PAY_STATUS_SUCCESS = 6;
	
	/**订单已取消支付**/
	//public static final int ORDER_PAY_STATUS_CANCELPAY = 10;
	
	
	
	public static Map<Integer, String> payStatusMap = new HashMap<Integer, String>();
	static{
		payStatusMap.put(ORDER_PAY_STATUS_NOPAY, "未支付");
		payStatusMap.put(ORDER_PAY_STATUS_SUCCESS, "已支付");
//		payStatusMap.put(ORDER_PAY_STATUS_CANCELPAY, "取消支付");
	}
	
	
	
	/**订单支付超时时间 分钟为单位， 最小超时时间为10分钟**/
	public static final int ORDER_PAY_TIMEOUT = 30;
	
	
}
