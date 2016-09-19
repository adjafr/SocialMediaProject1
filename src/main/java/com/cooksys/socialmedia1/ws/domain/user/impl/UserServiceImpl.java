package com.cooksys.socialmedia1.ws.domain.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.socialmedia1.ws.domain.tweet.TweetRepository;
import com.cooksys.socialmedia1.ws.domain.user.User;
import com.cooksys.socialmedia1.ws.domain.user.UserRepository;
import com.cooksys.socialmedia1.ws.domain.user.UserResponse;
import com.cooksys.socialmedia1.ws.domain.user.UserService;

@Service
public class UserServiceImpl implements UserService
{
	
	private final UserRepository userRepo;
	
	private final TweetRepository tweetRepo;

	@Autowired
	public UserServiceImpl(UserRepository userRepo, TweetRepository tweetRepo)
	{
		super();
		this.userRepo = userRepo;
		this.tweetRepo = tweetRepo;
	}

	@Override
	public List<UserResponse> index()
	{
		return UserResponse.getUsers(this.userRepo.findAll());
	}
	
	

}
