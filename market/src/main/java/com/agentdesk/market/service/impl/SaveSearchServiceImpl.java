package com.agentdesk.market.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agentdesk.market.domain.Listing;
import com.agentdesk.market.domain.SaveSearch;
import com.agentdesk.market.repository.ListingRepository;
import com.agentdesk.market.repository.SaveSearchRepository;
import com.agentdesk.market.service.SaveSearchService;

@Service
public class SaveSearchServiceImpl implements SaveSearchService {
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private SaveSearchRepository saveSearchRepository;
	
	@Autowired
	private ListingRepository listingRepository;
			
	@Override
	public List<SaveSearch> findAll() {
		System.out.println("findAll: " + saveSearchRepository.toString());
		return saveSearchRepository.findAll();
	}

	@Override
	public List<String> findListing(SaveSearch saveSearch) {
		
		List<String> types = getListFromString(saveSearch.getSearchTypes());
		List<String> districts = getListFromString(saveSearch.getSearchDistrict());		
		List<String> ans = new ArrayList<>();

		List<Listing> listings = listingRepository
				.findDistinctByNoOfBathAndNoOfBedAndTypeInAndDistrictInAndPostDateBetween(
						saveSearch.getNoOfBath(), saveSearch.getNoOfBed(), types, districts, 
						yesterday(), (new Date()));
		for (Listing l : listings) {
			if (l.getAgent()!=null) {
				if (!ans.contains(l.getAgent().getEmail())) {
					ans.add(l.getAgent().getEmail());
				}
			}
		}

		return ans;
		//return null;
	}
	
	private List<String> getListFromString(String input) {
		if (input==null || input.length()==0) {
			return null;
		}
		List<String> ans = new ArrayList<>();
		String[] strs = input.split(",");
		for (String s : strs) {
			ans.add(s);
		}
		return ans;
	}
	
	private Date yesterday() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		return cal.getTime();
	}
	
}
