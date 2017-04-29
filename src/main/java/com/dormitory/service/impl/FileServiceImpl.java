package com.dormitory.service.impl;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dormitory.service.FileService;

@Service
public class FileServiceImpl implements FileService {
	private static final String FILE_ERROR = "file upload error";
	private static final String FILE_SUCCESS = "file upload success";
	private static Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);

	@Override
	public String saveFile(HttpServletRequest request, String directory, MultipartFile file) {
		// 保存上传的图片
		String path = request.getSession().getServletContext().getRealPath("/") + directory;
		System.out.println("--path:" + path);
		String fileName = getEncryptedFileName(file);
		System.out.println("fileName:" + fileName);
		File targetFile = new File(path, fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		// 保存
		try {
			file.transferTo(targetFile);
		} catch (IllegalStateException e1) {
			if (logger.isDebugEnabled()) {
				logger.debug("IllegalStateException at saveArticle:", e1);
			}
			return FILE_ERROR;
		} catch (IOException e1) {
			if (logger.isDebugEnabled()) {
				logger.debug("IOException at saveArticle:", e1);
			}
			return FILE_ERROR;
		}
		if (logger.isDebugEnabled()) {
			logger.debug("成功上传文件.");
		}
		return FILE_SUCCESS;
	}

	@Override
	public String getFilePath(HttpServletRequest request, String directory, MultipartFile file) {
		String dirpath = request.getContextPath() + directory;
		String fileName = getEncryptedFileName(file);
		return dirpath + fileName;
	}

	/**
	 * 将文件名(不包括目录和文件类型)加上时间戳，再使用base64加密,后面加上文件类型
	 * 
	 * @param file
	 * @return
	 */
	private String getEncryptedFileName(MultipartFile file) {
		String originalFilename = file.getOriginalFilename();
		String fileType = getFileType(file);
		System.out.println("fileType:"+fileType);
		int lastIndex=originalFilename.lastIndexOf(fileType);
		System.out.println("lastIndex:"+lastIndex);
		// 文件名，不含目录和文件类型
		String fileName = originalFilename.substring(0,
				lastIndex);
		String timestamp = getTimestamp();
		// 文件名加上时间戳
		String fimeNameWithTimestamp = fileName + "_" + timestamp;
		// 加密后的文件名和文件类型,不含目录
		return base64(fimeNameWithTimestamp) + fileType;
	}

	/**
	 * 返回 .XXX 格式的文件类型
	 * 
	 * @param file
	 * @return
	 */
	private String getFileType(MultipartFile file) {
		String originalFilename = file.getOriginalFilename();
		System.out.println("originalFilename:"+originalFilename);
		int lastIndex=originalFilename.lastIndexOf(".");
		System.out.println("lastIndex:"+lastIndex);
		return originalFilename.substring(lastIndex, originalFilename.length());
	}

	private String getTimestamp() {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String timestamp = format.format(new Date());
		return timestamp;
	}

	private String base64(String fileName) {
		byte[] array = Base64.encodeBase64(fileName.getBytes());
		return new String(array);
	}
}
