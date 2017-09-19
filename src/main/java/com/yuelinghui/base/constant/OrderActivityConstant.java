package com.yuelinghui.base.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 活动订单相关的常量
 * 
 *
 * @author caixb
 */
public class OrderActivityConstant {
	//活动订单状态 0：初始状态   10：待开始 12:已开始  15：已结束  20：已取消
	
	/**初始状态**/
	public static final int ORDER_STATUS_INITIAL = 0;
	
	/**待开始**/
	public static final int ORDER_STATUS_NOTSTART = 10;
	
	/**已结束**/
	public static final int ORDER_STATUS_FINISHED = 15;
	
	/**已取消  **/
	public static final int ORDER_STATUS_CANCEL = 20;
	
	
	public static Map<Integer, String> activityStatusMap = new HashMap<Integer, String>();
	static{
		activityStatusMap.put(ORDER_STATUS_INITIAL, "初始未支付");
		activityStatusMap.put(ORDER_STATUS_NOTSTART, "待开始");
		activityStatusMap.put(ORDER_STATUS_FINISHED, "已结束");
		activityStatusMap.put(ORDER_STATUS_CANCEL, "已取消");
	}
	
	
}
