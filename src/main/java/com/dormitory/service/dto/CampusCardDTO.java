package com.dormitory.service.dto;

import com.dormitory.entity.CampusCard;
import com.dormitory.entity.Student;

public class CampusCardDTO {
	private Integer campusCardId;
	private Long studentId;
	private String name;
	private Double cardBalance;
	private Double hotwaterBalance;

	public CampusCardDTO() {
		super();
	}

	public void init(Student student, CampusCard campusCard) {
		this.campusCardId = campusCard.getCampusCardId();
		this.studentId = student.getStudentId();
		this.name=student.getName();
		this.cardBalance = campusCard.getCardBalance();
		this.hotwaterBalance = campusCard.getHotwaterBalance();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CampusCardDTO [campusCardId=" + campusCardId + ", studentId="
				+ studentId + ", name=" + name + ", cardBalance=" + cardBalance
				+ ", hotwaterBalance=" + hotwaterBalance + "]";
	}

}
