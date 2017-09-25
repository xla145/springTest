package com.yuelinghui.service.product.impl;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import cn.assist.easydao.dao.BaseDao;
import com.yuelinghui.base.constant.ProductActivityConstant;
import com.yuelinghui.base.constant.ProductConstant;
import com.yuelinghui.base.constant.ProductGroupConstant;
import com.yuelinghui.service.product.IActivityService;
import com.yuelinghui.service.vo.ProductActivity;

/**
 * 
 * 产品-->活动
 *
 * @author caixb
 */
@Service("IActivityService")
public class ActivityServiceImpl implements IActivityService{

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * 活动状态前进
	 * 
	 */
	public void activityForward(){
		applyStart();
		activityStart();
		activityEnd();
	}
	
	
	
	
	//0 --->10
	private void applyStart(){
		List<ProductActivity> list = this.getApplyStart(10);
		if(list == null || list.size() < 0){
			return ;
		}
		for (ProductActivity pa : list) {
			String pid = pa.getPid();
			String sql = "update `product_activity` set `activity_status` = ? where `pid` = ? and `activity_status` = ?";
			int result = BaseDao.dao.update(sql, ProductActivityConstant.ACTIVITY_STATUS_ENROLL, pid, ProductActivityConstant.ACTIVITY_STATUS_INITIAL);
			logger.info("[活动商品到期，系统更新 product_activity 为报名中]-[" + pid + "]-[result:"+result+"]");
		}
	}
	
	//10--->20
	private void activityStart(){
		List<ProductActivity> list = this.getActivityStart(10);
		if(list == null || list.size() < 0){
			return ;
		}
		for (ProductActivity pa : list) {
			String pid = pa.getPid();
			String sql = "update `product_activity` set `activity_status` = ? where `pid` = ? and `activity_status` = ?";
			int result = BaseDao.dao.update(sql, ProductActivityConstant.ACTIVITY_STATUS_UNDERWAY, pid, ProductActivityConstant.ACTIVITY_STATUS_ENROLL);
			logger.info("[活动商品到期，系统更新 product_activity 为进行中]-[" + pid + "]-[result:"+result+"]");
		}
	}
	
	//20--->30
	private void activityEnd(){
		List<ProductActivity> list = this.getActivityEnd(10);
		if(list == null || list.size() < 0){
			return ;
		}
		for (ProductActivity pa : list) {
			String pid = pa.getPid();
			int result = BaseDao.dao.update("update `product` set `status` = ? where `pid` = ? and `status` = ?", ProductConstant.PRODUCT_STATUS_SELLOUT, pid, ProductConstant.PRODUCT_STATUS_ONOFFER);
			logger.info("[活动商品到期，系统更新 product 为下架]-[" + pid + "]-[result:"+result+"]");
			
			String sql = "update `product_activity` set `activity_status` = ? where `pid` = ? and `activity_status` = ?";
			result = BaseDao.dao.update(sql, ProductActivityConstant.ACTIVITY_STATUS_FINISH, pid, ProductActivityConstant.ACTIVITY_STATUS_UNDERWAY);
			logger.info("[活动商品到期，系统更新 product_activity 为已结束]-[" + pid + "]-[result:"+result+"]");
		}
	}
	
	/**
	 * 查询需要变更为开始报名中的商品列表
	 * 
	 * @param count
	 * @return
	 */
	private List<ProductActivity> getApplyStart(int count){
		StringBuffer sql = new StringBuffer("select ");
		sql.append("p.pid");
		sql.append(",p.status");

		sql.append(",pa.pid as ppid");
		sql.append(",pa.activity_status");
		
		sql.append(",pa.apply_start_time");
		sql.append(",pa.apply_end_time");
		
		sql.append(",pa.activity_start_time");
		sql.append(",pa.activity_end_time");
		
		sql.append(" from `product` as p inner join `product_activity` as pa");
		sql.append(" on p.pid = pa.pid");
		sql.append(" where p.product_group_type = ? and p.status = ?");
		sql.append(" and pa.activity_status = ?");
		sql.append(" and pa.apply_start_time < now()");
		sql.append(" limit ?");
		
		return BaseDao.dao.queryForListEntity(ProductActivity.class, sql.toString(), ProductGroupConstant.PRODUCT_TYPE_GROUP_ACTIVITY, ProductConstant.PRODUCT_STATUS_ONOFFER, ProductActivityConstant.ACTIVITY_STATUS_INITIAL, count);
	}
	
	/**
	 * 查询需要变更为活动进行中的商品列表
	 * 
	 * @param count
	 * @return
	 */
	private List<ProductActivity> getActivityStart(int count){
		StringBuffer sql = new StringBuffer("select ");
		sql.append("p.pid");
		sql.append(",p.status");

		sql.append(",pa.pid as ppid");
		sql.append(",pa.activity_status");
		
		sql.append(",pa.apply_start_time");
		sql.append(",pa.apply_end_time");
		
		sql.append(",pa.activity_start_time");
		sql.append(",pa.activity_end_time");
		
		sql.append(" from `product` as p inner join `product_activity` as pa");
		sql.append(" on p.pid = pa.pid");
		sql.append(" where p.product_group_type = ? and p.status = ?");
		sql.append(" and pa.activity_status <> ?");
		sql.append(" and pa.activity_status <> ?");
		sql.append(" and pa.activity_start_time < now()");
		sql.append(" limit ?");
		
		return BaseDao.dao.queryForListEntity(ProductActivity.class, sql.toString(), ProductGroupConstant.PRODUCT_TYPE_GROUP_ACTIVITY, ProductConstant.PRODUCT_STATUS_ONOFFER, ProductActivityConstant.ACTIVITY_STATUS_FINISH, ProductActivityConstant.ACTIVITY_STATUS_UNDERWAY, count);
	}
	
	/**
	 * 查询需要变更为活动结束的商品列表
	 * 
	 * @param count
	 * @return
	 */
	private List<ProductActivity> getActivityEnd(int count){
		StringBuffer sql = new StringBuffer("select ");
		sql.append("p.pid");
		sql.append(",p.status");

		sql.append(",pa.pid as ppid");
		sql.append(",pa.activity_status");
		
		sql.append(",pa.apply_start_time");
		sql.append(",pa.apply_end_time");
		
		sql.append(",pa.activity_start_time");
		sql.append(",pa.activity_end_time");
		
		sql.append(" from `product` as p inner join `product_activity` as pa");
		sql.append(" on p.pid = pa.pid");
		sql.append(" where p.product_group_type = ? and p.status = ?");
		sql.append(" and pa.activity_status <> ?");
		sql.append(" and pa.activity_end_time < now()");
		sql.append(" limit ?");
		
		return BaseDao.dao.queryForListEntity(ProductActivity.class, sql.toString(), ProductGroupConstant.PRODUCT_TYPE_GROUP_ACTIVITY, ProductConstant.PRODUCT_STATUS_ONOFFER, ProductActivityConstant.ACTIVITY_STATUS_FINISH, count);
	}
	
	
}
