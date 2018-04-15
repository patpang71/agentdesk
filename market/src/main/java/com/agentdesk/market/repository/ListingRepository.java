package com.agentdesk.market.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.agentdesk.market.domain.Listing;

public interface ListingRepository extends CrudRepository<Listing, Long> {
	List<Listing> findById(String id);
	
	List<Listing> findDistinctByNoOfBathAndNoOfBedAndTypeInAndDistrictInAndPostDateBetween(Integer noOfBath, 
			Integer noOfBed, List<String> type, List<String> district, Date start, Date end);
}

