package com.dormitory.dto.master;

import com.dormitory.entity.LostFound;

public class LostFoundDTO extends LostFound {
	private String publisher;

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "LostFoundDTO [publisher=" + publisher + ", lostFoundId=" + lostFoundId + ", studentId=" + studentId
				+ ", content=" + content + ", createTime=" + createTime + ", state=" + state + ", publisherId="
				+ publisherId + ", place=" + place + "]";
	}

}
