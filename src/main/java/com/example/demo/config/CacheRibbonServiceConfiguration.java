package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;

public class CacheRibbonServiceConfiguration {
	@Autowired
	private IClientConfig ribbonClientconfig;
	
	@Bean
	private IPing ping(IClientConfig clientConfig) {
		return new PingUrl();
	}
	
	@Bean
	private IRule rule(IClientConfig clientConfig) {
		return new AvailabilityFilteringRule();
	}

}