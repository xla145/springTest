package com.yuelinghui.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.yuelinghui.base.config.GlobalConfig;
import com.yuelinghui.service.product.IActivityService;

/**
 * 活动商品状态变更任务
 * 活动商品状态 [报名中---> 进行中 ---> 已结束]
 *
 * @author caixb
 */
public class ActivityStatusJob {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private IActivityService activityService;
	
	
	public void run(){
		if(GlobalConfig.dev){
			logger.info("============================>活动商品状态变更任务start...");
		}
		
		activityService.activityForward();
	}
}
