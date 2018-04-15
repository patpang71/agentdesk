package com.agentdesk.market.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity(name="Agent")
@Table(name="Agent")
public class Agent implements Serializable {
	private static final long serialVersionUID = 123456L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="agent_id")
	private Long id;
	
	@Column(name="user_name")
	private String userName;
		
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="id")
	private List<Listing> listings;

	@OneToMany(cascade=CascadeType.ALL, mappedBy="id")
	private List<SaveSearch> saveSearchs;
		
	public Agent() {}
	
	public Agent(String userName, String firstName, String lastName, String email) {
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public Agent(String userName, String firstName, String lastName, String email, List<Listing> listings,
			List<SaveSearch> saveSearchs) {
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.listings = listings;
		this.saveSearchs = saveSearchs;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Listing> getListings() {
		return listings;
	}

	public void setListings(List<Listing> listings) {
		this.listings = listings;
	}

	public List<SaveSearch> getSaveSearchs() {
		return saveSearchs;
	}

	public void setSaveSearchs(List<SaveSearch> saveSearchs) {
		this.saveSearchs = saveSearchs;
	}
	
}
