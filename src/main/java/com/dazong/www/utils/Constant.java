package com.dazong.www.utils;

public class Constant {

	public static String LOCKS_REDIS = "/locks/redis";
	public static String LOCKS_MYSQL = "/locks/task";

	//	property file related
	public static class ServerProperties{
		public static final String fileName    = "servers.properties";
	    public static final String ZK_HOSTS="zookeeper.zkhosts";
	    public static final String TOPIC="topology.topic";
	    public static final String ZK_ROOT="topology.zkroot";
	    public static final String ZK_PORT="zookeeper.zkPort";
	    public static final String ZK_SERVERS="zookeeper.zkServers";

	    public static final String REDIS_ADDR="redis.addr";
	    public static final String REDIS_PORT="redis.port";
	    public static final String REDIS_MAX_ACTIVE="redis.max_active";
	    public static final String REDIS_MAX_IDLE="redis.max_idle";
	    public static final String REDIS_MAX_WAIT="redis.max_wait";
	    public static final String REDIS_TIMEOUT="redis.timeouts";
	}
	public static class JdbcProperties{
		public static final String fileName="jdbc.properties";

		public static final String DRIVER="jdbc.driver";
		public static final String URL="jdbc.url";
		public static final String USERNAME="jdbc.username";
		public static final String PASSWORD="jdbc.password";


	}


}
