package com.yuelinghui.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.yuelinghui.base.config.GlobalConfig;
import com.yuelinghui.service.order.IActivityOrderService;

/**
 * 活动订单状态变更任务
 * 订单状态 [待开始---> 已结束]
 *
 * @author caixb
 */
public class ActivityOrderStatusJob {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private IActivityOrderService activityOrderService;
	
	public void run(){
		if(GlobalConfig.dev){
			logger.info("============================>活动订单状态变更任务start...");
		}
		activityOrderService.activityOrderExpireFinish();
	}
	
}
