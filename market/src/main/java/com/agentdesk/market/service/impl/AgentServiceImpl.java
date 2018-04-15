package com.agentdesk.market.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agentdesk.market.domain.Agent;
import com.agentdesk.market.domain.Listing;
import com.agentdesk.market.domain.SaveSearch;
import com.agentdesk.market.repository.AgentRepository;
import com.agentdesk.market.service.AgentService;

@Service
public class AgentServiceImpl implements AgentService {
	
	@Autowired
	private AgentRepository agentRepository;
	
	//@Autowired
	//private ListingRepository listingRepository;
	
	//@Autowired
	//private SaveSearchRepository saveSearchRepository;
	
	@Transactional
	@Override
	public Agent createAgent(Agent agent, List<Listing> listings, List<SaveSearch> saveSearches) {
		Agent localAgent = agentRepository.findByuserName(agent.getUserName());
		if (localAgent==null) {
			agent.setListings(listings);
			agent.setSaveSearchs(saveSearches);
			localAgent = agentRepository.save(agent);
		}
		return localAgent;
	}

	@Override
	public Agent save(Agent agent) {
		return agentRepository.save(agent);
	}
	
}
