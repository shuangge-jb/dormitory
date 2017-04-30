package com.dormitory.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public Map<String,Object> list(Integer pageIndex,Integer pageSize) {
		Map<String,Object> map=new HashMap<String,Object>(3);
		List<Postcard> list=postcardDAO.list(pageIndex,pageSize);
		return map;
	}

	@Override
	public List<Postcard> listLimit(Integer n) {
		return postcardDAO.listLimit(n);
	}

	@Override
	public Map<String,Object> listByStudentId(Long studentId,Integer pageIndex,Integer pageSize) {
		Map<String,Object> map=new HashMap<String,Object>(3);
		postcardDAO.listByStudentId(studentId,pageIndex,pageSize);
		return map;
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
