package com.dormitory.service;

import java.util.List;

import com.dormitory.entity.Postcard;

public interface PostcardService
		extends GetService<Postcard, Integer>, ListService<Postcard>, ListLimitService<Postcard>,
		ListByStudentIdService<Postcard>, SaveOrUpdateService<Postcard>, RemoveService<Postcard> {


}
