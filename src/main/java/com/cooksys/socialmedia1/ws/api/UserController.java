package com.cooksys.socialmedia1.ws.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.socialmedia1.ws.domain.user.User;
import com.cooksys.socialmedia1.ws.domain.user.UserResponse;
import com.cooksys.socialmedia1.ws.domain.user.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:8000")
@RequestMapping("api/users")
public class UserController
{
	
	private final UserService userService;

	@Autowired
	public UserController(UserService userService)
	{
		super();
		this.userService = userService;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<UserResponse> index() {
		return this.userService.index();
	}
	
	
	
	

}
