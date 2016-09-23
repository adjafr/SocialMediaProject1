package com.cooksys.socialmedia1.ws.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.socialmedia1.ws.domain.tweet.Tweet;
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
	
	@RequestMapping(method=RequestMethod.POST)
	public TweetResponse create(@RequestBody Tweet tweet) {
		return this.tweetService.create(tweet);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<TweetResponse> index() {
		return this.tweetService.index();
	}
	
    
    @RequestMapping(value = "/{id}", method=RequestMethod.GET)
    public TweetResponse indexTweet(@PathVariable Integer id) {
        return this.tweetService.indexTweet(id);
    }
    
    @RequestMapping(value = "/{id}", method=RequestMethod.PATCH)
    public TweetResponse update(@PathVariable Integer id, @RequestBody Tweet tweetToUpdate) {
        return this.tweetService.update(id, tweetToUpdate);
    }
    
    @RequestMapping(value = "/{id}", method=RequestMethod.DELETE)
    public TweetResponse delete(@PathVariable Integer id) {
        return this.tweetService.delete(id);
    }
	
	

}
