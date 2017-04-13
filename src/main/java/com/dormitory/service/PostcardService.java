package com.dormitory.service;

import java.util.List;

import com.dormitory.entity.Postcard;

public interface PostcardService {
	/**
	 * 按时间降序找出所有对象
	 * 
	 * @return
	 */
	public List<Postcard> listPostcard();

	/**
	 * 按时间降序找出前n个对象
	 * 
	 * @param n
	 * @return
	 */
	public List<Postcard> listPostcardLimit(Integer n);

	/**
	 * 找出该学生的所有postcard对象
	 * 
	 * @param studentId
	 * @return
	 */
	public List<Postcard> listPostcardByStudentId(Long studentId);

	/**
	 * 找出一个对象
	 * 
	 * @param postcardId
	 * @return
	 */
	public Postcard getPostcard(Integer postcardId);

	/**
	 * 找出最近插入的主键
	 * 
	 * @return
	 */
	public Integer getLastInsertId();

	/**
	 * 插入
	 * 
	 * @param postcard
	 */
	public Postcard savePostcard(Postcard postcard);

	/**
	 * 修改
	 * 
	 * @param postcard
	 */
	public Postcard updatePostcard(Postcard postcard);

	/**
	 * 删除
	 * 
	 * @param postcard
	 */
	public Postcard removePostcard(Postcard postcard);
}
