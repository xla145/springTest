package com.yuelinghui.service.coupon.impl;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import cn.assist.easydao.dao.BaseDao;
import com.yuelinghui.base.constant.CouponConstant;
import com.yuelinghui.service.coupon.ICouponService;
import com.yuelinghui.service.vo.MemberCouponPage;

/**
 *	用户代金券相关 
 * 
 * @author caixb
 */
@Service("ICouponService")
public class CouponServiceImpl implements ICouponService{

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * 过期代金券作废
	 * 
	 */
	public void couponExpireInvalid(){
		List<MemberCouponPage> list = getExpireCoupon(20);
		if(list == null || list.size() < 1){
			return ;
		}
		for (MemberCouponPage mc : list) {
			String mcid = mc.getMcid();
			String sql = "update `member_coupon` set `status` = ? where `mcid` = ? and `status` = ?";
			int result = BaseDao.dao.update(sql, CouponConstant.COUPON_MEMBER_STATUS_EXPIRED, mcid, CouponConstant.COUPON_MEMBER_STATUS_UNUSED);
			logger.info("[用户代金券到期，系统自动作废]-[" + mcid + "]-[result:"+result+"]");
		}
		
	}
	
	
	/**
	 * 查询过期代金券
	 * @param count
	 * @return
	 */
	List<MemberCouponPage> getExpireCoupon(int count){
		String sql = "select * from `member_coupon` where `status` = ? and `end_time` < ? order by `end_time` desc limit ?";
		return BaseDao.dao.queryForListEntity(MemberCouponPage.class, sql, CouponConstant.COUPON_MEMBER_STATUS_UNUSED, new Date(), count);
	}
	
	
}
