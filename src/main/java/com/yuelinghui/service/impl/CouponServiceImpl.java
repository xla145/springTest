package com.yuelinghui.service.impl;

import cn.assist.easydao.common.Conditions;
import cn.assist.easydao.common.Sort;
import cn.assist.easydao.common.SqlSort;
import cn.assist.easydao.dao.BaseDao;
import cn.assist.easydao.pojo.PagePojo;
import com.yuelinghui.base.helper.RecordBean;
import com.yuelinghui.service.CouponService;
import com.yuelinghui.service.vo.Coupon;
import org.springframework.stereotype.Service;

import java.util.Map;



//@Service("couponService")
public class CouponServiceImpl implements CouponService {

	@Override
	public Coupon getCoupon(String cid){
		return BaseDao.dao.queryForEntity(Coupon.class,cid);
	}

    @Override
    public PagePojo<Coupon> getCouponPage(Map<String, Object> params){
	    Integer pageNo = (Integer) params.get("pageNo");
	    Integer pageSize = (Integer) params.get("pageSize");
        // 具体自己去实现
        Sort sort = new Sort("create_time", SqlSort.DESC);
        Conditions con = new Conditions();
        return BaseDao.dao.queryForListPage(Coupon.class,con,sort,pageNo,pageSize);
	}

    @Override
    public RecordBean<Coupon> add(Coupon coupon){
        return RecordBean.success("OK");
	}

    @Override
    public RecordBean<Coupon> edit(Coupon coupon){
        return RecordBean.success("OK");
	}

    @Override
    public RecordBean<String> del(String cid){
        return RecordBean.success("OK");
	}

    @Override
    public RecordBean<String> delBatch(String[] cids){
        return RecordBean.success("OK");
	}

}
