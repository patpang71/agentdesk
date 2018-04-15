package com.agentdesk.market.util;

import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.agentdesk.market.domain.SaveSearch;
import com.agentdesk.market.service.SaveSearchService;

@Component
public class ScheduledTask {
	
	@Autowired
	private SaveSearchService saveSearchService;
	
	@Autowired
	private Environment env;	
	
	@Scheduled(cron="0 0 8 * * *")
	public void runTask() {
		//System.out.println("SaveSearchService: " + saveSearchService.toString());
		String fromEmail = env.getProperty("support.email");
		Properties props = new Properties();
		props.put("mail.smtp.host", env.getProperty("mail.smtp.host"));
		props.put("mail.smtp.socketFactory.port", 
				env.getProperty("mail.smtp.socketFactory.port"));
		props.put("mail.smtp.socketFactory.class",
				env.getProperty("mail.smtp.socketFactory.class"));
		props.put("mail.smtp.auth", env.getProperty("mail.smtp.auth"));
		props.put("mail.smtp.port", env.getProperty("mail.smtp.port"));
		
		List<SaveSearch> saveSearches = saveSearchService.findAll();
		Set<String> emailSet = new HashSet<>();
		for (SaveSearch ss : saveSearches) {
			if (ss.getAgent()!=null) {
				emailSet.add(ss.getAgent().getEmail());
			}
			List<String> ans = saveSearchService.findListing(ss);
			for (String a : ans) {
				emailSet.add(a);
			}
		}
		String[] toEmails = new String[emailSet.size()];
		int idx = 0;
		for (String e : emailSet) {
			toEmails[idx++] = e;
		}
		try {
			SendMail.sendEmailMessage(props, toEmails, fromEmail, 
					env.getProperty("spring.mail.password"), 
					env.getProperty("email.subject"), 
					env.getProperty("email.message"));
		} catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
