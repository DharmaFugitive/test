package com.aowin.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.aowin.dao.INewsDao;
import com.aowin.model.News;
import com.aowin.model.Page;
import com.aowin.util.DBUtil;

public class NewsService {
	// 得到所有用户的数量
	public void getNewsNumber(Page page) throws Exception{
		SqlSession session = DBUtil.getSession();
		INewsDao newsDao = session.getMapper(INewsDao.class);
		int total = newsDao.getNewsNumber();
		int totalPage;
		if(total%page.getPageSize() == 0) {
			totalPage =total/page.getPageSize();
		}else {
			totalPage =total/page.getPageSize()+1; 
		}
		page.setTotalPage(totalPage);
	}
	
	// 得到分页所需用户信息
	public void getNewsPage(Page page) throws Exception{
		SqlSession session = DBUtil.getSession();
		INewsDao newsDao = session.getMapper(INewsDao.class);
		List<News> data = newsDao.getNewsPage(page);
		System.out.println(data);
		page.setData(data);
	}
	
	// 根据id获取新闻详情
	public News getNewsById(int id) throws Exception{
		SqlSession session = DBUtil.getSession();
		INewsDao newsDao = session.getMapper(INewsDao.class);
		News news = newsDao.getNewsById(id);
		return news;
	};
	
	
	// 根据id删除新闻数据
	public int delNewsById(int id) throws Exception{
		SqlSession session = DBUtil.getSession();
		INewsDao newsDao = session.getMapper(INewsDao.class);	
		int num = newsDao.delNewsById(id);
		session.commit();
		session.close();
		return num;
	};
	
	
	// 增加新闻数据
	public int addNews(News news) throws Exception{
		SqlSession session = DBUtil.getSession();
		INewsDao newsDao = session.getMapper(INewsDao.class);
		int num = newsDao.addNews(news);
		session.commit();
		session.close();
		return num;
	};
	
	// 修改新闻数据
	public int updateBySet(News news) throws Exception{
		SqlSession session = DBUtil.getSession();
		INewsDao newsDao = session.getMapper(INewsDao.class);
		int num = newsDao.updateBySet(news);
		session.commit();
		session.close();
		return num;
	}
	
	// 模糊查询新闻数据
	public List<News> getNewsByAnd(News news) throws Exception{
		SqlSession session = DBUtil.getSession();
		INewsDao newsDao = session.getMapper(INewsDao.class);
		List<News> news1 = newsDao.getNewsByAnd(news);
		session.commit();
		session.close();
		return news1;
	}
	public List<News> getNewsByOr(News news) throws Exception{
		SqlSession session = DBUtil.getSession();
		INewsDao newsDao = session.getMapper(INewsDao.class);
		List<News> news1 = newsDao.getNewsByOr(news);
		session.commit();
		session.close();
		return news1;
	}
}
