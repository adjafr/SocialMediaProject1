package com.cooksys.socialmedia1.ws.domain.tweet;

import java.util.ArrayList;
import java.util.List;

import com.cooksys.socialmedia1.ws.domain.user.User;
import com.cooksys.socialmedia1.ws.domain.user.UserResponse;

public class TweetResponse
{
	
	private Integer id;
	
	private String timeStamp;
	
	private String tweet;
	
	private UserResponse user;
	
	


	
	public static List<TweetResponse> returnTweets(List<Tweet> list) {
		List<TweetResponse> result = new ArrayList<>();
		for (Tweet t : list)
			result.add(new TweetResponse(t));
		return result;
	}
	
	public static TweetResponse returnTweet(Tweet t) {
		return new TweetResponse(t);
	}
	
	public TweetResponse(Tweet t)
	{
		this.setId(t.getId());
		this.setTimeStamp(t.getTimeStamp());
		this.setTweet(t.getTweet());
		this.setUser(UserResponse.getUser(t.getUser()));
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getTimeStamp()
	{
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp)
	{
		this.timeStamp = timeStamp;
	}

	public String getTweet()
	{
		return tweet;
	}

	public void setTweet(String tweet)
	{
		this.tweet = tweet;
	}

	public UserResponse getUser()
	{
		return user;
	}

	public void setUser(UserResponse user)
	{
		this.user = user;
	}

	
	

}
