package com.agentdesk.market.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity(name="SaveSearch")
@Table(name="SaveSearch")
public class SaveSearch implements Serializable {
	private static final long serialVersionUID = 323456L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="savesearch_id")
	private Long id;	
	
	@ManyToOne
	@JoinColumn(name="agent_id", nullable=false)
	private Agent agent;
	
	@Column(name="no_bed")
	private Integer noOfBed;
	
	@Column(name="no_bath")
	private Integer noOfBath;
	
	@Column(name="search_types")
	private String searchTypes;
	
	@Column(name="search_district")
	private String searchDistrict;
	
	public SaveSearch() {}
	
	public SaveSearch(Agent agent, Integer noOfBed, Integer noOfBath, String searchTypes, String searchDistrict) {
		super();
		this.agent = agent;
		this.noOfBed = noOfBed;
		this.noOfBath = noOfBath;
		this.searchTypes = searchTypes;
		this.searchDistrict = searchDistrict;
	}
	
	public SaveSearch(Integer noOfBed, Integer noOfBath, String searchTypes, String searchDistrict) {
		super();
		this.noOfBed = noOfBed;
		this.noOfBath = noOfBath;
		this.searchTypes = searchTypes;
		this.searchDistrict = searchDistrict;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
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

	public String getSearchTypes() {
		return searchTypes;
	}

	public void setSearchTypes(String searchTypes) {
		this.searchTypes = searchTypes;
	}

	public String getSearchDistrict() {
		return searchDistrict;
	}

	public void setSearchDistrict(String searchDistrict) {
		this.searchDistrict = searchDistrict;
	}
	
	
}
