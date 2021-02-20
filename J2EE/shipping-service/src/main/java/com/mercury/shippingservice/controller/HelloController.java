package com.mercury.shippingservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.shippingservice.feign.ReportingServiceClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class HelloController {
	
	@Autowired
	ReportingServiceClient reportingServiceClient;

	@GetMapping("/hello")
	public String hello() {
		return "Hello from Shipping service!"; 
	}
	
	@GetMapping("/hello-to-reporting")
	@HystrixCommand(fallbackMethod="helloToReportingFallback")
	public String helloToReporting() {
		String helloFromReportingService = reportingServiceClient.hello();
		return "Hello from Shipping service!" + " -> " + helloFromReportingService;
	}
	
	public String helloToReportingFallback() {
		return "Hello from Shipping service! -> Reporting service not available...";
	}
	
}
