package com.dormitory.service.impl;

import java.io.File;
import java.io.IOException;

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
	public String saveFile(MultipartFile file, String url) {
		String fileName = file.getOriginalFilename();
		System.out.println("fileName:" + fileName);
		File targetFile = new File(url, fileName);
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
		System.out.println("文件路径" + url);
		return FILE_SUCCESS;
	}

}
