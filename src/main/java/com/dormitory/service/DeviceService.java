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
	public List<Device> listDevice(Integer pageIndex,Integer pageSize);
	public Integer getSize();
	
}
