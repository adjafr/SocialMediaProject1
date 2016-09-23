package com.cooksys.socialmedia1.ws.domain.tweet;

import java.util.List;

public interface TweetService
{
	
	TweetResponse create(Tweet tweet);

	List<TweetResponse> index();

	TweetResponse indexTweet(Integer id);

	TweetResponse update(Integer id, Tweet TweetToUpdate);

	TweetResponse delete(Integer id);



}
