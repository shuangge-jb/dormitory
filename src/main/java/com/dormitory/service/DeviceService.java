package com.dormitory.service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.dormitory.entity.Device;
import com.dormitory.entity.Interface;

public interface DeviceService
		extends GetService<Device,Long>,SaveOrUpdateService<Device>, 
		 RemoveService<Device>
		{
	public List<Device> list(Integer pageIndex,Integer pageSize);
	public Long getSize();
	
	public List<Device> getByName(String deviceName);
}
