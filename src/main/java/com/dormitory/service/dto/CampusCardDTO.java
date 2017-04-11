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

	/**
	 * @return the campusCardId
	 */
	public Integer getCampusCardId() {
		return campusCardId;
	}

	/**
	 * @param campusCardId the campusCardId to set
	 */
	public void setCampusCardId(Integer campusCardId) {
		this.campusCardId = campusCardId;
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
	 * @return the cardBalance
	 */
	public Double getCardBalance() {
		return cardBalance;
	}

	/**
	 * @param cardBalance the cardBalance to set
	 */
	public void setCardBalance(Double cardBalance) {
		this.cardBalance = cardBalance;
	}

	/**
	 * @return the hotwaterBalance
	 */
	public Double getHotwaterBalance() {
		return hotwaterBalance;
	}

	/**
	 * @param hotwaterBalance the hotwaterBalance to set
	 */
	public void setHotwaterBalance(Double hotwaterBalance) {
		this.hotwaterBalance = hotwaterBalance;
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