package com.xkeam.database.api;

import java.util.ArrayList;
import java.util.List;

import com.xkeam.database.model.comment.Comment;

public class CommentAPI {
	
	public Comment getComment(String commentId) {
		Comment result = new Comment();
		
		return result;
	}
	
	public List<Comment> getComments(String ... commentIds) {
		List<Comment> result = new ArrayList<Comment>();
		
		return result;
	}
	
	public List<String> getReplyIds(String commentId) {
		List<String> result = new ArrayList<String>();
		
		return result;
	}

}
