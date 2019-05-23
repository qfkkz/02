package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import pojo.Reply;
import pojo.Title;
import util.BaseDao;

public class ReplyDaoImpl implements ReplyDao {
	BaseDao lt = new BaseDao();

	@Override
	public List<Reply> getReplyListByTitleId(Title t) {
		String sql = "select * from t_reply where titleId=? order by time asc";
		Object[] obj = { t.getId() };
		List<Reply> list = new ArrayList<Reply>();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ResultSet rs = lt.excuteQuery(sql, obj);
		try {
			while (rs.next()) {
				Reply r = new Reply();
				r.setReplyId(rs.getInt("id"));
				r.setMsg(rs.getString("msg"));
				r.setTime(df.format(rs.getTimestamp("time")).toString());
				r.setTitleId(rs.getInt("titleId"));
				r.setAccount(rs.getString("account"));
				list.add(r);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int addReply(Reply reply) {

		String sql = "insert into t_reply(msg,time,titleId,account) values(?,?,?,?)";
		Object[] obj = { reply.getMsg(), reply.getTime(), reply.getTitleId(), reply.getAccount() };
		return lt.excuteUpdate(sql, obj);
	}

}
