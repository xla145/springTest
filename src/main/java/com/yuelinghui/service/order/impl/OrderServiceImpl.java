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

import com.yuelinghui.base.config.GlobalConfig;
import com.yuelinghui.base.constant.CouponConstant;
import com.yuelinghui.base.constant.OrderActivityConstant;
import com.yuelinghui.base.constant.OrderConstant;
import com.yuelinghui.base.constant.OrderGoodsConstant;
import com.yuelinghui.base.constant.PayOrderConstant;
import com.yuelinghui.base.constant.ProductGroupConstant;
import com.yuelinghui.service.order.IOrderService;
import com.yuelinghui.service.vo.MemberCouponPage;
import com.yuelinghui.service.vo.Order;
import com.yuelinghui.service.vo.PayOrder;
import com.yuelinghui.service.vo.PayOrderDetail;

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
		int operatorId = -1;
		String reason = "订单超时未支付，系统自动取消, 操作人：" + operatorId;
		if(list == null || list.size() < 1){
			return ;
		}
		for (Order order : list) {
			String orderId = order.getOrderId();
			int buyUid = order.getBuyUid();
			Date date = new Date();
			int productGroup = order.getProductGroupType();
			if(productGroup == ProductGroupConstant.PRODUCT_TYPE_GROUP_ACTIVITY){
				String sql = "update `order_activity` set `order_activity_status` = ?,`activity_cancel_reason` = ?, `order_cancel_time` = ? where `order_id` = ? and `order_activity_status` = ?";
				int result = BaseDao.dao.update(sql, OrderActivityConstant.ORDER_STATUS_CANCEL, reason, date, orderId, OrderActivityConstant.ORDER_STATUS_INITIAL);
				logger.info("[超时未支付订单，系统自动取消]-[" + orderId + "]-[result:"+result+"]");
				
				if(result == 1){
					this.noPayCancel(buyUid, orderId, date, reason);
				}
				
			}else if(productGroup == ProductGroupConstant.PRODUCT_TYPE_GROUP_GOODS){
				String sql = "update `order_goods` set `order_goods_status` = ?,`goods_cancel_reason` = ?, `order_cancel_time` = ? where `order_id` = ? and `order_goods_status` = ?";
				int result = BaseDao.dao.update(sql, OrderGoodsConstant.ORDER_STATUS_CANCEL, reason, date, orderId, OrderGoodsConstant.ORDER_STATUS_INITIAL);
				logger.info("[超时未支付订单，系统自动取消]-[" + orderId + "]-[result:"+result+"]");
				
				if(result == 1){
					this.noPayCancel(buyUid, orderId, date, reason);
				}
			}else{
				logger.info("[超时未支付订单，系统自动取消]-[失败， 未找到对应的订单]-[orderId:"+orderId+",productGroup"+productGroup + "]");
			}
		}
	}
	
	
	
	
	
	/**********************************************************************************************************************************************************/
	
	/**
	 * 取消到期订单-->未支付取消支付单 [退回代金券]
	 * 
	 * @param uid
	 * @param orderId
	 * @param cancelTime
	 * @param cancelReason
	 * @return
	 */
	private void noPayCancel(int uid, String orderId, Date cancelTime, String cancelReason){
		if(GlobalConfig.dev){
			logger.warn("[超时未支付订单，系统自动取消]-[未支付 取消支付单]--[start]-->uid:" + uid + ",orderId:" + orderId + ",cancelReason:" + cancelReason + ",cancelTime:" + cancelTime);
		}
		try {
			PayOrder payOrder = getPayOrderByOrderId(uid, orderId);
			if(payOrder == null){
				logger.warn("[超时未支付订单，系统自动取消]-[未支付 取消支付单]--[支付单不存在]-->uid:" + uid + ",orderId:" + orderId + ",cancelReason:" + cancelReason + ",cancelTime:" + cancelTime);
				return ;
			}
			
			if(payOrder.getPayStatus() != PayOrderConstant.PAY_ORDER_STATUS_NOPAY){
				logger.warn("[超时未支付订单，系统自动取消]-[未支付 取消支付单]--[支付单状态不对，无法取消]-->payStatus：" + payOrder.getPayStatus() + ",uid:" + uid + ",orderId:" + orderId + ",cancelReason:" + cancelReason + ",cancelTime:" + cancelTime);
				return ;
			}
			
			String payOrderId = payOrder.getPayOrderId();
			Conditions conn = new Conditions("pay_order_id", SqlExpr.EQUAL, payOrderId);
			conn.add(new Conditions("order_id", SqlExpr.EQUAL, orderId), SqlJoin.AND);
			conn.add(new Conditions("pay_type", SqlExpr.EQUAL, PayOrderConstant.PAY_TYPE_DAIJQ), SqlJoin.AND); // 代金券
			PayOrderDetail payOrderDetail = BaseDao.dao.queryForEntity(PayOrderDetail.class, conn); // 代金券现只能用一个
			if(payOrderDetail != null){
				//更新支付明细单状态为取消
				String sql = "update `pay_order_detail` set `status` = ?, `pay_fail_msg` = ?, `update_time` = ? where `pay_id` = ?";
				int result = BaseDao.dao.update(sql, PayOrderConstant.PAY_ORDER_STATUS_REFUND, cancelReason, cancelTime, payOrderDetail.getPayId());
				if(result != 1){
					logger.warn("[超时未支付订单，系统自动取消]-[未支付 取消支付单]--[更新代金券支付明细状态失败]-->payOrderId:" + payOrderId + ",payId：" + payOrderDetail.getPayId() + ",uid:" + uid + ",orderId:" + orderId + ",cancelReason:" + cancelReason + ",cancelTime:" + cancelTime);
					return ; 
				}
				
				//更新支付单状态为取消
				String paySql = "update `pay_order` set `pay_status` = ?, `update_time` = ?, `pay_remark` = ? where `pay_order_id` = ?";
				result = BaseDao.dao.update(paySql, PayOrderConstant.PAY_STATUS_REFUND, cancelTime, cancelReason, payOrderId);
				if(result != 1){
					logger.warn("[超时未支付订单，系统自动取消]-[未支付 取消支付单]--[更新支付单状态失败]-->payOrderId:" + payOrderId + ",payId：" + payOrderDetail.getPayId() + ",uid:" + uid + ",orderId:" + orderId + ",cancelReason:" + cancelReason + ",cancelTime:" + cancelTime);
					return ; 
				}
				
				//退回代金券
				String mcid = payOrderDetail.getMcid(); //代金券id
				MemberCouponPage memberCoupon = this.getMemberCoupon(mcid);
				if(memberCoupon != null){
					int status = CouponConstant.COUPON_MEMBER_STATUS_UNUSED; //未使用
					if(memberCoupon.getEndTime().before(cancelTime)){
						logger.warn("[超时未支付订单，系统自动取消]-[未支付 取消支付单]--[退回代金券-代金券已过期]-->mcid：" + mcid + ",uid:" + uid + ",orderId:" + orderId + ",cancelReason:" + cancelReason + ",cancelTime:" + cancelTime);
						status = CouponConstant.COUPON_MEMBER_STATUS_EXPIRED; //已过期
					}
					String couponSql = "update `member_coupon` set `status` = ?, `remark` = ? where `mcid` = ? and `status` = ? ";
					result = BaseDao.dao.update(couponSql, status, cancelReason, mcid, CouponConstant.COUPON_MEMBER_STATUS_USED); //已使用
					if(result != 1){
						logger.warn("[超时未支付订单，系统自动取消]-[未支付 取消支付单]--[退回代金券失败]-->mcid：" + mcid + ",uid:" + uid + ",orderId:" + orderId + ",cancelReason:" + cancelReason + ",cancelTime:" + cancelTime);
					}
				}
			}else{
				//更新支付单状态为取消
				String paySql = "update `pay_order` set `pay_status` = ?, `update_time` = ?, `pay_remark` = ? where `pay_order_id` = ?";
				int result = BaseDao.dao.update(paySql, PayOrderConstant.PAY_STATUS_REFUND, cancelTime, cancelReason, payOrderId);
				if(result != 1){
					logger.warn("[超时未支付订单，系统自动取消]-[未支付 取消支付单]--[更新支付单状态失败]-->payOrderId:" + payOrderId + ",uid:" + uid + ",orderId:" + orderId + ",cancelReason:" + cancelReason + ",cancelTime:" + cancelTime);
					return ; 
				}
				
			}
		} catch (Exception e) {
			logger.error("[超时未支付订单，系统自动取消]--[未支付 取消支付单异常]: ", e);
		}
	}
	public static void main(String[] args) {
		System.out.println(new Date().before(null));
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
	 * 根据mcid 查询代金券信息
	 * 
	 * @param mcid
	 * @return
	 */
	private MemberCouponPage getMemberCoupon(String mcid){
		StringBuffer sql = new StringBuffer("select ");
		sql.append("c.cid");
		sql.append(",c.name");
		sql.append(",c.info");
		sql.append(",c.type");
		sql.append(",c.msg");
		sql.append(",c.price");
		sql.append(",c.status");
		
		sql.append(",mc.mcid");
		sql.append(",mc.uid");
		sql.append(",mc.start_time");
		sql.append(",mc.end_time");
		sql.append(",mc.status as mc_status");
		
		sql.append(" from coupon as c inner join member_coupon as mc ");
		sql.append(" on c.cid = mc.coupon_cid ");
		sql.append(" where mc.mcid = ?");
		
		return BaseDao.dao.queryForEntity(MemberCouponPage.class, sql.toString(), mcid);
	}
	
}
