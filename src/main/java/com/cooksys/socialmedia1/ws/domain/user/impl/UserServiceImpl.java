package com.cooksys.socialmedia1.ws.domain.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cooksys.socialmedia1.ws.domain.tweet.Tweet;
import com.cooksys.socialmedia1.ws.domain.tweet.TweetRepository;
import com.cooksys.socialmedia1.ws.domain.user.User;
import com.cooksys.socialmedia1.ws.domain.user.UserProjection;
import com.cooksys.socialmedia1.ws.domain.user.UserRepository;
import com.cooksys.socialmedia1.ws.domain.user.UserResponse;
import com.cooksys.socialmedia1.ws.domain.user.UserService;
import com.cooksys.socialmedia1.ws.domain.user.ValidateResponse;

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
	
	// -------- ValidateResponse-------------
	
	@Override
	public List<ValidateResponse> indexValidate()
	{
		return ValidateResponse.getUsers(this.userRepo.findAll());
	}
	
	@Override
	public ValidateResponse readValidate(String username)
	{
		List<ValidateResponse> tempList = ValidateResponse.getUsers(this.userRepo.findAll());
		
		for (ValidateResponse validateResponse : tempList)
		{
			if(validateResponse.getUsername().equals(username))
				return validateResponse;
		}
		return null;
		
	}
	
	
	// -------- UserResponse --------------
	
	@Override
	public UserResponse create(User user)
	{
		this.userRepo.save(user);
		return UserResponse.getUser(user);
	}

	@Override
	public List<UserResponse> index()
	{
		return UserResponse.getUsers(this.userRepo.findAll());
	}
	
	@Override
	public UserResponse read(String username)
	{
		List<UserResponse> tempList = UserResponse.getUsers(this.userRepo.findAll());
		
		for (UserResponse userResponse : tempList)
		{
			if(userResponse.getUsername().equals(username))
				return userResponse;
		}
		return null;
		
	}
	
	
	@Override
	public UserResponse updateUser(Integer id, User userToUpdate)
	{
		userToUpdate.setId(id);
		this.userRepo.save(userToUpdate);
		return UserResponse.getUser(userToUpdate);
	}
	
	
	@Override
	public UserResponse delete(User user)
	{
		for (Tweet tweet : user.getTweets()) {
			this.tweetRepo.delete(tweet);
		}

		this.userRepo.delete(user);
		return UserResponse.getUser(user);
	}
	
	
		
	

	@Override
	public List<UserResponse> readFollowers(Integer id)
	{
		return UserResponse.getUsers(this.userRepo.findOne(id).getFollowers());
	} 
	
	
	@Override
	public UserResponse addFollowers(Integer id, User userFollower)
	{
		userFollower.setId(id);
		this.userRepo.save(userFollower);
		return UserResponse.getUser(userFollower);
	}
	
	
	

	@Override
	public List<UserResponse> readFollowing(Integer id)
	{
		return UserResponse.getUsers(this.userRepo.findOne(id).getFollowing());
	}
	
	
	
	@Override
	public UserResponse createFollowings(Integer id, User userToFollow)
	{
		userToFollow.setId(id);
		this.userRepo.save(userToFollow);
		return UserResponse.getUser(userToFollow);
	}
	
	

	@Override
	public List<UserProjection> usernameMatches(String regex)
	{
		return userRepo.findByUsernameLike(regex);
	}




	

}
