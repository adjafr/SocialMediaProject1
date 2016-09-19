package com.cooksys.socialmedia1.ws.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.socialmedia1.ws.domain.tweet.TweetResponse;
import com.cooksys.socialmedia1.ws.domain.tweet.TweetService;
import com.cooksys.socialmedia1.ws.domain.user.UserResponse;

@RestController
@CrossOrigin(origins = "http://localhost:8000")
@RequestMapping("api/tweets")
public class TweetController
{
	
	private final TweetService tweetService;

	@Autowired
	public TweetController(TweetService tweetService)
	{
		super();
		this.tweetService = tweetService;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<TweetResponse> index() {
		return this.tweetService.index();
	}
	
	

}
