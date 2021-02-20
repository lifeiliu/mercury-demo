package com.mercury.biservice.feign;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//@FeignClient(name="reporting-service", url="localhost:8901")
@FeignClient(name="reporting-service")
@RibbonClient(name="reporting-service")
public interface ReportingServiceClient {

	@GetMapping("/hello")
	String hello();
	
}
