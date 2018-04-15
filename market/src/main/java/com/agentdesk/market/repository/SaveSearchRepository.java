package com.agentdesk.market.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.agentdesk.market.domain.SaveSearch;

public interface SaveSearchRepository extends CrudRepository<SaveSearch, Long> {

	public List<SaveSearch> findAll();

}
