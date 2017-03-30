package com.dormitory.entity;

import java.util.Date;

public class Water {
	private Integer dormitoryId;

	private Long prevReadout;

	private Date prevTime;

	private Long thisReadout;

	private Date thisTime;

	private Double price;

	public Integer getDormitoryId() {
		return dormitoryId;
	}

	public void setDormitoryId(Integer dormitoryId) {
		this.dormitoryId = dormitoryId;
	}

	public Long getPrevReadout() {
		return prevReadout;
	}

	public void setPrevReadout(Long prevReadout) {
		this.prevReadout = prevReadout;
	}

	public Date getPrevTime() {
		return prevTime;
	}

	public void setPrevTime(Date prevTime) {
		this.prevTime = prevTime;
	}

	public Long getThisReadout() {
		return thisReadout;
	}

	public void setThisReadout(Long thisReadout) {
		this.thisReadout = thisReadout;
	}

	public Date getThisTime() {
		return thisTime;
	}

	public void setThisTime(Date thisTime) {
		this.thisTime = thisTime;
	}

	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", dormitoryId=").append(dormitoryId);
		sb.append(", prevReadout=").append(prevReadout);
		sb.append(", prevTime=").append(prevTime);
		sb.append(", thisReadout=").append(thisReadout);
		sb.append(", thisTime=").append(thisTime);
		sb.append(", price=").append(price);
		sb.append("]");
		return sb.toString();
	}
}