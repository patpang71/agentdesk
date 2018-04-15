package com.agentdesk.market.service;

import java.util.List;

import com.agentdesk.market.domain.Agent;
import com.agentdesk.market.domain.Listing;
import com.agentdesk.market.domain.SaveSearch;

public interface AgentService {
	public Agent createAgent(Agent agent, List<Listing> listings, List<SaveSearch> saveSearches);
	
	public Agent save(Agent agent);
	

}
