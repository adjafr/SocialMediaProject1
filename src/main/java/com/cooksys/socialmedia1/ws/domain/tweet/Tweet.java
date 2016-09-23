package com.cooksys.socialmedia1.ws.domain.tweet;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import com.cooksys.socialmedia1.ws.domain.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "tweet"))
public class Tweet
{
	@Id
	@SequenceGenerator(name="tweet_id_seq", sequenceName="tweet_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="tweet_id_seq")
	@Column(updatable=false)
	private Integer id;
	
	@Column(nullable=false)
	String timeStamp = new SimpleDateFormat("EEE yyyy MMM dd hh:mm:ss a z").format(new Date());
	
	@Column(nullable=false)
	private String tweet;
	

	
//	@JsonIgnore
	@ManyToOne(optional = false)  //check this
	private User user;//private Set<User> users;



	public Integer getId()
	{
		return id;
	}



	public void setId(Integer id)
	{
		this.id = id;
	}



	public String getTimeStamp()
	{
		return timeStamp;
	}



	public void setTimeStamp(String timeStamp)
	{
		this.timeStamp = timeStamp;
	}



	public String getTweet()
	{
		return tweet;
	}



	public void setTweet(String tweet)
	{
		this.tweet = tweet;
	}



	public User getUser()
	{
		return user;
	}



	public void setUser(User user)
	{
		this.user = user;
	}

	
	
	
}
