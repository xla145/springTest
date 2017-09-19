package com.yuelinghui.job;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.yuelinghui.base.config.GlobalConfig;
import com.yuelinghui.service.order.IOrderService;


/**
 * 订单超时未支付， 取消订单
 * 
 * 订单状态 [未支付---> 已取消]
 * 支付单[未支付--->已退费]
 * 抵扣代金券 --->退回
 * 
 * @author caixb
 */
public class ExpireOrderCancelJob {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private IOrderService orderService;
	
	public void run(){
		if(GlobalConfig.dev){
			logger.info("============================>订单超时未支付， 取消订单start...");
		}
		
		orderService.cancelExpireOrder();
	}
}
