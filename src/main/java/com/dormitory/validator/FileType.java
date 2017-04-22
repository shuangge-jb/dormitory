package com.dormitory.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.RetentionPolicy;

@Documented
@Constraint(validatedBy = { FileTypeValidator.class })
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface FileType {
	String message() default "file type illegal.";
	// 下面这两个属性必须添加
	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
