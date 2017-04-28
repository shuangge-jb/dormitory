package com.dormitory.dto.student;

import java.io.File;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.dormitory.entity.Student;

public class StudentDTO {

	@NotNull(message = "{student.studentId.null}")
	protected Long studentId;

	@Max(4)
	@Min(1)
	// @NotEmpty(message = "{student.bedId.null}")
	protected Integer bedId;

	@NotEmpty(message = "{user.name.null}")
	@Length(min = 2, max = 20, message = "{user.name.length.illegal}")
	@Pattern(regexp = "[a-zA-Z\u4e00-\u9fa5]{2,20}", message = "{user.name.illegal}")
	protected String name;
	@NotNull(message = "{user.phoneNumber.null}")
	// @Length(min = 11, max = 11, message =
	// "{user.phoneNumber.length.illegal}")
	// @Pattern(regexp =
	// "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$", message =
	// "{user.phoneNumber.illegal}")
	protected Long phoneNumber;
	@NotEmpty(message = "{user.email.null}")
	@Length(min = 5, max = 50, message = "{user.email.length.illegal}")
	@Email(message = "{user.email.illegal}")
	protected String email;
	@NotEmpty(message = "{user.password.null}")
	@Length(min = 5, max = 20, message = "{user.password.length.illegal}")
	@Pattern(regexp = "[a-zA-Z0-9]{6,20}", message = "{user.password.illegal}")
	protected String password;
	@NotNull(message = "doritory.buildingName.null")
	@NotEmpty
	@NotBlank
	@Pattern(regexp = "[cC]([1][0-7]|[1-9])", message = "dormitory.buildingName.illegal")
	protected String buildingName;
	@NotNull(message = "doritory.room.null")
	@NotEmpty
	@NotBlank
	@Pattern(regexp = "[1-7][0-5][0-9]", message = "dormitory.room.illegal")
	protected String room;
	@NotNull
	@NotEmpty
	@NotBlank
	private String password2;

	private String imgPath;

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public Integer getBedId() {
		return bedId;
	}

	public void setBedId(Integer bedId) {
		this.bedId = bedId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public StudentDTO() {

	}

	/**
	 * 创建student对象并返回，outDate和validateCode为null
	 * 
	 * @return
	 */
	public Student getStudent() {
		Student student = new Student();
		student.setStudentId(studentId);
		student.setBedId(bedId);
		student.setEmail(email);
		student.setName(name);
		student.setPassword(password);
		student.setPhoneNumber(phoneNumber);
		return student;
	}

	public void setStudent(Student student){
		this.studentId=student.getStudentId();
		this.bedId=student.getBedId();
		this.email=student.getEmail();
		this.name=student.getName();
		this.password=student.getPassword();
		this.phoneNumber=student.getPhoneNumber();
		this.imgPath=student.getImgPath();
	}

	@Override
	public String toString() {
		return "StudentDTO [studentId=" + studentId + ", bedId=" + bedId + ", name=" + name + ", phoneNumber="
				+ phoneNumber + ", email=" + email + ", password=" + password + ", buildingName=" + buildingName
				+ ", room=" + room + ", password2=" + password2 + ", imgPath=" + imgPath + "]";
	}
	

}
