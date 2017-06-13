package Util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class dbInfo {
	private static String dbdriver;
	private static String url;
	private static String user;
	private static String password;
	
	static{		
		Properties prop = new Properties();		
		try {
			String path = dbInfo.class.getResource("/").toURI().getPath() + "db.properties";
			prop.load(new FileInputStream(new File(path)));
			dbdriver = prop.getProperty("dbdriver");
			url = prop.getProperty("url");
			user = prop.getProperty("user");
			password = prop.getProperty("password");
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	public static String getDbdriver() {
		return dbdriver;
	}

	public static String getUrl() {
		return url;
	}

	public static String getUser() {
		return user;
	}

	public static String getPassword() {
		return password;
	}
}
