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
	
	private User user;

	public TweetResponse(Tweet tweet)
	{
		this.setId(tweet.getId());
		this.setTimeStamp(tweet.getTimeStamp());
		this.setTweet(tweet.getTweet());
		this.setUser(tweet.getUser());
	}
	
	public static List<TweetResponse> getTweets(List<Tweet> list) {
		ArrayList<TweetResponse> result = new ArrayList<>();
		for (Tweet tweet : list)
			result.add(new TweetResponse(tweet));
		return result;
	}
	
	public static TweetResponse getTweet(Tweet tweet) {
		return new TweetResponse(tweet);
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

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	
	
	
	
	

}
