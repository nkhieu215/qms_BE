package com.fn.qms.utils;

import org.springframework.stereotype.Service;

@Service
public class ConvertDTOService {
	
//	private Object convertToDto(O post) {
//	    PostDto postDto = modelMapper.map(post, PostDto.class);
//	    postDto.setSubmissionDate(post.getSubmissionDate(), 
//	        userService.getCurrentUser().getPreference().getTimezone());
//	    return postDto;
//	}
//	
//	private Post convertToEntity(PostDto postDto) throws ParseException {
//	    Post post = modelMapper.map(postDto, Post.class);
//	    post.setSubmissionDate(postDto.getSubmissionDateConverted(
//	      userService.getCurrentUser().getPreference().getTimezone()));
//	 
//	    if (postDto.getId() != null) {
//	        Post oldPost = postService.getPostById(postDto.getId());
//	        post.setRedditID(oldPost.getRedditID());
//	        post.setSent(oldPost.isSent());
//	    }
//	    return post;
//	}
}
