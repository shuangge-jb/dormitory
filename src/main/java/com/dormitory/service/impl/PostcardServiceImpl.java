package com.dormitory.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.dormitory.dao.PostcardDAO;
import com.dormitory.dto.PostcardDTO;
import com.dormitory.entity.Postcard;
import com.dormitory.service.PostcardService;

@Service
public class PostcardServiceImpl implements PostcardService {
	@Resource
	private PostcardDAO postcardDAO;

	@Override
	public List<PostcardDTO> list(Integer pageIndex,Integer pageSize) {
		Integer start=(pageIndex-1)*pageSize;
		List<PostcardDTO> list=postcardDAO.list(start,pageSize);
		return list;
	}

	@Override
	public List<PostcardDTO> listLimit(Integer n) {
		return postcardDAO.listLimit(n);
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
	public void changeState(Integer postcardId) {
		postcardDAO.changeState(postcardId);
	}

	@Override
	public Integer getSize() {
		return postcardDAO.getSize();
	}


	@Override
	public List<PostcardDTO> listByBuildingId(Integer buildingId, Integer pageIndex, Integer pageSize) {
		Integer start=(pageIndex-1)*pageSize;
		return postcardDAO.listByBuildingId(buildingId, start, pageSize);
	}

	@Override
	public Integer getSizeByBuildingId(Integer buildingId) {
		return postcardDAO.getSizeByBuildingId(buildingId);
	}

	@Override
	public void remove(Integer postcardId) {
		postcardDAO.remove(postcardId);
	}

}
