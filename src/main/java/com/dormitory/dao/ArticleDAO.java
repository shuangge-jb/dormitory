package com.dormitory.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.dormitory.entity.Article;

public interface ArticleDAO {
	@Select("select * from article where article_id=#{articleId} ")
	@ResultMap("com.dormitory.mapper.ArticleMapper.article")
	public Article get(@Param("articleId") Long articleId);

	@Select("select LAST_INSERT_ID()")
	public Long getLastInsertId();

	@Insert(" insert into article(dormitory_id,user_id,name,type,state,path) "
			+ " values(#{dormitoryId},#{userId},#{name},#{type},#{state},#{path}) ")
	@Options(useGeneratedKeys = true, keyProperty = "articleId")
	public void save(Article article);

	@Update(" update article set dormitory_id=#{dormitory_id},user_id=#{user_id}, "
			+ " name=#{name},type=#{type},state=#{state},path=#{path} ")
	public void update(Article article);

	@Delete("delete from article where article_id=#{articleId}")
	public void remove(Article article);

	@Select(" select * from article where dormitory_id=#{dormitoryId}")
	@ResultMap("com.dormitory.mapper.ArticleMapper.article")
	public List<Article> listByDormitoryId(@Param("dormitoryId") Integer dormitoryId);
}
