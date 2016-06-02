package com.dazong.www.Constants;

public class Constant {

	public static String MYSQL_DRIVER="com.mysql.jdbc.Driver";
	public static String MYSQL_URL ="jdbc:mysql://172.16.10.231:3306/trademonitortest?useUnicode=true&characterEncoding=utf-8";
	public static String MYSQL_USERNAME="root";
	public static String MYSQL_PASSWORD="root";
	
	
	public static String LOCKS_SOURCE = "/locks/source";
	public static String ZK_HOST_PORT = "172.16.11.221:2181";

	public static final int defaultConnectTimeout = 1000 * 5;
	public static final int TASK_PERIOD_DAY = 1;


//	property file related
	public static class ServerProperties{
		public static final String  ZK_HOST_PORT   = "zookeeper.host.port";
		public static final String  ZK_SERVER   = "zookeeper.server";
		public static final String  ZK_PORT   = "zookeeper.port";
		public static final String REDIS_ADDR="redis.addr";
		public static final String REDIS_PORT="redis.port";
		public static final String REDIS_MAX_ACTIVE="redis.max_active";
		public static final String REDIS_MAX_IDLE="redis.max_idle";
		public static final String REDIS_MAX_WAIT="redis.max_wait";
		public static final String REDIS_TIMEOUT="redis.timeouts";

	}
}
