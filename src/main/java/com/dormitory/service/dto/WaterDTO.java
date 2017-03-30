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