package com.agentdesk.market;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.agentdesk.market.domain.Agent;
import com.agentdesk.market.domain.Listing;
import com.agentdesk.market.domain.SaveSearch;
import com.agentdesk.market.repository.AgentRepository;

@SpringBootApplication
@EnableScheduling
public class MarketApplication implements CommandLineRunner {
	
	@Autowired
	private AgentRepository agentRepository;
	

	public static void main(String[] args) throws Exception  {
		SpringApplication.run(MarketApplication.class, args);
		
	}
	

	@Override
	public void run(String... args) throws Exception {
		//Listing listing1 = new Listing()
		Agent agent1 = new Agent("ppang", "Patrick", "Pang", "patpang71@gmail.com");
		//Listing(String address, Integer noOfBed, Integer noOfBath, String type, String district, String city, String state)
		Listing listing1 = new Listing(agent1, "123 Market St, SF, CA", 2, 2, "Apartment", "Financial", "San Francisco", "CA");
		Listing listing2 = new Listing(agent1, "345 Mission St, SF, CA", 2, 2, "House", "Mission Bay", "San Francisco", "CA");
		List<Listing> listingAgent1 = new ArrayList<>();
		listingAgent1.add(listing1);
		listingAgent1.add(listing2);
		agent1.setListings(listingAgent1);
		//public SaveSearch(Integer noOfBed, Integer noOfBath, String searchTypes, String searchDistrict) {
		SaveSearch ss1 = new SaveSearch(agent1, 2, 2, "Apartment", "Financial");
		List<SaveSearch>  sslist1 = new ArrayList<SaveSearch>();
		sslist1.add(ss1);
		agent1.setSaveSearchs(sslist1);
		
		agentRepository.save(agent1);
		Agent agent2 = new Agent("patpat", "CN", "pat", "patpatcn2015@gmail.com");
		Listing listing3 = new Listing(agent2, "123 Clay St, SF, CA", 1, 1, "Condo", "Chinatown", "San Francisco", "CA");
		Listing listing4 = new Listing(agent2, "1229 30th Ave, SF, CA", 1, 2, "House", "Sunset", "San Francisco", "CA");
		List<Listing> listingAgent2 = new ArrayList<>();
		listingAgent2.add(listing3);
		listingAgent2.add(listing4);
		agent2.setListings(listingAgent2);
		SaveSearch ss2 = new SaveSearch(agent2, 1, 2, "Apartment,House", "Financial,Sunset");
		List<SaveSearch>  sslist2 = new ArrayList<SaveSearch>();
		sslist2.add(ss2);
		
		agentRepository.save(agent2);
		
	}	
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public String testRest() {
		return "rest tested";
	}
	

}
