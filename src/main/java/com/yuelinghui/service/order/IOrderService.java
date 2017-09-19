package com.yuelinghui.service.order;



/**
 * 
 * 订单服务接口
 *
 * @author caixb
 */
public interface IOrderService {

	/**
	 * 取消到期订单
	 */
	void cancelExpireOrder();
	
}
