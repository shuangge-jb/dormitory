package com.dormitory.entity;

import javax.persistence.Entity;

@Entity
public class Student {
    private Long studentId;

    private Integer dormitoryId;

    private Integer bedId;

    private String name;

    private Long phoneNumber;

    private String email;

    private String password;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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
        this.email = email == null ? null : email.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [getStudentId()=" + getStudentId()
				+ ", getDormitoryId()=" + getDormitoryId() + ", getBedId()="
				+ getBedId() + ", getName()=" + getName()
				+ ", getPhoneNumber()=" + getPhoneNumber() + ", getEmail()="
				+ getEmail() + ", getPassword()=" + getPassword() + "]";
	}
   
}