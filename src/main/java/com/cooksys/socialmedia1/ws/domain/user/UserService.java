package com.cooksys.socialmedia1.ws.domain.user;

import java.util.List;

public interface UserService
{
	
	// ------ Validate Response ---------
	
	List<ValidateResponse> indexValidate();
	
	ValidateResponse readValidate(String username);
	
	
	// ------ User Response -----------
	
	UserResponse create(User user);

	List<UserResponse> index();
	
	UserResponse read(String username);
	
	UserResponse updateUser(Integer id, User userToUpdate);
	
	UserResponse delete(User user);

	List<UserResponse> readFollowers(Integer id);
	
	UserResponse addFollowers(Integer id, User userFollower);

	List<UserResponse> readFollowing(Integer id);
	
	UserResponse createFollowings(Integer id, User userToFollow);

	List<UserProjection> usernameMatches(String replace);




	

	

	
}
