package com.cooksys.socialmedia1.ws.domain.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>
{

	List<UserProjection> findByUsernameLike(String regex);

}
