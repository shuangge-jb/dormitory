package com.dormitory.entity;

public class Student extends User {
	protected Long studentId;

	protected Integer dormitoryId;

	protected Integer bedId;

	public Student() {
		
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public Integer getDormitoryId() {
		return dormitoryId;
	}

	public void setDormitoryId(Integer dormitoryId) {
		this.dormitoryId = dormitoryId;
	}

	public Integer getBedId() {
		return bedId;
	}

	public void setBedId(Integer bedId) {
		this.bedId = bedId;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", studentId=").append(studentId);
		sb.append(", dormitoryId=").append(dormitoryId);
		sb.append(", bedId=").append(bedId);
		sb.append(", name=").append(name);
		sb.append(", phoneNumber=").append(phoneNumber);
		sb.append(", email=").append(email);
		sb.append(", password=").append(password);
		sb.append("]");
		return sb.toString();
	}

}
