package com.cooksys.socialmedia1.ws.domain.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import com.cooksys.socialmedia1.ws.domain.tweet.TweetProjection;
import com.fasterxml.jackson.annotation.JsonIgnore;

public interface UserUserProjection
{
	
	@JsonIgnore
	Class<?> getDecoratedGlass();
	
	String getName();
	
	String getUsername();
	
	@Value("#{target.tweets}")
	List<TweetProjection> getTweets();

}
