package com.dormitory.service;

import java.util.List;

public interface ListByDormitoryIdService<T> {
public List<T> listByDormitoryId(Integer dormitoryId);
}
