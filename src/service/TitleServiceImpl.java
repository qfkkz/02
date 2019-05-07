package service;

import java.util.List;

import dao.TitleDao;
import dao.TitleDaoImpl;
import pojo.Title;

public class TitleServiceImpl implements TitleService {
	TitleDao td = new TitleDaoImpl();

	@Override
	public List<Title> findAllList() {

		return td.getAllTitle();
	}

	@Override
	public Title findTitleById(Title t) {

		return td.getTitle(t.getId());
	}

	@Override
	public int addTitle(Title t) {
		// TODO Auto-generated method stub
		return td.addTitle(t);
	}

}
