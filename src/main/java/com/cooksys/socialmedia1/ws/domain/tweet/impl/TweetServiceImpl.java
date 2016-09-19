package com.cooksys.socialmedia1.ws.domain.tweet.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.socialmedia1.ws.domain.tweet.TweetRepository;
import com.cooksys.socialmedia1.ws.domain.tweet.TweetResponse;
import com.cooksys.socialmedia1.ws.domain.tweet.TweetService;
import com.cooksys.socialmedia1.ws.domain.user.UserRepository;
import com.cooksys.socialmedia1.ws.domain.user.UserResponse;

@Service
public class TweetServiceImpl implements TweetService
{
	
	private final TweetRepository tweetRepo;
	
	private final UserRepository userRepo;
	
	
	@Autowired
	public TweetServiceImpl(TweetRepository tweetRepo, UserRepository userRepo)
	{
		super();
		this.tweetRepo = tweetRepo;
		this.userRepo = userRepo;
	}



	@Override
	public List<TweetResponse> index()
	{
		return TweetResponse.getTweets(this.tweetRepo.findAll());
	}

}
