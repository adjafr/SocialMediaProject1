package com.cooksys.socialmedia1.ws.domain.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import com.cooksys.socialmedia1.ws.domain.tweet.TweetProjection;
import com.fasterxml.jackson.annotation.JsonIgnore;

public interface UserProjection
{
	
	@JsonIgnore
	Class<?> getDecoratedClass();
	
	int getId();
	
	String getName();
	
	String getUsername();
	
	@Value("#{target.tweets}")
	List<TweetProjection> getTweets();
	
	@Value("#{target.followers}")
	List<UserUserProjection> getFollowers();
	
//	@Value("#{target.name + \": \" + target.username}")
//	String getSummary();	

}
