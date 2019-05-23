package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import pojo.User;
import util.BaseDao;

public class UserDaoImpl implements UserDao {

	/**
	 * 
	 * @param user
	 * @param      查询用户名为accont+password的用户
	 * @return 用户的详细信息
	 */
	public User getUserByAccountAndPassword(User user) {
		BaseDao bd = new BaseDao();
		String sql = "select * from t_user where account=? and password=?";
		Object obj[] = { user.getAccount(), user.getPassword() };
		ResultSet rs = bd.excuteQuery(sql, obj);
		User u=new User();
		try {
			while (rs.next()) {
				u.setAccount(rs.getString("account"));
				u.setPassword(rs.getString("password"));
				u.setType(rs.getInt("type"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			bd.closeResource();
		}
		return u;
	}

	/**
	 * 
	 * @param user
	 * @param 添加user对象到数据库
	 * @return 影响的行数
	 */
	public int addUser(User user) {
		BaseDao bd = new BaseDao();
		String sql = "insert into t_user(account,password,type) values(?,?,?)";
		Object[] obj = { user.getAccount(), user.getPassword(), user.getType() };
		int i = bd.excuteUpdate(sql, obj);
		bd.closeResource();
		return i;
	}

}
