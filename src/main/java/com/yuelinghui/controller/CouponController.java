package com.yuelinghui.controller;

import cn.assist.easydao.pojo.PagePojo;
import com.alibaba.fastjson.JSONObject;
import com.yuelinghui.base.helper.RecordBean;
import com.yuelinghui.base.utils.JsonBean;
import com.yuelinghui.base.utils.Query;
import com.yuelinghui.service.CouponService;
import com.yuelinghui.service.vo.Coupon;
import org.apache.shiro.authc.Account;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanInstantiationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.servlet.http.Part;
import javax.validation.Valid;
import java.util.Map;


/**
 *
 * @author XXXX
 * @email xxx@yuelinghui.com
 * @date 2018-06-25 14:27:28
 */
@Controller
@RequestMapping("coupon")
public class CouponController {

//	@Autowired
//	private CouponService couponService;
//
    /**
     * 信息
     */
    @RequestMapping("/index")
    public String index(){
        return "modules/coupon/index";
    }
//
//
//	/**
//	 * 列表
//	 */
//	@RequestMapping("/list")
////	@RequiresPermissions("coupon:list")
//	@ResponseBody
//	public JSONObject list(@RequestParam Map<String, Object> params){
//		//查询列表数据
//        Query query = new Query(params);
//        PagePojo<Coupon> page = couponService.getCouponPage(query);
//		return JsonBean.success(page);
//	}
//
//
//	/**
//	 * 信息
//	 */
//	@RequestMapping("/info/{cid}")
////	@RequiresPermissions("coupon:info")
//	public String info(@PathVariable("cid") String cid , Model model){
//		Coupon coupon = couponService.getCoupon(cid);
//        model.addAttribute("data",coupon);
//		return "/_info";
//	}
//
//
//	/**
//	 * 信息
//	 */
//	@RequestMapping("/getView/{cid}")
////	@RequiresPermissions("coupon:getView")
//	public String getView(@PathVariable("cid") String cid , Model model){
//		Coupon coupon = couponService.getCoupon(cid);
//		model.addAttribute("data",coupon);
//		return "/_edit";
//	}
//
//	/**
//	 * 保存
//	 */
//	@RequestMapping("/add")
//	@ResponseBody
////	@RequiresPermissions("coupon:add")
//	public JSONObject save(@RequestBody Coupon coupon){
//        RecordBean<Coupon> result = couponService.add(coupon);
//        if (result.isSuccessCode()) {
//            return JsonBean.success(result.getMsg());
//        }
//        return JsonBean.error(result.getMsg());
//	}
//
//	/**
//	 * 修改
//	 */
//	@RequestMapping("/edit")
//	@ResponseBody
////	@RequiresPermissions("coupon:edit")
//	public JSONObject update(@RequestBody Coupon coupon){
//        RecordBean<Coupon> result = couponService.edit(coupon);
//		if (result.isSuccessCode()) {
//			return JsonBean.success(result.getMsg());
//		}
//		return JsonBean.error(result.getMsg());
//	}
//
//	/**
//	 * 删除
//	 */
//	@ResponseBody
//	@RequestMapping("/del")
////	@RequiresPermissions("coupon:del")
//	public JSONObject del(@RequestBody String[] cids){
//        RecordBean<String> result = couponService.delBatch(cids);
//		if (result.isSuccessCode()) {
//			return JsonBean.success(result.getMsg());
//		}
//		return JsonBean.error(result.getMsg());
//	}
//
//	/**
//	 * 删除
//	 */
//	@ResponseBody
//	@RequestMapping("/dels")
////	@RequiresPermissions("coupon:del")
//	public JSONObject dels(@RequestParam(name = "ids") Integer cids){
//		System.out.println(cids);
//		return JsonBean.success("ok",cids);
//	}


	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/del2")
//	@RequiresPermissions("coupon:del")
	public JSONObject del2(@RequestParam("ids") Integer cids){
		System.out.println(cids);
		return JsonBean.success("ok",cids);
	}


	/**
	 * 删除
	 */
	@RequestMapping("/coupon")
	@ResponseBody
//	@RequiresPermissions("coupon:del")
	public JSONObject coupon(Coupon coupon){
//		DataBinder
//		BeanInstantiationException
//		RequestMappingHandlerAdapter
		return JsonBean.success("",coupon);
	}


	/**
	 * 删除
	 */
	@RequestMapping(value = "/upload",method = RequestMethod.POST)
	@ResponseBody
	public JSONObject upload(@RequestPart("file") Part part){
		System.out.println(part.getSize());
		return JsonBean.success("",part);
	}


	/**
	 * 删除
	 */
	@RequestMapping(value = "/upload2",method = RequestMethod.POST)
	@ResponseBody
	public JSONObject upload1(@RequestParam("file") MultipartFile file){
		System.out.println(file.getSize());
		return JsonBean.success("",file);
	}

}
