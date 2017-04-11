package com.dormitory.service.dto;

import com.dormitory.entity.Dormitory;
import com.dormitory.entity.Water;

public class WaterDTO extends Water{
	private String building;
	private String room;
	private Long readout;

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