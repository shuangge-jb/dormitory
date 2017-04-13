package com.dormitory.dao.sql;

import org.apache.ibatis.jdbc.SQL;

public class SQLProvider {
public String listPostcard(Integer n){
	String sql=new SQL(){{
		SELECT("*");
		FROM("postcard");
		ORDER_BY(" create_time desc ");
	}}.toString();
	sql+=(" limit "+n);
	return sql;
}
}
