package com.kostasvr.geoNamesProject;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cache.CacheManager;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import redis.embedded.RedisServer;

@Component
public class ApplicationStartup 
implements ApplicationListener<ApplicationReadyEvent> {

  private final Logger LOG = LoggerFactory.getLogger(getClass());
  
  @Autowired
  private CacheManager cacheManager;
  
  @Scheduled(fixedRate = 10000)
  public void reportCurrentTime() {
		System.out.println("im ready to delete the cache");
        cacheManager.getCache("weather").clear();
  }
  
  
  /**
   * This event is executed as late as conceivably possible to indicate that 
   * the application is ready to service requests.
   */
  @Override
  public void onApplicationEvent(final ApplicationReadyEvent event) {
	  LOG.info("Starting..");
	  RedisServer redisServer;
	try {
		redisServer = new RedisServer(6379);
		redisServer.start();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  cacheManager.getCache("weather").clear();
	  cacheManager.getCache("boundingBox").clear();
  }
}