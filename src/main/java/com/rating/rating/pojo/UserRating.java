package com.rating.rating.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="user_rating")
@Data
@NoArgsConstructor
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},allowGetters = true)
public class UserRating implements Serializable{

	/**
	 * default generated serial version id
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * auto incremented id 
	 */
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	
	/**
	 * user reference 
	 */
	@ManyToOne
	@JoinColumn(name="user_id",nullable =false)
	public User user;
	
	/**
	 * rating to the user(out of five rating )
	 */
	public int rating;
	
	
	
    /**
     * @param user 
     * @param rating 
     */
    public UserRating(User user, int rating,Date createdAt,Date updatedAt) {
		super();
		this.user = user;
		this.rating = rating;
		this.createdAt=createdAt;
		this.updatedAt=updatedAt;
	}

	/**
     * created date
     */
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    /**
     * modified date
     */
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
    
    
}
