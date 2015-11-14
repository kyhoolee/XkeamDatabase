package com.xkeam.database.redis;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisPool {
	private static int redisIndex = 0;
	private static int redisPort = 10106;
	private static String redisAddress = "localhost";
	private static String redisPassword = null;
	
	public static final String REDIS_INDEX = "Index";
	public static final String REDIS_PORT = "Port";
	public static final String REDIS_PASS = "Password";
	public static final String REDIS_ADDRESS = "Address";
	
	
	public static final String CONFIG_PATH = "/database_config.properties";
	public static Properties properties = null;
	
	public static void loadProperties() {
		if(properties == null) {
			properties = new Properties();
			try {
				properties.load(RedisPool.class.getResourceAsStream(CONFIG_PATH));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static Map<String, JedisPool> jedisMap= new HashMap<String, JedisPool>();
	
	


	public synchronized static JedisPool getInstance(String name) {
		
		JedisPool instance = jedisMap.get(name);
		if (instance == null) {
			JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
			jedisPoolConfig.setMaxTotal(100);
			jedisPoolConfig.setMaxIdle(100);
			jedisPoolConfig.setMaxWaitMillis(10000);
			jedisPoolConfig.setMinIdle(10);
			jedisPoolConfig.setTimeBetweenEvictionRunsMillis(5000);
			jedisPoolConfig.setMinEvictableIdleTimeMillis(1000);
			
			RedisPool.loadProperties();
			
			instance = new JedisPool(
					jedisPoolConfig, 
					properties.getProperty(name + REDIS_ADDRESS, redisAddress),
					Integer.parseInt(properties.getProperty(name + REDIS_PORT, String.valueOf(redisPort))),
					10000  ,
					properties.getProperty(name + REDIS_PASS, redisPassword));
			
			jedisMap.put(name, instance);
		}
		
		return instance;
	}

	public synchronized static Jedis getJedis(String name) {
		Jedis jedis = RedisPool.getInstance(name).getResource();
		jedis.select(Integer.parseInt(properties.getProperty(name + REDIS_INDEX, String.valueOf(redisIndex))));
		return jedis;
	}
}
