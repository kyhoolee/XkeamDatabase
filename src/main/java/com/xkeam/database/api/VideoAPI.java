package com.xkeam.database.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xkeam.database.model.video.Video;

public class VideoAPI {
	public Video getVideo(String videoId) {
		Video result = new Video();
		
		return result;
	}
	
	public List<String> getCommentIds(String videoId) {
		List<String> result = new ArrayList<String>();
		
		return result;
	}
	
	public List<String> getLikeIds(String videoId) {
		List<String> result = new ArrayList<String>();
		
		return result;
	}
	
	public Map<String, Long> getVideoStatistic(String videoId) {
		Map<String, Long> result = new HashMap<String, Long>();
		
		return result;
	}
	
	
}
