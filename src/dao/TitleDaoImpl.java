package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.Title;
import util.BaseDao;

public class TitleDaoImpl implements TitleDao {
	BaseDao bd = new BaseDao();

	@Override
	public List<Title> getAllTitle() {
		String sql = "select * from t_title";
		List<Title> list = new ArrayList<Title>();
		ResultSet rs = bd.excuteQuery(sql);
		try {
			while (rs.next()) {
				Title t = new Title();
				t.setId(rs.getInt("id"));
				t.setTitle(rs.getString("title"));
				list.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int addTitle(Title t) {
		String sql = "insert into t_title(title) values(?)";
		Object[] obj = { t.getTitle() };
		return bd.excuteUpdate(sql, obj);
	}

	@Override
	public Title getTitle(int id) {
		String sql = "select * from t_title where id=?";
		Object[] obj = { id };
		Title t = new Title();
		ResultSet rs = bd.excuteQuery(sql, obj);
		try {
			while (rs.next()) {
				t.setId(rs.getInt("id"));
				t.setTitle(rs.getString("title"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}

}
