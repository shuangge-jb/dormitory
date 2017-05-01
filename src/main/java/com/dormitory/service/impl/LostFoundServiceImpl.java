package com.dormitory.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.dormitory.dao.LostFoundDAO;
import com.dormitory.entity.LostFound;
import com.dormitory.service.LostFoundService;

@Service
public class LostFoundServiceImpl implements LostFoundService {
	@Resource
	private LostFoundDAO lostFoundDAO;

	@Override
	public List<LostFound> list(Integer pageIndex,Integer pageSize) {
		Integer start=(pageIndex-1)*pageSize;
		List<LostFound> list=lostFoundDAO.list(start,pageSize);
		
		return list;
	}

	@Override
	public List<LostFound> listLimit(Integer n) {
		return lostFoundDAO.listLimit(n);
	}

	@Override
	public List<LostFound> listByStudentId(Long studentId,Integer pageIndex,Integer pageSize) {
		Integer start=(pageIndex-1)*pageSize;
		List<LostFound> list=lostFoundDAO.list(start,pageSize);
		return list;
	}

	@Transactional
	@Override
	public LostFound saveOrUpdate(LostFound lostFound) {
		LostFound temp = lostFoundDAO.get(lostFound.getLostFoundId());
		if (temp == null) {
			lostFoundDAO.save(lostFound);
		} else {
			lostFoundDAO.update(lostFound);
		}
		return lostFound;
	}

	@Transactional
	@Override
	public LostFound remove(LostFound lostFound) {
		lostFoundDAO.remove(lostFound.getLostFoundId());
		return lostFound;
	}

	@Override
	public LostFound get(Integer lostFoundId) {
		return lostFoundDAO.get(lostFoundId);
	}

	@Override
	public Integer getLastInsertId() {
		return lostFoundDAO.getLastInsertId();
	}

	@Override
	public Integer getSize() {
		return lostFoundDAO.getSize();
	}

	@Override
	public Integer getSizeByStudentId(Long studentId) {
		return lostFoundDAO.getSizeByStudentId(studentId);
	}

}
