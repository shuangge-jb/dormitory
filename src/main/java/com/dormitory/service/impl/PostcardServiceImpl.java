package com.dormitory.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.dormitory.dao.PostcardDAO;
import com.dormitory.entity.Postcard;
import com.dormitory.service.PostcardService;

@Service
public class PostcardServiceImpl implements PostcardService {
	@Resource
	private PostcardDAO postcardDAO;

	@Override
	public List<Postcard> list() {
		return postcardDAO.list(null);
	}

	@Override
	public List<Postcard> listLimit(Integer n) {
		return postcardDAO.list(n);
	}

	@Override
	public List<Postcard> listByStudentId(Long studentId) {
		return postcardDAO.listByStudentId(studentId);
	}

	@Override
	public Postcard get(Integer postcardId) {
		return postcardDAO.get(postcardId);
	}

	@Override
	public Integer getLastInsertId() {
		return postcardDAO.getLastInsertId();
	}

	@Transactional
	@Override
	public Postcard saveOrUpdate(Postcard postcard) {
		Postcard temp = postcardDAO.get(postcard.getPostcardId());
		if (temp == null) {
			postcardDAO.save(postcard);
		} else {
			postcardDAO.update(postcard);
		}
		return postcard;
	}

	@Transactional
	@Override
	public Postcard remove(Postcard postcard) {
		postcardDAO.remove(postcard.getPostcardId());
		return postcard;
	}

}
