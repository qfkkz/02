package dao;

import java.util.List;

import pojo.Title;

public interface TitleDao {
	//获得帖子列表
	public List<Title> getAllTitle();

	// 获取指定ID的帖子
	public Title getTitle(int id);

	public int addTitle(Title t);
}
