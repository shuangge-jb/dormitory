package com.dormitory.service.dto;

import java.util.Date;

import com.dormitory.entity.Dormitory;
import com.dormitory.entity.Water;

public class WaterDTO {
	private String building;
	private String room;
	private Date prevTime;
	private Date thisTime;
	private Long readout;
	private Double price;

	public WaterDTO() {
		super();
	}

	public void init(Dormitory dormitory, Water water) {
		this.building = dormitory.getBuilding();
		this.room = dormitory.getRoom();
		this.readout = water.getThisReadout() - water.getPrevReadout();
		this.prevTime = water.getPrevTime();
		this.thisTime = water.getThisTime();
		this.price = water.getPrice();
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
	 * @return the prevTime
	 */
	public Date getPrevTime() {
		return prevTime;
	}

	/**
	 * @param prevTime the prevTime to set
	 */
	public void setPrevTime(Date prevTime) {
		this.prevTime = prevTime;
	}

	/**
	 * @return the thisTime
	 */
	public Date getThisTime() {
		return thisTime;
	}

	/**
	 * @param thisTime the thisTime to set
	 */
	public void setThisTime(Date thisTime) {
		this.thisTime = thisTime;
	}

	/**
	 * @return the readout
	 */
	public Long getReadout() {
		return readout;
	}

	/**
	 * @param readout the readout to set
	 */
	public void setReadout(Long readout) {
		this.readout = readout;
	}

	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "WaterDTO [building=" + building + ", room=" + room
				+ ", prevTime=" + prevTime + ", thisTime=" + thisTime
				+ ", readout=" + readout + ", price=" + price + "]";
	}
}