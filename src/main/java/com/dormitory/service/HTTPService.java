package com.dormitory.service;

import java.util.Map;

public interface HTTPService {
	/**
	 * 发送请求，将返回的数据以JSON格式输出
	 * 
	 * @param url
	 *            服务的url
	 * @param paramater 参数名，参数值
	 *            键值对
	 * @return JSON格式的字符串
	 */
	String getData(String url, Map<String, String> paramater);
}
