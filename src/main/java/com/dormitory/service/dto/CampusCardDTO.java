package com.dormitory.service.dto;

import com.dormitory.entity.CampusCard;
import com.dormitory.entity.Student;

public class CampusCardDTO extends CampusCard{
	private String name;

	public CampusCardDTO() {
		super();
	}

	public void init(Student student, CampusCard campusCard) {
		this.name=student.getName();
		this.campusCardId=campusCard.getCampusCardId();
		this.cardBalance=campusCard.getCardBalance();
		this.hotwaterBalance=campusCard.getHotwaterBalance();
		this.studentId=student.getStudentId();
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CampusCardDTO [name=" + name + ", campusCardId=" + campusCardId
				+ ", studentId=" + studentId + ", cardBalance=" + cardBalance
				+ ", hotwaterBalance=" + hotwaterBalance + "]";
	}

	

}
