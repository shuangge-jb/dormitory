package com.dormitory.service.dto;

import com.dormitory.entity.Dormitory;
import com.dormitory.entity.Electricity;

public class ElectricityDTO {
	private String building;
	private String room;
	private Double restElectricity;
	private Double sumElectricity;
	private Double balance;

	public ElectricityDTO() {
		super();
	}

	public void init(Dormitory dormitory, Electricity electricity) {
		this.building = dormitory.getBuilding();
		this.room = dormitory.getRoom();
		this.restElectricity = electricity.getRestElectricity();
		this.sumElectricity = electricity.getSumElectricity();
		this.balance = electricity.getBalance();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ElectricityDTO [building=" + building + ", room=" + room
				+ ", restElectricity=" + restElectricity + ", sumElectricity="
				+ sumElectricity + ", balance=" + balance + "]";
	}

}
