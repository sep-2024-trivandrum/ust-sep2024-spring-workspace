package com.demo.api_gateway.filter;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Component
public class RouteValidator {
	// list of urls to be ignored by the api-gateway filter
	public static final List<String> openApiEndpoints = List.of("/api/auth/register", 
																"/api/auth/validate/user",
																"/api/auth/validate/token");	
	public Predicate<ServerHttpRequest> isSecured = request -> openApiEndpoints
																	.stream()
																	.noneMatch(uri -> request
																						.getURI()
																						.getPath()
																						.contains(uri));
}
