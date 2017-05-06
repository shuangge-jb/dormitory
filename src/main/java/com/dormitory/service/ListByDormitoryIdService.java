package com.dormitory.service;

import java.util.List;
import java.util.Map;
@Deprecated
public interface ListByDormitoryIdService<T> {
public Map<String,Object> listByDormitoryId(Integer dormitoryId,Integer pageIndex,Integer pageSize);
}
