package com.dormitory.service;

import java.util.List;

import com.dormitory.entity.LostFound;

public interface LostFoundService {
	/**
	 * 查找出所有对象，按时间降序
	 * 
	 * @return
	 */
	public List<LostFound> list();

	/**
	 * 按时间降序,查找出限定个数的对象，
	 * 
	 * @param n
	 * @return
	 */
	public List<LostFound> listLimit(Integer n);

	/**
	 * 找出该学生的所有遗失物品
	 * 
	 * @param studentId
	 * @return
	 */
	public List<LostFound> listByStudentId(Long studentId);


	/**
	 * 插入
	 * @param lostFound
	 * @return
	 */
	public LostFound save(LostFound lostFound);

	/**
	 * 修改
	 * @param lostFound 
	 * @return
	 */
	public LostFound update(LostFound lostFound);

	/**
	 * 删除
	 * @param lostFound 
	 * @return
	 */
	public LostFound remove(LostFound lostFound);

}
