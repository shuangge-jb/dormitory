package com.dormitory.validator;

import org.springframework.util.Assert;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.dormitory.dto.student.StudentRegisterDTO;

public class RegisterDTOValidator implements Validator {

	public RegisterDTOValidator() {

	}

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(StudentRegisterDTO.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		System.out.println("RegisterDTOValidator validate");
		StudentRegisterDTO dto = (StudentRegisterDTO) obj;
		ValidationUtils.rejectIfEmpty(errors, "bedId", "student.bedId.null");
		// Assert.isTrue(dto.getBedId() >= 1 && dto.getBedId() <= 4,
		// "student.bedId.illegal");
		if (!(dto.getBedId() >= 1 && dto.getBedId() <= 4)) {
			errors.rejectValue("bedId", "student.bedId.illegal");
		}
		// Assert.isTrue(dto.getBuilding().matches("[cC][1-9]|[1][0-7]"),
		// "{dormitory.building.illegal}");
//		if (!dto.getBuildingId().matches("[cC][1-9]|[1][0-7]")) {
//			errors.rejectValue("building", "dormitory.building.illegal");
//		}
		// Assert.isTrue(dto.getRoom().matches("[1-7][0-5][0-9]"),
		// "dormitory.room.illegal");
		if (!dto.getRoom().matches("[1-7][0-5][0-9]")) {
			errors.rejectValue("room", "dormitory.room.illegal");
		}
		// Assert.isTrue(dto.getName().matches("[a-zA-Z]{5,20}"),
		// "user.name.illegal");
		if (!dto.getName().matches("[a-zA-Z]{5,20}")) {
			errors.rejectValue("name", "user.name.illegal");
		}
		String password2 = dto.getPassword2();
		String correct = dto.getPassword();
		if (!password2.equals(correct)) {
			errors.rejectValue("password2", "user.password2.notequals");
		}
	}

}
