package com.dormitory.service;

import java.util.Map;

public interface HTTPService {

	/** 
	 * 发送 GET 请求（HTTP），不带输入数据 
	 * @param url 
	 * @return 
	 */
	String doGet(String url);

	/** 
	 * 发送 GET 请求（HTTP），K-V形式 
	 * @param url 
	 * @param params 
	 * @return 
	 */
	String doGet(String url, Map<String, Object> params);

	/** 
	 * 发送 POST 请求（HTTP），不带输入数据 
	 * @param apiUrl 
	 * @return 
	 */
	String doPost(String apiUrl);

	/** 
	 * 发送 POST 请求（HTTP），K-V形式 
	 * @param apiUrl API接口URL 
	 * @param params 参数map 
	 * @return 
	 */
	String doPost(String apiUrl, Map<String, Object> params);

	/** 
	 * 发送 POST 请求（HTTP），JSON形式 
	 * @param apiUrl 
	 * @param json json对象 
	 * @return 
	 */
	String doPost(String apiUrl, Object json);

	/** 
	 * 发送 SSL POST 请求（HTTPS），K-V形式 
	 * @param apiUrl API接口URL 
	 * @param params 参数map 
	 * @return 
	 */
	String doPostSSL(String apiUrl, Map<String, Object> params);

	/** 
	 * 发送 SSL POST 请求（HTTPS），JSON形式 
	 * @param apiUrl API接口URL 
	 * @param json JSON对象 
	 * @return 
	 */
	String doPostSSL(String apiUrl, Object json);

}