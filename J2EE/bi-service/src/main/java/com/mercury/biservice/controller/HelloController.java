package com.mercury.biservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.biservice.feign.ReportingServiceClient;
import com.mercury.biservice.feign.ShippingServiceClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class HelloController {
	
	@Autowired
	ReportingServiceClient reportingServiceClient;
	
	@Autowired
	ShippingServiceClient shippingServiceClient;
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello from BI service!"; 
	}

	@GetMapping("/hello-to-reporting")
	@HystrixCommand(fallbackMethod="helloToReportingFallback")
	public String helloToReporting() {
		String helloFromReportingService = reportingServiceClient.hello();
		return "Hello from BI service!" + " -> " + helloFromReportingService;
	}
	
	public String helloToReportingFallback() {
		return "Reporting service not available...";
	}
	
	@GetMapping("/hello-to-shipping")
	public String helloToShipping() {
		String helloFromShippingService = shippingServiceClient.hello();
		return "Hello from BI service!" + " -> " + helloFromShippingService;
	}
	
	@GetMapping("/hello-to-shipping-to-reporting")
	public String helloToShippingToReporting() {
		String helloFromShippingService = shippingServiceClient.helloToReporting();
		return "Hello from BI service!" + " -> " + helloFromShippingService;
	}
	
}
