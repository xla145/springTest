package com.yuelinghui.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yuelinghui.service.order.IActivityOrderService;
import com.yuelinghui.service.order.IGoodsOrderService;
import com.yuelinghui.service.order.IOrderService;
import com.yuelinghui.service.product.IActivityService;

/**
 * 首页
 *
 * @author caixb
 */
@Controller
public class IndexController{

	@Autowired
	private IActivityOrderService activityOrderService;
	@Autowired
	private IActivityService activityService;
	@Autowired
	private IOrderService orderService;
	@Autowired
	private IGoodsOrderService goodsOrderService;
	
	@RequestMapping("/index")
	public String index(RedirectAttributes ra, HttpServletRequest request, HttpServletResponse response){
		System.out.println("=================");
		
		
		return "/index";
	}
}
