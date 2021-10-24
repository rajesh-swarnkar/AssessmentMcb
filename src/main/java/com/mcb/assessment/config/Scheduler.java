package com.mcb.assessment.config;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.mcb.assessment.entity.LoginUser;
import com.mcb.assessment.repository.UserRepository;
import com.mcb.assessment.service.UserService;

@Component
public class Scheduler {
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository repository;
	
	
   @Scheduled(cron = "0 0 0/1 1/1 * ?")
   public void cronJobSch() {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
      Date now = new Date();
      String strDate = sdf.format(now);
      List<LoginUser> users= repository.findAll();
      List<String> usernames=users.stream().filter(s-> s.getAttempt()>=3 && s.getDate().plusDays(1).isAfter(LocalDateTime.now())).map(s->s.getUsername()).collect(Collectors.toList());
      usernames.forEach(username->{
    		  userService.updateAttemptZero(username);
      });
      
      System.out.println("Java cron job expression:: " + strDate);
   }
}