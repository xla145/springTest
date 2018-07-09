package com.yuelinghui;


import com.yuelinghui.controller.CouponController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * 测试
 */
public class SpringMVCTest {


    MockMvc mockMvc;

    @Before
    public void setupMock() {
        CouponController couponController = new CouponController();
        mockMvc = MockMvcBuilders.standaloneSetup(couponController).build();
    }

    @Test
    public void test() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/coupon/coupon").param("type", "1")).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }
}
