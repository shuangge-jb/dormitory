package com.dormitory.service.dto;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.dormitory.entity.Dormitory;
import com.dormitory.entity.Student;

public class RegisterDTO extends Student{
	@Valid
	private Dormitory dormitory=new Dormitory();
	@NotNull
	@NotEmpty
	@NotBlank
	private String password2;
	public Dormitory getDormitory() {
		return dormitory;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public void setDormitory(Dormitory dormitory) {
		this.dormitory = dormitory;
	}

	public String getBuilding() {
		return dormitory.getBuilding();
	}

	public void setBuilding(String building) {
		dormitory.setBuilding(building.trim());
	}

	public String getRoom() {
		return dormitory.getRoom();
	}

	public void setRoom(String room) {
		dormitory.setRoom(room.trim());
	}

	public RegisterDTO() {
		
	}

	@Override
	public String toString() {
		return "RegisterDTO [dormitory=" + dormitory + ", password2=" + password2 + ", studentId=" + studentId
				+ ", dormitoryId=" + dormitoryId + ", bedId=" + bedId + ", name=" + name + ", phoneNumber="
				+ phoneNumber + ", email=" + email + ", password=" + password + "]";
	}

}
