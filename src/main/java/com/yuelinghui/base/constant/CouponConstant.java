package com.yuelinghui.base.constant;

/**
 * 代金券相关
 *
 * @author caixb
 */
public class CouponConstant {

	/**代金券无效*/
	public static final int COUPON_STATUS_VALID = 0;
	
	/**代金券有效*/
	public static final int COUPON_STATUS_INVALID = 10;
	
	
	/**代金券 未使用*/
	public static final int COUPON_MEMBER_STATUS_UNUSED = 0;
	
	/**代金券 已使用*/
	public static final int COUPON_MEMBER_STATUS_USED = 10;
	
	/**代金券 已过期*/
	public static final int COUPON_MEMBER_STATUS_EXPIRED = 15;
	
	/**通用代金券*/
	public static final int COUPON_TYPE_GENERAL = 99;
	/**活动代金券*/
	public static final int COUPON_TYPE_HAOWAN = 1;
	/**代金券*/
	public static final int COUPON_TYPE_HAOWU = 2;
}
