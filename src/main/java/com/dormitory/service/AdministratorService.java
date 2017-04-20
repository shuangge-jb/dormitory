package com.dormitory.service;

import com.dormitory.entity.Administrator;

public interface AdministratorService
		extends GetService<Administrator, Integer>, SaveOrUpdateService<Administrator>, RemoveService<Administrator> {

}
