package com.yuelinghui.job;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.yuelinghui.base.config.GlobalConfig;
import com.yuelinghui.service.coupon.ICouponService;


/**
 * 过期代金券 标记为已过期
 * 
 * 过期的代金券 ----> 已过期
 * 
 * @author caixb
 */
public class ExpireCouponJob {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ICouponService couponService;
	
	public void run(){
		if(GlobalConfig.dev){
			logger.info("============================>过期代金券 标记为已过期 start...");
		}
		
		couponService.couponExpireInvalid();;
	}
}
