package com.example.productservice.externals;
 
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("user-service")
public interface UserServiceClient {
 
	@RequestMapping(method = RequestMethod.GET , value = "/user/{id}")
    User getUser(@PathVariable("id") Long id);
}

