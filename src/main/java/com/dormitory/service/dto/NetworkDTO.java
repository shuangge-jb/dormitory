package com.dormitory.service.dto;

import com.dormitory.entity.Network;
import com.dormitory.entity.Student;

public class NetworkDTO extends Network{
	private String name;
	

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
