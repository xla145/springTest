package com.yuelinghui.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.yuelinghui.base.config.GlobalConfig;
import com.yuelinghui.service.order.IGoodsOrderService;

/**
 * 商品订单状态变更任务
 * 
 * 订单超时未收货自动收货 [待收货---> 确认收货]
 *
 * @author caixb
 */
public class GoodsOrderStatusJob {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private IGoodsOrderService goodsOrderService;
	
	public void run(){
		
		if(GlobalConfig.dev){
			logger.info("============================>商品订单状态变更任务start...");
		}
		
		goodsOrderService.goodsOrderSuccess();
	}
}
