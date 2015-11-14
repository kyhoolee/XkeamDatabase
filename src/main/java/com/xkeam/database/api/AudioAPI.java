package com.xkeam.database.api;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xkeam.database.model.audio.Audio;
import com.xkeam.database.model.audio.Category;
import com.xkeam.database.model.audio.Topic;

public class AudioAPI {
	public Audio getAudio(String audioId) {
		Audio result = new Audio();
		
		return result;
	}
	
	public List<Audio> getAudioList(String ... audioIds) {
		List<Audio> result = new ArrayList<Audio>();
		
		return result;
	}
	
	public Topic getTopic(String topicId) {
		Topic result = new Topic();
		
		return result;
	}
	
	public Category getCategory(String categoryId) {
		Category result = new Category();
		
		return result;
	}
	
	
	/**
	 * Get all category
	 * @return
	 */
	public List<Category> getCategoryList() {
		List<Category> result = new ArrayList<Category>();
		
		return result;
	}
	
	/**
	 * Get topic list in category
	 * @param categoryId
	 * @return
	 */
	public List<Topic> getTopicByCategory(String categoryId) {
		List<Topic> result = new ArrayList<Topic>();
		
		return result;
	}
	
	/**
	 * Get audio list in topic
	 * @param topicId
	 * @return
	 */
	public List<Audio> getAudioByTopic(String topicId) {
		List<Audio> result = new ArrayList<Audio>();
		
		return result;
	}
	
	/**
	 * Search audio by query
	 * @param query
	 * @return
	 */
	public List<Audio> searchAudio(String query) {
		List<Audio> result = new ArrayList<Audio>();
		
		return result;
	}
	
	/**
	 * Get statistic count of audio
	 * @param audioId
	 * @return
	 */
	public Map<String, Long> getAudioStatistic(String audioId) {
		Map<String, Long> result = new HashMap<String, Long>();
		
		return result;
	}
	
	/**
	 * Get audio list from ranking table
	 * @param topType
	 * @return
	 */
	public List<Audio> getAudioByTop(String topType) {
		List<Audio> result = new ArrayList<Audio>();
		
		return result;
	}
  
}
