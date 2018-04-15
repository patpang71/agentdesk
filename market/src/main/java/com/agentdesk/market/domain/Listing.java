package com.agentdesk.market.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity(name="Listing")
@Table(name="Listing")
public class Listing implements Serializable {
	private static final long serialVersionUID = 223456L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="listing_id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="agent_id", nullable=false)
	private Agent agent;
	
	@Column(name="address")
	private String address;
	
	@Column(name="no_bed")
	private Integer noOfBed;
	
	@Column(name="no_bath")
	private Integer noOfBath;
	
	@Column(name="type")
	private String type;
	
	@Column(name="district")
	private String district;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="post_date")
	private Date postDate;

	public Listing() {}
	
	public Listing(String address, Integer noOfBed, Integer noOfBath, String type, String district,
			String city, String state) {
		super();
		this.address = address;
		this.noOfBed = noOfBed;
		this.noOfBath = noOfBath;
		this.type = type;
		this.district = district;
		this.city = city;
		this.state = state;
		this.postDate = new Date();
	}
	
	public Listing(Agent agent, String address, Integer noOfBed, Integer noOfBath, String type, String district,
			String city, String state) {
		super();
		this.agent = agent;
		this.address = address;
		this.noOfBed = noOfBed;
		this.noOfBath = noOfBath;
		this.type = type;
		this.district = district;
		this.city = city;
		this.state = state;
		this.postDate = new Date();
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getNoOfBed() {
		return noOfBed;
	}

	public void setNoOfBed(Integer noOfBed) {
		this.noOfBed = noOfBed;
	}

	public Integer getNoOfBath() {
		return noOfBath;
	}

	public void setNoOfBath(Integer noOfBath) {
		this.noOfBath = noOfBath;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getPostDate() {
		return postDate;
	}
	
	
}
