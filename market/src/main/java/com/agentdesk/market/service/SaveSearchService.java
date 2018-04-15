package com.agentdesk.market.service;

import java.util.List;

import com.agentdesk.market.domain.SaveSearch;

public interface SaveSearchService {
	public List<String> findListing(SaveSearch saveSearch);
	
	public List<SaveSearch> findAll();
}
