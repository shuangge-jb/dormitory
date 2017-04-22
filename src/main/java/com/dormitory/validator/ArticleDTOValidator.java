package com.dormitory.validator;

import java.io.File;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.dormitory.service.dto.ArticleDTO;

public class ArticleDTOValidator implements Validator {

	public ArticleDTOValidator() {
		
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(ArticleDTO.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ArticleDTO target=(ArticleDTO)obj;
		System.out.println("target:"+target);
		File file=target.getFile();
		System.out.println("file:"+file);
		String fileName=file.getName();
		if(!fileName.endsWith(".obj")&&!fileName.endsWith(".dae")){
			errors.rejectValue("file","article.file.name.illegal");
		}

	}

}
