package com.mercury.shippingservice.feign;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="reporting-service")
@RibbonClient(name="reporting-service")
public interface ReportingServiceClient {

	@GetMapping("/hello")
	String hello();
	
}
