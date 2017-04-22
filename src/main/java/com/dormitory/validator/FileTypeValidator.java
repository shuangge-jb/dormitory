package com.dormitory.validator;

import java.io.File;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.web.multipart.MultipartFile;


public class FileTypeValidator implements ConstraintValidator<FileType, File>{

	@Override
	public void initialize(FileType arg0) {
		
	}

	@Override
	public boolean isValid(File file, ConstraintValidatorContext context) {
		System.out.println("file:"+file);
		String name=file.getName();
		return name.endsWith(".obj")||name.endsWith(".dae");
	}

}
