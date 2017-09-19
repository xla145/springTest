package com.yuelinghui.base.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;

/**
 * 获取 resources.properties 参数 
 *
 * @author caixb
 */
public class ConfigUtil {
	public static final String CONFIG_FILE_NAME = "resources.properties";
	public static Properties props = new Properties();

	static {
		try {
			InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(CONFIG_FILE_NAME);
			props.load(is);
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 读取配置文件
	 */
	public static void reload(){
	    try {
            InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(CONFIG_FILE_NAME);
            props.load(is);
            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	/**
	 * 获得配置的key
	 * @param key key-name
	 * @return
	 */
	public static String getValue(String key) {
		return props.getProperty(key);
	}
	
	/**
	 * 获得配置的key
	 * 
	 * @param key	key
	 * @param defaultVal  默认值
	 * @return
	 */
	public static String getValue(String key, String defaultVal) {
		String val = props.getProperty(key);
		if(StringUtils.isBlank(val)){
			return defaultVal;
		}
		return val;
	}
	
	/**
	 * 读取所有配置
	 * @return
	 */
	public static Properties getProps(){
	    return props;
	}
	
	/**
	 * 设置配置的key
	 * @param key key-name
	 * @param value key-value 
	 */
	public static void updateProperties(String key, String value) {
		props.setProperty(key, value);
	}
}
