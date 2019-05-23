package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


//1.增删改 2.查 3.释放连接 4.获取连接
public class BaseDao {
	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;

	// 获取连接
	public boolean getConnect() {
		try {
			Class.forName(ConfigManager.getInstance().getString("driver"));
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
			return false;
		}
		try {
			conn = DriverManager.getConnection(ConfigManager.getInstance().getString("url"),
					ConfigManager.getInstance().getString("username"),
					ConfigManager.getInstance().getString("password"));
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}

	public boolean getConnect2() {
		try {// 初始化上下文本对象
			Context cx = new InitialContext();
			// 获取数据源对象
			DataSource ds = (DataSource) cx.lookup("java:comp/env/jdbc/bookmanager");
			// 获取连接
			conn = ds.getConnection();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

// 释放资源
	public boolean closeResource() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pstm != null) {
			try {
				pstm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

//增删改
	public int excuteUpdate(String sql, Object[] obj) {
		int updateRows = 0;
		if (this.getConnect()) {
			try {
				pstm = conn.prepareStatement(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			for (int i = 0; i < obj.length; i++) {
				try {
					pstm.setObject(i + 1, obj[i]);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			try {
				updateRows = pstm.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return updateRows;
	}

	public ResultSet excuteQuery(String sql, Object[] obj) {
		if (this.getConnect()) {
			try {
				pstm = conn.prepareStatement(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			for (int i = 0; i < obj.length; i++) {
				try {
					pstm.setObject(i + 1, obj[i]);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			try {
				rs = pstm.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rs;
	}
	public ResultSet excuteQuery(String sql) {
		if (this.getConnect()) {
			try {
				pstm = conn.prepareStatement(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				rs = pstm.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rs;
	}

	public ResultSet excuteQuery2(String sql, Object[] obj) {
		if (this.getConnect2()) {
			try {
				pstm = conn.prepareStatement(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			for (int i = 0; i < obj.length; i++) {
				try {
					pstm.setObject(i + 1, obj[i]);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			try {
				rs = pstm.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rs;
	}
}
