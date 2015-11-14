package com.xkeam.database.redis;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;

import com.xkeam.database.util.LoggerUtil;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisConnectionException;

public class RedisCache {
	public static Logger logger = LoggerUtil.getDailyLogger("RedisCache" + "_log");
	
	public static long getLongValue(String key, String name) {
		long result = 0;
		Jedis jedis = RedisPool.getJedis(name);

		try {
			String data = jedis.get(key);
			if(data != null)
				result = Long.parseLong(data);
			
			return result;
		} catch (JedisConnectionException ex) {
			jedis.close();

		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
		} finally {
			jedis.close();

		}
		
		return result;
	}
	
	public static void setLongValue(String key, long value, String name) {
		
		Jedis jedis = RedisPool.getJedis(name);

		try {
			jedis.set(key, value + "");
			
		} catch (JedisConnectionException ex) {
			jedis.close();

		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
		} finally {
			jedis.close();

		}
	}
	
	public static long delLongValue(String key, String name) {
		long result = 0;
		Jedis jedis = RedisPool.getJedis(name);

		try {
			result = (long)(jedis.del(key));
			
			return result;
		} catch (JedisConnectionException ex) {
			jedis.close();

		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
		} finally {
			jedis.close();

		}
		
		return result;
	}
	
	public static int getIntValue(String key, String name) {
		int result = 0;
		Jedis jedis = RedisPool.getJedis(name);

		try {
			String data = jedis.get(key);
			if(data != null)
				result = Integer.parseInt(data);
			
			return result;
		} catch (JedisConnectionException ex) {
			jedis.close();

		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
		} finally {
			jedis.close();

		}
		
		return result;
	}
	
	public static void setIntValue(String key, int value, String name) {
		
		Jedis jedis = RedisPool.getJedis(name);

		try {
			jedis.set(key, value + "");
			
		} catch (JedisConnectionException ex) {
			jedis.close();

		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
		} finally {
			jedis.close();

		}
	}
	
	public static int delIntValue(String key, String name) {
		int result = 0;
		Jedis jedis = RedisPool.getJedis(name);

		try {
			result = (int)(long)(jedis.del(key));
			
			return result;
		} catch (JedisConnectionException ex) {
			jedis.close();

		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
		} finally {
			jedis.close();

		}
		
		return result;
	}
	
	public static String getStringValue(String key, String name) {
		String result = "";
		Jedis jedis = RedisPool.getJedis(name);

		try {
			result = jedis.get(key);
			
			return result;
		} catch (JedisConnectionException ex) {
			jedis.close();

		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
		} finally {
			jedis.close();

		}
		
		return result;
	}
	
	public static void setStringValue(String key, String value, String name) {
		Jedis jedis = RedisPool.getJedis(name);

		try {
			jedis.set(key, value);
		} catch (JedisConnectionException ex) {
			jedis.close();

		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
		} finally {
			jedis.close();

		}
	}
	
	public static void delStringValue(String key, String name) {
		Jedis jedis = RedisPool.getJedis(name);

		try {
			jedis.del(key);
		} catch (JedisConnectionException ex) {
			jedis.close();

		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
		} finally {
			jedis.close();

		}
	}
	
	
	// ////////////////////////////////////////////////////////////////////////////////////////
	// stringValue-set-stored
	// ////////////////////////////////////////////////////////////////////////////////////////
	
	public static List<String> getMemberList(String key, String name) {
		List<String> logicalList = new ArrayList<String>();
		
		Jedis jedis = RedisPool.getJedis(name);

		try {
			Set<String> result = jedis.smembers(key);
			logicalList.addAll(result);

		} catch (JedisConnectionException ex) {
			jedis.close();

		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
		} finally {
			jedis.close();

		}
		
		return logicalList;
	}
	
	public static void insertMember(String key, String value, String name) {
		Jedis jedis = RedisPool.getJedis(name);
		try {
			jedis.sadd(key, value);

		} catch (JedisConnectionException ex) {
			jedis.close();

		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
		} finally {
			jedis.close();

		}
	}
	
	public static void removeMember(String key, String value, String name) {
		Jedis jedis = RedisPool.getJedis(name);
		try {
			jedis.srem(key, value);

		} catch (JedisConnectionException ex) {
			jedis.close();

		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
		} finally {
			jedis.close();

		}
	}
	
	
	// ////////////////////////////////////////////////////////////////////////////////////////
	// stringValue-hash-stored
	// ////////////////////////////////////////////////////////////////////////////////////////

	
	public static boolean checkField(String hashKey, String fieldKey, String name) {
		boolean stored = false;
		Jedis jedis = RedisPool.getJedis(name);
		try {
			stored = jedis.hexists(hashKey, fieldKey);
			return stored;
		} catch (JedisConnectionException ex) {
			jedis.close();

		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
		} finally {
			jedis.close();
		}
		
		return stored;
	}
	
	public static List<String> listField(String hashKey, String name) {
		List<String> result = new ArrayList<String>();
		Jedis jedis = RedisPool.getJedis(name);
		try {
			Set<String> keys = jedis.hkeys(hashKey);
			result.addAll(keys);
			return result;
		} catch (JedisConnectionException ex) {
			jedis.close();

		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
		} finally {
			jedis.close();

		}
		
		return result;
	}
	
	public static String setValue(String hashKey, String fieldKey, String value, String name) {
		String result = "";
		Jedis jedis = RedisPool.getJedis(name);
		try {
			jedis.hset(hashKey, fieldKey, value + "");
			result = value;
			return result;
		} catch (JedisConnectionException ex) {
			jedis.close();

		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
		} finally {
			jedis.close();

		}
		
		return result;
	}
	
	public static String getStringValue(String hashKey, String fieldKey, String name) {
		String stored = "";
		Jedis jedis = RedisPool.getJedis(name);
		try {
			stored = jedis.hget(hashKey, fieldKey);
			if(stored == null) {
				return "";
			}
		} catch (JedisConnectionException ex) {
			jedis.close();

		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
		} finally {
			jedis.close();


		}
		
		return stored;
	}
	
	public static void removeStringValue(String hashKey, String fieldKey, String name) {
		Jedis jedis = RedisPool.getJedis(name);
		try {
			jedis.hdel(hashKey, fieldKey);
			
		} catch (JedisConnectionException ex) {
			jedis.close();

		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
		} finally {
			jedis.close();

		}
	}
	
	// ////////////////////////////////////////////////////////////////////////////////////////
	// longValue-hash-stored
	// ////////////////////////////////////////////////////////////////////////////////////////
	
	
	public static long addLongValue(String hashKey, String fieldKey, long value, String name) {
		long result = 0;
		Jedis jedis = RedisPool.getJedis(name);
		try {
			Long val = jedis.hincrBy(hashKey, fieldKey, value);
			result = val;
			return result;
		} catch (JedisConnectionException ex) {
			jedis.close();

		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
		} finally {
			jedis.close();

		}
		
		return result;
	}
	
	public static long setLongValue(String hashKey, String fieldKey, long value, String name) {
		long result = 0;
		Jedis jedis = RedisPool.getJedis(name);
		try {
			jedis.hset(hashKey, fieldKey, value + "");
			result = value;
			return result;
		} catch (JedisConnectionException ex) {
			jedis.close();

		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
		} finally {
			jedis.close();

		}
		
		return result;
	}
	
	public static long getLongValue(String hashKey, String fieldKey, String name) {
		long stored = 0;
		Jedis jedis = RedisPool.getJedis(name);
		try {
			String data = jedis.hget(hashKey, fieldKey);
			if(data != null)
				stored = Long.parseLong(data);

		} catch (JedisConnectionException ex) {
			jedis.close();

		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
		} finally {
			jedis.close();

		}
		
		return stored;
	}
	

	
	// ////////////////////////////////////////////////////////////////////////////////////////
	// intValue-hash-stored
	// ////////////////////////////////////////////////////////////////////////////////////////
	
	
	public static int addValue(String hashKey, String fieldKey, int value, String name) {
		int result = 0;
		Jedis jedis = RedisPool.getJedis(name);
		try {
			Long val = jedis.hincrBy(hashKey, fieldKey, value);
			result = val.intValue();
			return result;
		} catch (JedisConnectionException ex) {
			jedis.close();

		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
		} finally {
			jedis.close();

		}
		
		return result;
	}
	
	public static int setValue(String hashKey, String fieldKey, int value, String name) {
		int result = 0;
		Jedis jedis = RedisPool.getJedis(name);
		try {
			jedis.hset(hashKey, fieldKey, value + "");
			result = value;
			return result;
		} catch (JedisConnectionException ex) {
			jedis.close();

		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
		} finally {
			jedis.close();

		}
		
		return result;
	}
	
	public static int getIntValue(String hashKey, String fieldKey, String name) {
		int stored = 0;
		Jedis jedis = RedisPool.getJedis(name);
		try {
			String data = jedis.hget(hashKey, fieldKey);
			if(data != null)
				stored = Integer.parseInt(data);

		} catch (JedisConnectionException ex) {
			jedis.close();

		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
		} finally {
			jedis.close();

		}
		
		return stored;
	}
	
	public static void removeValue(String hashKey, String fieldKey, String name) {
		Jedis jedis = RedisPool.getJedis(name);
		try {
			jedis.hdel(hashKey, fieldKey);
			
		} catch (JedisConnectionException ex) {
			jedis.close();

		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
		} finally {
			jedis.close();

		}
	}
	
	
	// ////////////////////////////////////////////////////////////////////////////////////////
	// intValue-id-generated
	// ////////////////////////////////////////////////////////////////////////////////////////
	
	
	public static synchronized long incrAndGet(String hashKey, String fieldKey, String name) {
		long result = 0;
		Jedis jedis = RedisPool.getJedis(name);
		try {
			Long val = jedis.hincrBy(hashKey, fieldKey, 1);
			result = val;
			return result;
		} catch (JedisConnectionException ex) {
			jedis.close();

		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
		} finally {
			jedis.close();

		}
		
		return result;
	}
	
	
	// ////////////////////////////////////////////////////////////////////////////////////////
	// intValue-sorted-set
	// ////////////////////////////////////////////////////////////////////////////////////////
	
	
	public static double zincrValue(String sortedKey, String field, double value, String name) {
		double result= 0;
		Jedis jedis = RedisPool.getJedis(name);
		try {
			result = jedis.zincrby(sortedKey, value, field);
			
			return result;
		} catch (JedisConnectionException ex) {
			jedis.close();

		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
		} finally {
			jedis.close();

		}
		
		return result;
	}
	
	public static double zsetValue(String hashKey, String fieldKey, double value, String name) {
		double result = 0;
		Jedis jedis = RedisPool.getJedis(name);
		try {
			jedis.zadd(hashKey, value, fieldKey);
			result = value;
			return result;
		} catch (JedisConnectionException ex) {
			jedis.close();

		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
		} finally {
			jedis.close();

		}
		
		return result;
	}
	
	public static String zheadField(String zKey, String name) {
		String field = null;
		Jedis jedis = RedisPool.getJedis(name);
		try {
			Set<String> fields = jedis.zrange(zKey, 0, 0);
			if(fields != null) {
				if(fields.size() == 1) {
					for(String e : fields) {
						field = e;
						break;
					}
				}
			}
			
			jedis.zrem(zKey, field);
			

		} catch (JedisConnectionException ex) {
			jedis.close();

		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
		} finally {
			jedis.close();

		}
		
		return field;
	}
	
	public static Set<String> zheadFields(String hashKey, long number, String name) {
		Set<String> keys = new TreeSet<String>();
		Jedis jedis = RedisPool.getJedis(name);
		try {
			keys = jedis.zrange(hashKey, 0, number - 1);
			for(String key : keys) {
				jedis.zrem(hashKey, key);
			}
		} catch (JedisConnectionException ex) {
			jedis.close();

		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
		} finally {
			jedis.close();

		}
		
		return keys;
	}
	
	public static Set<String> zgetFields(String hashKey, long start, long end, String name) {
		Set<String> keys = new TreeSet<String>();
		Jedis jedis = RedisPool.getJedis(name);
		try {
			keys = jedis.zrange(hashKey, start, end);

		} catch (JedisConnectionException ex) {
			jedis.close();

		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
		} finally {
			jedis.close();

		}
		
		return keys;
	}
}