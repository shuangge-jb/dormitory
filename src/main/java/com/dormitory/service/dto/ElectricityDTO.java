package com.dormitory.service.dto;

import com.dormitory.entity.Dormitory;
import com.dormitory.entity.Electricity;

public class ElectricityDTO extends Electricity{
	private String building;
	private String room;
	
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

	/**
	 * @return the building
	 */
	public String getBuilding() {
		return building;
	}

	/**
	 * @param building the building to set
	 */
	public void setBuilding(String building) {
		this.building = building;
	}

	/**
	 * @return the room
	 */
	public String getRoom() {
		return room;
	}

	/**
	 * @param room the room to set
	 */
	public void setRoom(String room) {
		this.room = room;
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
