package com.yuelinghui.base.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 商品订单相关的常量
 * 
 *
 * @author caixb
 */
public class OrderGoodsConstant {
	//	0：初始状态  5：待发货  10：待收货  15：已完成  20：已退款 25：已取消
	
	/**初始状态**/
	public static final int ORDER_STATUS_INITIAL = 0;
	
	/**待发货**/
	public static final int ORDER_STATUS_SENDGOODS = 5;
	
	/**待收货 **/
	public static final int ORDER_STATUS_RECEIVING = 10;
	
	/**已完成**/
	public static final int ORDER_STATUS_SUCCESS = 15;
	
	/**已退款**/
	public static final int ORDER_STATUS_REFUND = 20;
	
	/**已取消**/
	public static final int ORDER_STATUS_CANCEL = 25;
	
	
	public static Map<Integer, String> goodsStatusMap = new HashMap<Integer, String>();
	static{
		goodsStatusMap.put(ORDER_STATUS_INITIAL, "未支付");
		goodsStatusMap.put(ORDER_STATUS_SENDGOODS, "待发货");
		goodsStatusMap.put(ORDER_STATUS_RECEIVING, "待收货");
		goodsStatusMap.put(ORDER_STATUS_SUCCESS, "已完成");
		goodsStatusMap.put(ORDER_STATUS_REFUND, "已退款");
		goodsStatusMap.put(ORDER_STATUS_CANCEL, "已取消");
	}
	
}
