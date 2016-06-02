//package com.dazong.www.utils;
//
//import com.dazong.www.Constants.Constant;
//import org.apache.commons.dbcp.BasicDataSource;
//import org.apache.commons.dbcp.BasicDataSourceFactory;
//
//import java.sql.Connection;
//import java.util.Properties;
//
//public class JDBCUtil {
//
//	private static BasicDataSource dataSource = null;
//
//
//	public static void init() {
//
//		if (dataSource != null) {
//			try {
//				dataSource.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			dataSource = null;
//		}
//
//		try {
//			Properties p = new Properties();
//			p.setProperty("driverClassName", Constant.MYSQL_DRIVER);
//			p.setProperty("url", Constant.MYSQL_URL);
//			p.setProperty("password", Constant.MYSQL_USERNAME);
//			p.setProperty("username", Constant.MYSQL_PASSWORD);
//			p.setProperty("maxActive", "30");
//			p.setProperty("maxIdle", "10");
//			p.setProperty("maxWait", "1000");
//			p.setProperty("removeAbandoned", "true");
//			p.setProperty("removeAbandonedTimeout", "120");
//			p.setProperty("testOnBorrow", "true");
//			p.setProperty("logAbandoned", "true");
//
//			dataSource = (BasicDataSource) BasicDataSourceFactory.createDataSource(p);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//
//	public static synchronized Connection getConnection(boolean autoCommit) {
//		Connection conn = null;
//		try {
//			if (dataSource == null) {
//				init();
//			}
//
//			if (dataSource != null) {
//				conn = dataSource.getConnection();
//				conn.setAutoCommit(autoCommit);
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return conn;
//	}
//
//	public static Connection getConnectionByJDBC(boolean autoCommit) {
//		return getConnection(autoCommit);
//	}
//
//	public static Connection getConnectionByJDBC() {
//		return getConnectionByJDBC(true);
//	}
//
//
//	public static void main(String[] args){
//		System.out.println(getConnectionByJDBC());
//	}
//
//
//}
