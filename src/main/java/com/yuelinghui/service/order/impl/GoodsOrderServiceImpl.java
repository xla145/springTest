package com.yuelinghui.service.order.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import cn.assist.easydao.dao.BaseDao;

import com.yuelinghui.base.constant.OrderGoodsConstant;
import com.yuelinghui.service.order.IGoodsOrderService;
import com.yuelinghui.service.vo.OrderGoods;


/**
 * 商品订单
 * 
 *
 * @author caixb
 */
@Service("IGoodsOrderService")
public class GoodsOrderServiceImpl implements IGoodsOrderService{

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	
	/**
	 * 商品订单确认收货
	 */
	public void goodsOrderSuccess(){
		List<OrderGoods> list = getReceivingOrderList(20);
		if(list == null || list.size() < 1){
			return ;
		}
		for (OrderGoods orderGoods : list) {
			String orderId = orderGoods.getOrderId();
			String reason = "订单超时未确认收货， 系统自动确认收货,操作人：" + -1;
			String sql = "update `order_goods` set `order_goods_status` = ?,`order_success_time` = ?, `remark` = ? where `order_id` = ? and `order_goods_status` = ?";
			int result = BaseDao.dao.update(sql, OrderGoodsConstant.ORDER_STATUS_SUCCESS, new Date(), reason, orderId, OrderGoodsConstant.ORDER_STATUS_RECEIVING);
			logger.info("[超时未确认收货订单，系统自动确认收货]-[" + orderId + "]-[result:"+result+"]");
		}
	}
	
	/**
	 * 获取超时未确认收货订单
	 * 
	 * @param count
	 * @return
	 */
	private List<OrderGoods> getReceivingOrderList(int count){
		String sql = "SELECT * FROM `order_goods` WHERE `order_goods_status` = ? AND DATE_ADD(deliver_goods_time, INTERVAL 10 DAY) < NOW() limit ?";
		return BaseDao.dao.queryForListEntity(OrderGoods.class, sql, OrderGoodsConstant.ORDER_STATUS_RECEIVING, count);
	}
}
