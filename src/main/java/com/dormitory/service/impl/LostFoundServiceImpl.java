package com.dormitory.service.impl;

import java.util.List;

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
		return lostFoundDAO.list(pageIndex,pageSize);
	}

	@Override
	public List<LostFound> listLimit(Integer n) {
		return lostFoundDAO.listLimit(n);
	}

	@Override
	public List<LostFound> listByStudentId(Long studentId,Integer pageIndex,Integer pageSize) {
		return lostFoundDAO.listByStudentId(studentId,pageIndex,pageSize);
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

}
