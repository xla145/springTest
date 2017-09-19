package com.yuelinghui.base.helper;

import java.io.IOException;

import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

/** 
 * @description 解决Date类型返回json格式为自定义格式 
 * @author aokunsang 
 * @date 2013-5-28 
 */  
public class JsonConverter extends FastJsonHttpMessageConverter {  
	  
    @Override  
    protected void writeInternal(Object obj, HttpOutputMessage outputMessage)  throws IOException, HttpMessageNotWritableException {  
        JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH";  
        JSON.toJSONString(obj, SerializerFeature.WriteDateUseDateFormat);  
        super.writeInternal(obj, outputMessage);  
  
    }  
  
}  