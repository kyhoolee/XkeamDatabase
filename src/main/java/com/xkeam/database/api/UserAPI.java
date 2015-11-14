package com.xkeam.database.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xkeam.database.model.user.User;

public class UserAPI {
	public User getUser(String userId) {
		User result = new User();
		
		return result;
	}
	
	public Map<String, Long> getUserStatistic(String userId) {
		Map<String, Long> result = new HashMap<String, Long>();
		
		return result;
	}
	
	public List<String> getIdolIds(String userId) {
		List<String> result = new ArrayList<String>();
		
		return result;
	}
	
	public List<String> getFanIds(String userId) {
		List<String> result = new ArrayList<String>();
		
		return result;
	}
	
	public List<User> getUsers(String ... userId) {
		List<User> result = new ArrayList<User>();
		
		return result;
	}
	
	
	public List<String> getSaveAudioIds(String userIds) {
		List<String> result = new ArrayList<String>();
		
		return result;
	}
	
	public void saveAudio(String userId, String audioId, String saveList, boolean state) {
		
	}
	
	public void followUser(String userId, String targetId, boolean state) {
		
	}
	
	
	
	
	

}
