package com.cooksys.socialmedia1.ws.domain.tweet;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface TweetProjection
{
	
	@JsonIgnore
	Class<?> getDecoratedClass();
	
	String getTweet();

}
