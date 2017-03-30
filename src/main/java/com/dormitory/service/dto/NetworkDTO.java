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
