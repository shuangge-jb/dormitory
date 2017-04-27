package com.dormitory.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
public String saveFile(MultipartFile file, String url);
}
