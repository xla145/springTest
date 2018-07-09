/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.yuelinghui.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yuelinghui.base.utils.JsonBean;
import com.yuelinghui.service.SysGeneratorService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author xla
 */
@Controller
@RequestMapping("/sys/generator")
public class SysGeneratorController {
//    @Autowired
//    private SysGeneratorService sysGeneratorService;

//    /**
//     * 表数据页面
//     */
//    @RequestMapping("/index")
//    public String index(){
//         return "modules/generator/index";
//    }
//
//    @ResponseBody
//    @RequestMapping("/list")
//    public JSONObject list(@RequestParam Map<String, Object> params){
//        //查询列表数据
////        Query query = new Query(params);
//        List<Map<String, Object>> list = sysGeneratorService.queryList(params);
//        return JsonBean.success("page", list);
//    }
//
//
//
//    /**
//     * 生成代码
//     */
//    @RequestMapping("/code")
//    public void code(@RequestParam("tables") String tables, HttpServletResponse response) throws IOException {
//
//        String[] tableNames = new String[]{};
//        tableNames = JSON.parseArray(tables).toArray(tableNames);
//        byte[] data = sysGeneratorService.generatorCode(tableNames);
//        response.reset();
//        response.setHeader("Content-Disposition", "attachment; filename=\"yuelinghui-gen.zip\"");
//        response.addHeader("Content-Length", "" + data.length);
//        response.setContentType("application/octet-stream; charset=UTF-8");
//
//        IOUtils.write(data, response.getOutputStream());
//    }
}
