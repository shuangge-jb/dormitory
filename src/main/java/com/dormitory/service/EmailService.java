package com.dormitory.service;

import java.util.Map;

import com.dormitory.entity.Student;

public interface EmailService {
	Map<String,String> sendEmail(Student student,String basePath);
	public Map<String,String> checkResetLink(String sid, Long id);
}
