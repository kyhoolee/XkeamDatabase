package com.xkeam.database.api.interaction;

import java.util.ArrayList;
import java.util.List;

import com.xkeam.database.model.notification.Notification;

public class NotificationAPI {
	
	public void addNotification(String userId, String contextId, String actorId, 
			String type, String content) {
		
	}
	
	public List<Notification> getNotifications(String userId) {
		List<Notification> result = new ArrayList<Notification>();
		
		return result;
	}
	
	

}
