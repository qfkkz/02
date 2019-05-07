package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/*
 * 读取配置文件
 */
//单例模式
public class ConfigManager {
	private static ConfigManager con;
	private Properties pro;

	private ConfigManager() {
		String file = "database.properties";
		InputStream is = ConfigManager.class.getClassLoader().getResourceAsStream(file);
		pro=new Properties();
		try {
			pro.load(is);
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static ConfigManager getInstance() {
		if (con == null) {
			con = new ConfigManager();
		}
		return con;
	}
	public String getString(String key) {
		return pro.getProperty(key);
	}

	public static void main(String[] args) {
		ConfigManager conn = ConfigManager.getInstance();
	System.out.println(conn.getString("jdbc_user"));
	}
}
