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
	public List<LostFound> list() {
		return lostFoundDAO.list();
	}

	@Override
	public List<LostFound> listLimit(Integer n) {
		return lostFoundDAO.listLimit(n);
	}

	@Override
	public List<LostFound> listByStudentId(Long studentId) {
		return lostFoundDAO.listByStudentId(studentId);
	}

	@Transactional
	@Override
	public LostFound save(LostFound lostFound) {
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
	public LostFound update(LostFound lostFound) {
		lostFoundDAO.update(lostFound);
		return lostFound;
	}

	@Transactional
	@Override
	public LostFound remove(LostFound lostFound) {
		lostFoundDAO.remove(lostFound.getLostFoundId());
		return lostFound;
	}

}
