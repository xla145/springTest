package com.yuelinghui.service;

import com.yuelinghui.base.helper.RecordBean;
import com.yuelinghui.service.vo.Coupon;
import cn.assist.easydao.pojo.PagePojo;
import cn.assist.easydao.common.Conditions;
import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author XXXX
 * @email xxx@yuelinghui.com
 * @date 2018-06-25 14:27:28
 */
public interface CouponService {


	Coupon getCoupon(String cid);

    PagePojo<Coupon> getCouponPage(Map<String, Object> params);

    RecordBean<Coupon> add(Coupon coupon);

    RecordBean<Coupon> edit(Coupon coupon);

    RecordBean<String> del(String cid);

    RecordBean<String> delBatch(String[] cids);


}
