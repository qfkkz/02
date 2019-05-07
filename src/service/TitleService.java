package service;

import java.util.List;

import pojo.Title;

public interface TitleService {
	public List<Title> findAllList();

	public Title findTitleById(Title t);

	public int addTitle(Title t);
}
