package com.aowin.dao;

import java.util.List;

import com.aowin.model.News;
import com.aowin.model.Page;

public interface INewsDao {
	// 得到所需页码的新闻
	public List<News> getNewsPage(Page page) throws Exception;
	
	// 得到所有新闻的条数
	public int getNewsNumber() throws Exception;
	
	// 根据id获取新闻数据
	public News getNewsById(int id) throws Exception;
	
	// 根据id删除新闻数据
	public int delNewsById(int id) throws Exception;
	
	// 增加新闻数据
	public int addNews(News news) throws Exception;
	
	// 修改新闻数据
	public int updateBySet(News news) throws Exception;
	
	// 模糊查询新闻数据
	public List<News> getNewsByAnd(News news) throws Exception;
	public List<News> getNewsByOr(News news) throws Exception;
}

