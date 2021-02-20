package com.mercury.biservice.feign;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="shipping-service")
@RibbonClient(name="shipping-service")
public interface ShippingServiceClient {

	@GetMapping("/hello")
	String hello();
	
	@GetMapping("/hello-to-reporting")
	String helloToReporting();
	
}
