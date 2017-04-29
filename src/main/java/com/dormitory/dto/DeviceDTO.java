package com.dormitory.dto;

import java.io.File;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.dormitory.validator.FileType;
import com.dormitory.entity.Device;

public class DeviceDTO extends Device {
	//@NotEmpty(message = "{article.file.null}")
	//@FileType(message="{article.file.type.illegal}")
	protected File file;

	public DeviceDTO() {
		// TODO Auto-generated constructor stub
	}

	public File getFile() {
		return file;
	}

	@Override
	public String toString() {
		return "ArticleDTO [file=" + file + ", deviceId=" + deviceId + ", dormitoryId=" + dormitoryId + ", studentId="
				+ studentId + ", name=" + name + ", type=" + type + ", state=" + state + ", path=" + path + "]";
	}

}
