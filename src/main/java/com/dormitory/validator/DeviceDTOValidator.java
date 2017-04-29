package com.dormitory.validator;

import java.io.File;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.dormitory.dto.DeviceDTO;

public class DeviceDTOValidator implements Validator {

	public DeviceDTOValidator() {
		
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(DeviceDTO.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		System.out.println("ArticleDTOValidator validate");
//		ArticleDTO target=(ArticleDTO)obj;
//		System.out.println("target:"+target);
//		File file=target.getFile();
//		System.out.println("file:"+file);
//		String fileName=file.getName();
//		if(!fileName.endsWith(".obj")&&!fileName.endsWith(".dae")){
//			errors.rejectValue("file","article.file.name.illegal");
//		}

	}

}
