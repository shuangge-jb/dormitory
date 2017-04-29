package com.dormitory.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
	/**
	 * 保存文件到服务器
	 * 
	 * @param request
	 *            用于获取realpath
	 * @param directory
	 *            格式：/dir/
	 * @param file
	 * @return
	 */
	public String saveFile(HttpServletRequest request, String directory, MultipartFile file);

	/**
	 * 返回文件的url，用于在页面展示
	 * 
	 * @param request
	 *            用于取出contectpath
	 * @param directory
	 *            格式：/dir/
	 * @param file
	 * @return
	 */
	public String getFilePath(HttpServletRequest request, String directory, MultipartFile file);
}
