package com.dormitory.service;

import com.dormitory.entity.Article;

public interface ArticleService
		extends GetService<Article,Long>,SaveOrUpdateService<Article>, 
		 RemoveService<Article>,
		ListByDormitoryIdService<Article>{

}
