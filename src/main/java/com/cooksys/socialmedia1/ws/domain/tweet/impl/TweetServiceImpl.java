package com.cooksys.socialmedia1.ws.domain.tweet.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.socialmedia1.ws.domain.tweet.Tweet;
import com.cooksys.socialmedia1.ws.domain.tweet.TweetRepository;
import com.cooksys.socialmedia1.ws.domain.tweet.TweetResponse;
import com.cooksys.socialmedia1.ws.domain.tweet.TweetService;
import com.cooksys.socialmedia1.ws.domain.user.UserRepository;
import com.cooksys.socialmedia1.ws.domain.user.UserResponse;

@Service
public class TweetServiceImpl implements TweetService
{
	
	private final TweetRepository tweetRepo;

	
	
	@Autowired
	public TweetServiceImpl(TweetRepository tweetRepo)
	{
		super();
		this.tweetRepo = tweetRepo;
	}

	@Override
	public TweetResponse create(Tweet tweet) {
		this.tweetRepo.save(tweet);
		return TweetResponse.returnTweet(tweet);
	}


	@Override
	public List<TweetResponse> index()
	{
		return TweetResponse.returnTweets(this.tweetRepo.findAll());
	}

	@Override
	public TweetResponse indexTweet(Integer id)
	{
		TweetResponse.returnTweet(tweetRepo.getOne(id));
		return TweetResponse.returnTweet(tweetRepo.getOne(id));
	}

	@Override
	public TweetResponse update(Integer id, Tweet tweetToUpdate)
	{
		tweetToUpdate.setId(id);
		this.tweetRepo.save(tweetToUpdate);
		return TweetResponse.returnTweet(tweetToUpdate);
	}

	@Override
	public TweetResponse delete(Integer id)
	{
		return TweetResponse.returnTweet(this.tweetRepo.findOne(id));
	}
	
	

}
