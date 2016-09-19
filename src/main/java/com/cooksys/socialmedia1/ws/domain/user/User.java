package com.cooksys.socialmedia1.ws.domain.user;

import java.util.List;
import java.util.Set;

import javax.persistence.*;


import com.cooksys.socialmedia1.ws.domain.tweet.Tweet;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class User
{
	
	@Id
	@SequenceGenerator(name="user_id_seq", sequenceName="user_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="user_id_seq")
	@Column(updatable=false)
	private Integer id;
	
	@Column(nullable=false)
	private String name;
	
	@OneToMany(mappedBy="user", fetch=FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<Tweet> tweets;
	
	@Column(nullable=false)
	private String username;
	
	@Column(nullable=false)
	private String password;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="user_followers")
	@JsonIgnore
	private List<User> followers;
	
	@JsonIgnore
	@ManyToMany(mappedBy="followers", fetch=FetchType.LAZY)
	private List<User> following;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public List<Tweet> getTweets()
	{
		return tweets;
	}

	public void setTweets(List<Tweet> tweets)
	{
		this.tweets = tweets;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public List<User> getFollowers()
	{
		return followers;
	}

	public void setFollowers(List<User> followers)
	{
		this.followers = followers;
	}

	public List<User> getFollowing()
	{
		return following;
	}

	public void setFollowing(List<User> following)
	{
		this.following = following;
	}




	


}
