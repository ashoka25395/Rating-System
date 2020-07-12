package com.rating.rating.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="user")
@Data
@NoArgsConstructor
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},allowGetters = true)
public class User implements Serializable {

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
	 * first name of user
	 */
	public String firstName;
	/**
	 * last name of user
	 */
	public String lastName;
	/**
	 * user type.it can be DRIVER,PASSENGER
	 */
	public String userType;
	
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
	

}
