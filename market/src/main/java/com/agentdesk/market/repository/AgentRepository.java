package com.agentdesk.market.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.agentdesk.market.domain.Agent;
import com.agentdesk.market.domain.SaveSearch;


public interface AgentRepository extends CrudRepository<Agent, Long> {
	public Agent findByEmail(String email);
	
	public Agent findByuserName(String userName);
		
	public List<Agent> findAll();

}
