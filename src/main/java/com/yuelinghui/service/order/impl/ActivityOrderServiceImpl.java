package com.yuelinghui.service.order.impl;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import cn.assist.easydao.dao.BaseDao;

import com.yuelinghui.base.constant.OrderActivityConstant;
import com.yuelinghui.service.order.IActivityOrderService;
import com.yuelinghui.service.vo.OrderActivity;


/**
 * 活动订单
 * 
 *
 * @author caixb
 */
@Service("IActivityOrderService")
public class ActivityOrderServiceImpl implements IActivityOrderService{

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * 活动到期结束
	 */
	public void activityOrderExpireFinish(){
		List<OrderActivity> list = getExpireActivityOrder(20);
		if(list == null || list.size() < 1){
			return ;
		}
		for (OrderActivity orderActivity : list) {
			String orderId = orderActivity.getOrderId();
			String sql = "update `order_activity` set `order_activity_status` = ? where `order_id` = ? and `order_activity_status` = ?";
			int result = BaseDao.dao.update(sql, OrderActivityConstant.ORDER_STATUS_FINISHED, orderId, OrderActivityConstant.ORDER_STATUS_NOTSTART);
			logger.info("[活动订单到期，系统自动结束]-[" + orderId + "]-[result:"+result+"]");
		}
	}
	
	
	/**
	 * 查询已到期活动订单
	 * @param count
	 * @return
	 */
	List<OrderActivity> getExpireActivityOrder(int count){
		String sql = "select * from `order_activity` where `activity_end_time` < now() and `order_activity_status` = ? limit ?";
		return BaseDao.dao.queryForListEntity(OrderActivity.class, sql, OrderActivityConstant.ORDER_STATUS_NOTSTART, count);
	}
}
