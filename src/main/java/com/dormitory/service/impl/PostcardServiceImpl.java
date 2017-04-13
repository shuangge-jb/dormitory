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
	public List<Postcard> listPostcard() {
		return postcardDAO.listPostcard(null);
	}

	@Override
	public List<Postcard> listPostcardLimit(Integer n) {
		return postcardDAO.listPostcard(n);
	}

	@Override
	public List<Postcard> listPostcardByStudentId(Long studentId) {
		return postcardDAO.listPostcardByStudentId(studentId);
	}

	@Override
	public Postcard getPostcard(Integer postcardId) {
		return postcardDAO.getPostcard(postcardId);
	}

	@Override
	public Integer getLastInsertId() {
		return postcardDAO.getLastInsertId();
	}

	@Transactional
	@Override
	public Postcard savePostcard(Postcard postcard) {
		Postcard temp = postcardDAO.getPostcard(postcard.getPostcardId());
		if (temp == null) {
			postcardDAO.savePostcard(postcard);
		} else {
			postcardDAO.updatePostcard(postcard);
		}
		return postcard;
	}

	@Transactional
	@Override
	public Postcard updatePostcard(Postcard postcard) {
		postcardDAO.updatePostcard(postcard);
		return postcard;
	}

	@Transactional
	@Override
	public Postcard removePostcard(Postcard postcard) {
		postcardDAO.removePostcard(postcard.getPostcardId());
		return postcard;
	}

}
