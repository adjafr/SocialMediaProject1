package com.cooksys.socialmedia1.ws.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.socialmedia1.ws.domain.user.User;
import com.cooksys.socialmedia1.ws.domain.user.UserProjection;
import com.cooksys.socialmedia1.ws.domain.user.UserResponse;
import com.cooksys.socialmedia1.ws.domain.user.UserService;
import com.cooksys.socialmedia1.ws.domain.user.ValidateResponse;

@RestController
@CrossOrigin(origins = "http://localhost:8000")   // @CrossOrigin(origins = "*")
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
	
	// ----- Validate Response --------
//	@RequestMapping(method=RequestMethod.GET)
//	public List<ValidateResponse> indexValidate() {
//		return this.userService.indexValidate();
//	}
	
	 @RequestMapping(value="/{username}/validate", method=RequestMethod.GET)
	    public ValidateResponse readValidate(@PathVariable String username) {
	        return this.userService.readValidate(username);
	    }
	
	// ------ User Response -----------
	@RequestMapping(method=RequestMethod.POST)
	public UserResponse create(@RequestBody User user) {
		return this.userService.create(user);
	}
	
	
	@RequestMapping(method=RequestMethod.GET)
	public List<UserResponse> index() {
		return this.userService.index();
	}
	
	 @RequestMapping(value="/{username}", method=RequestMethod.GET)
	    public UserResponse read(@PathVariable String username) {
	        return this.userService.read(username);
	    }
	    
	    @RequestMapping(value="/{id}", method=RequestMethod.PATCH) 
	    public UserResponse update(@PathVariable Integer id, @RequestBody User userToUpdate) {
	        return this.userService.updateUser(id, userToUpdate);
	    }
	    
	    @RequestMapping(value="/{id}", method=RequestMethod.DELETE) 
	    public UserResponse delete(@PathVariable User user) {
	        return this.userService.delete(user);
	    } 
	    

	
	@RequestMapping(value = "/{id}/followers", method = RequestMethod.GET)
	public List<UserResponse> readFollowers(@PathVariable Integer id) {
		return this.userService.readFollowers(id)
				;
	}
	
    @RequestMapping(value = "/{id}/followers", method=RequestMethod.PATCH)
    public UserResponse addFollowers(@PathVariable Integer id, @RequestBody User userFollower) {
        return this.userService.addFollowers(id, userFollower);
    }
	
	@RequestMapping(value = "/{id}/following", method = RequestMethod.GET)
	public List<UserResponse> readFollowing(@PathVariable Integer id) {
		return this.userService.readFollowing(id);
	}
	
    @RequestMapping(value = "/{id}/followings",method=RequestMethod.POST)
    public UserResponse createFollowings(@PathVariable Integer id, @RequestBody User userToFollow) {
        return this.userService.createFollowings(id, userToFollow);
    }
	
	@GetMapping("/matches/{regex}")
	public List<UserProjection> usernameMatches(@PathVariable String regex)
	{
		return userService.usernameMatches(regex.replace('*', '%'));
	}
	

}
