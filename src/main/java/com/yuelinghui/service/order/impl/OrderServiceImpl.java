package com.yuelinghui.service.order.impl;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import cn.assist.easydao.common.Conditions;
import cn.assist.easydao.common.SqlExpr;
import cn.assist.easydao.common.SqlJoin;
import cn.assist.easydao.dao.BaseDao;

import com.yuelinghui.base.constant.CouponConstant;
import com.yuelinghui.base.constant.OrderActivityConstant;
import com.yuelinghui.base.constant.OrderConstant;
import com.yuelinghui.base.constant.OrderGoodsConstant;
import com.yuelinghui.base.constant.PayOrderConstant;
import com.yuelinghui.base.constant.ProductGroupConstant;
import com.yuelinghui.service.order.IOrderService;
import com.yuelinghui.service.vo.MemberCoupon;
import com.yuelinghui.service.vo.Order;
import com.yuelinghui.service.vo.PayInfo;
import com.yuelinghui.service.vo.PayOrder;

/**
 * 
 * 订单服务接口
 *
 * @author caixb
 */
@Service("IOrderService")
public class OrderServiceImpl implements IOrderService{

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * 取消到期订单
	 */
	public void cancelExpireOrder(){
		List<Order> list = getExpireOrderList(10);
		String reason = "订单超时未支付，系统自动取消";
		if(list == null || list.size() < 1){
			return ;
		}
		for (Order order : list) {
			String orderId = order.getOrderId();
			int buyUid = order.getBuyUid();
			Date date = new Date();
			int productGroup = order.getProductGroupType();
			String pid = order.getPid();
			int buyCount = order.getBuyCount();
			int result = 0;
			
			//更新订单状态
			if(productGroup == ProductGroupConstant.PRODUCT_TYPE_GROUP_ACTIVITY){
				String sql = "update `order_activity` set `order_activity_status` = ?,`activity_cancel_reason` = ?, `order_cancel_time` = ? where `order_id` = ? and `order_activity_status` = ?";
				result = BaseDao.dao.update(sql, OrderActivityConstant.ORDER_STATUS_CANCEL, reason, date, orderId, OrderActivityConstant.ORDER_STATUS_INITIAL);
				logger.info("[超时未支付订单，系统自动取消]-[" + orderId + "]-[result:"+result+"]");
			}else if(productGroup == ProductGroupConstant.PRODUCT_TYPE_GROUP_GOODS){
				String sql = "update `order_goods` set `order_goods_status` = ?,`goods_cancel_reason` = ?, `order_cancel_time` = ? where `order_id` = ? and `order_goods_status` = ?";
				result = BaseDao.dao.update(sql, OrderGoodsConstant.ORDER_STATUS_CANCEL, reason, date, orderId, OrderGoodsConstant.ORDER_STATUS_INITIAL);
				logger.info("[超时未支付订单，系统自动取消]-[" + orderId + "]-[result:"+result+"]");
			}else{
				logger.info("[超时未支付订单，系统自动取消]-[失败， 未找到对应的订单]-[orderId:"+orderId+",productGroup"+productGroup + "]");
			}
			
			if(result == 1){
				//返回库存
				addStock(pid, buyCount);
				//取消支付单
				this.noPayCancel(buyUid, orderId, date, reason);
			}
		}
	}
	
	
	/**********************************************************************************************************************************************************/
	
	/**
	 * 未支付 取消支付单 
	 * 
	 * @param uid					uid
	 * @param orderId				订单id
	 * @param cancelTime			取消时间
	 * @param cancelReason			取消原因
	 * 
	 * @return
	 */
	public boolean noPayCancel(int uid, String orderId, Date cancelTime, String cancelReason){
		logger.info("[未支付 取消支付单]--[start]-->uid:" + uid + ",orderId:" + orderId + ",cancelReason:" + cancelReason + ",cancelTime:" + cancelTime);
		PayOrder payOrder = getPayOrderByOrderId(uid, orderId);
		if(payOrder == null){
			logger.warn("[未支付 取消支付单]--[支付单不存在]-->uid:" + uid + ",orderId:" + orderId + ",cancelReason:" + cancelReason + ",cancelTime:" + cancelTime);
			return false;
		}
		if(payOrder.getPayStatus() != PayOrderConstant.PAY_ORDER_STATUS_NOPAY){
			logger.warn("[未支付 取消支付单]--[支付单状态不对，无法取消]-->payStatus：" + payOrder.getPayStatus() + ",uid:" + uid + ",orderId:" + orderId + ",cancelReason:" + cancelReason + ",cancelTime:" + cancelTime);
			return false;
		}
		String payOrderId = payOrder.getPayOrderId();
		
		//更新支付单状态为取消
		String paySql = "update `pay_order` set `pay_status` = ?, `update_time` = ?, `pay_fail_msg` = ? where `pay_order_id` = ?";
		int result = BaseDao.dao.update(paySql, PayOrderConstant.PAY_ORDER_STATUS_FAIL, cancelTime, cancelReason, payOrderId);
		logger.warn("[未支付 取消支付单]--[更新支付单状态"+(result == 1)+"]-->payOrderId:" + payOrderId + ",uid:" + uid + ",orderId:" + orderId + ",cancelReason:" + cancelReason + ",cancelTime:" + cancelTime);
		
		if(result == 1){
			returnCoupon(uid, payOrderId, cancelTime, cancelReason+",退回代金券");
			return true; 
		}
		
		return false;
	}
	
	/**
	 * 退回支付代金券 
	 * 
	 * @param uid					用户uid
	 * @param orderId				订单id
	 * @param returnTime			时间
	 * @param reason				原因
	 * @return
	 */
	public void returnCoupon(int uid, String orderId, Date returnTime, String reason){
		List<PayInfo> list = this.getPaySuccessCoupon(orderId);
		if(list != null && list.size() > 0){
			for (PayInfo payInfo : list) {
				String mcid = payInfo.getMcid();
				String payId = payInfo.getPayId();
				
				//更新支付状态
				String sql = "update `pay_order_detail` set `status` = ?, `pay_fail_msg` = ?, `update_time` = ? where `pay_id` = ? and `mcid` = ? and `status` = ? ";
				int result = BaseDao.dao.update(sql, PayOrderConstant.PAY_STATUS_FAIL, reason, returnTime, payId, mcid, PayOrderConstant.PAY_STATUS_SUCCESS);
				logger.info("[未支付 取消支付单]--[退回代金券]-[更新支付状态"+(result == 1)+"]-->mcid：" + mcid + ",payId:"+ payId + ",uid:" + uid + ",orderId:" + orderId + ",cancelReason:" + reason + ",cancelTime:" + returnTime);
				
				//退回代金券
				if(result == 1){
					MemberCoupon memberCoupon = BaseDao.dao.queryForEntity(MemberCoupon.class, mcid);
					if(memberCoupon != null){
						int status = CouponConstant.COUPON_MEMBER_STATUS_UNUSED; //未使用
						if(memberCoupon.getEndTime().before(returnTime)){
							status = CouponConstant.COUPON_MEMBER_STATUS_EXPIRED; //已过期
						}
						String couponSql = "update `member_coupon` set `status` = ?, `remark` = ? where `mcid` = ? and `status` = ? ";
						result = BaseDao.dao.update(couponSql, status, reason, mcid, CouponConstant.COUPON_MEMBER_STATUS_USED); //已使用
						logger.info("[未支付 取消支付单]--[退回代金券"+(result==1)+"]-[退回状态："+status+"]-->mcid：" + mcid + ",payId:"+ payId +",uid:" + uid + ",orderId:" + orderId + ",cancelReason:" + reason + ",cancelTime:" + returnTime);
					}
				}
			}
		}
	}
	
	/**
	 * 获取到期订单（超时未支付订单）
	 * 
	 * @param count
	 * @return
	 */
	private List<Order> getExpireOrderList(int count){
		String sql = "SELECT a.* FROM `order` as a inner join `order_activity` as b on a.order_id = b.order_id WHERE a.pay_status = ? AND a.expire_time < NOW() and b.order_activity_status = ? limit ?";
		List<Order> list =  BaseDao.dao.queryForListEntity(Order.class, sql, OrderConstant.ORDER_PAY_STATUS_NOPAY, OrderActivityConstant.ORDER_STATUS_INITIAL, count);
		
		String sql2 = "SELECT a.* FROM `order` as a inner join `order_goods` as b on a.order_id = b.order_id WHERE a.pay_status = ? AND a.expire_time < NOW() and b.order_goods_status = ? limit ?";
		List<Order> list2 =  BaseDao.dao.queryForListEntity(Order.class, sql2, OrderConstant.ORDER_PAY_STATUS_NOPAY, OrderGoodsConstant.ORDER_STATUS_INITIAL, count);
		
		if(list == null){
			list = new ArrayList<Order>();
		}
		list.addAll(list2);
		return list;
	}
	
	/**
	 * 根据orderId获取支付单信息
	 * 
	 * @param orderId
	 * @return
	 */
	private PayOrder getPayOrderByOrderId(int uid, String orderId){
		Conditions conn = new Conditions("order_id", SqlExpr.EQUAL, orderId);
		conn.add(new Conditions("order_buy_uid", SqlExpr.EQUAL, uid), SqlJoin.AND);
		return BaseDao.dao.queryForEntity(PayOrder.class, conn);
	}
	
	/**
	 * 根据订单id查询支付成功的代金券
	 * 
	 * @param orderId
	 * @return
	 */
	public List<PayInfo> getPaySuccessCoupon(String orderId){
		StringBuffer sql = new StringBuffer("select");
		sql.append("  `pay_id`");
		sql.append(", `pay_order_id`");
		sql.append(", `order_id`");
		sql.append(", `pay_way`");
		sql.append(", `pay_type`");
		sql.append(", `pay_amount`");
		sql.append(", `create_time`");
		sql.append(", `update_time`");
		sql.append(", `status`");
		sql.append(", `pay_success_time`");
		sql.append(", `pay_fail_msg`");
		
		sql.append(" from `pay_order_detail`");
		sql.append(" where `order_id` = ? and `pay_way` = ? and  `status` = ?");
		
		return BaseDao.dao.queryForListEntity(PayInfo.class, sql.toString(), orderId, PayOrderConstant.PAY_WAY_DAIJQ, PayOrderConstant.PAY_STATUS_SUCCESS);
	}
	
	/**
	 * 添加返回库存 
	 * 
	 * @param pid 商品id
	 * @param count 扣减数
	 * @param count 数量
	 * @return
	 */
	public boolean addStock(String pid, int count){
		String sql = "update `product` set `stock` = `stock` + ? where `pid` = ? ";
		
		return BaseDao.dao.update(sql, count, pid) == 1;
	}
}
