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

	/**
	 * @return the restElectricity
	 */
	public Double getRestElectricity() {
		return restElectricity;
	}

	/**
	 * @param restElectricity the restElectricity to set
	 */
	public void setRestElectricity(Double restElectricity) {
		this.restElectricity = restElectricity;
	}

	/**
	 * @return the sumElectricity
	 */
	public Double getSumElectricity() {
		return sumElectricity;
	}

	/**
	 * @param sumElectricity the sumElectricity to set
	 */
	public void setSumElectricity(Double sumElectricity) {
		this.sumElectricity = sumElectricity;
	}

	/**
	 * @return the balance
	 */
	public Double getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(Double balance) {
		this.balance = balance;
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
