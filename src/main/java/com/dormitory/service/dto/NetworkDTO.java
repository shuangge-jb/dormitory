package com.dormitory.service.dto;

import com.dormitory.entity.Network;
import com.dormitory.entity.Student;

public class NetworkDTO {
	private Long studentId;
	private String name;
	private String tariffPackage;
	private Integer money;

	public NetworkDTO() {
		super();
	}

	public void init(Student student, Network network) {
		this.studentId = student.getStudentId();
		this.name = student.getName();
		this.tariffPackage = network.getTariffPackage();
		this.money = network.getMoney();
	}

	/**
	 * @return the studentId
	 */
	public Long getStudentId() {
		return studentId;
	}

	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the tariffPackage
	 */
	public String getTariffPackage() {
		return tariffPackage;
	}

	/**
	 * @param tariffPackage the tariffPackage to set
	 */
	public void setTariffPackage(String tariffPackage) {
		this.tariffPackage = tariffPackage;
	}

	/**
	 * @return the money
	 */
	public Integer getMoney() {
		return money;
	}

	/**
	 * @param money the money to set
	 */
	public void setMoney(Integer money) {
		this.money = money;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "NetworkDTO [studentId=" + studentId + ", name=" + name
				+ ", tariffPackage=" + tariffPackage + ", money=" + money + "]";
	}

}
