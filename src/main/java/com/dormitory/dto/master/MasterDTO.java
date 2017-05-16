package com.dormitory.dto.master;

import java.sql.Timestamp;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.dormitory.entity.Master;

public class MasterDTO {

	protected Integer masterId;
	@NotEmpty(message = "{user.name.null}")
	@Length(min = 2, max = 20, message = "{user.name.length.illegal}")
	@Pattern(regexp = "[a-zA-Z\u4e00-\u9fa5]{2,20}", message = "{user.name.illegal}")
	protected String name;
	@NotNull(message = "{master.phoneNumber.null}")
	@Length(min = 11, max = 11, message = "{user.phoneNumber.length.illegal}")
	@Pattern(regexp = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$", message = "{master.phoneNumber.illegal}")
	protected String phoneNumber;
	
	protected String email;
	
	protected String password;
	@NotNull(message = "doritory.buildingName.null")
	@NotEmpty
	@NotBlank
	@Pattern(regexp = "[cC]([1][0-7]|[1-9])", message = "dormitory.buildingName.illegal")
	protected String buildingName;

	private String imgPath;
@NotNull
	private Long idCard;
	private Timestamp entryTime;

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public Integer getMasterId() {
		return masterId;
	}

	public void setMasterId(Integer masterId) {
		this.masterId = masterId;
	}

	public Long getIdCard() {
		return idCard;
	}

	public void setIdCard(Long idCard) {
		this.idCard = idCard;
	}

	public Timestamp getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(Timestamp entryTime) {
		this.entryTime = entryTime;
	}

	public Master getMaster() {
		Master master = new Master();
		master.setEmail(email);
		master.setImgPath(imgPath);
		master.setMasterId(masterId);
		master.setName(name);
		master.setPassword(password);
		master.setPhoneNumber(Long.valueOf(phoneNumber));
		master.setMasterId(masterId);
		master.setIdCard(idCard);
		master.setEntryTime(entryTime);
		return master;
	}

	public void setMaster(Master master) {
		this.email = master.getEmail();
		this.masterId = master.getMasterId();
		this.name = master.getName();
		this.password = master.getPassword();
		this.phoneNumber = String.valueOf(master.getPhoneNumber());
		this.masterId = master.getMasterId();
		this.setImgPath(master.getImgPath());
		this.setIdCard(master.getIdCard());
		this.setEntryTime(master.getEntryTime());
	}

	public MasterDTO() {

	}

	@Override
	public String toString() {
		return "MasterDTO [masterId=" + masterId + ", name=" + name + ", phoneNumber=" + phoneNumber + ", email="
				+ email + ", password=" + password + ", buildingName=" + buildingName + ", imgPath=" + imgPath
				+ ", idCard=" + idCard + ", entryTime=" + entryTime + "]";
	}

}
