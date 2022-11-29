package com.ts.tserp.controller;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ts.tserp.model.Role;
import com.ts.tserp.model.User;
import com.ts.tserp.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TokenController {
	
	private final UserService userService;
	
	@GetMapping("/token/refresh")
	public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws  IOException {
		String authorizationHeader = request.getHeader(AUTHORIZATION);
		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			try {
				String refresh_token = authorizationHeader.substring("Bearer ".length());
				Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
				JWTVerifier verifier = JWT.require(algorithm).build();
				DecodedJWT decodedJWT = verifier.verify(refresh_token);					
				String username = decodedJWT.getSubject();
				User user = userService.getUser(username);

				String access_token = JWT.create()
						 .withSubject(user.getUsername())
						 .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
						 .withIssuer(request.getRequestURL().toString())
						 .withClaim("roles", user.getRoles().stream().map(Role::getName).collect(Collectors.toList()))
						 .sign(algorithm);

								
				Map<String, String> tokens = new HashMap<>();
				tokens.put("access_token", "Bearer " + access_token);
				tokens.put("refresh_token", "Bearer " + refresh_token);
				response.setContentType(MediaType.APPLICATION_JSON_VALUE);
				new ObjectMapper().writeValue(response.getOutputStream(), tokens);

			} catch (Exception e) {
				response.setHeader("error", e.getMessage());
			//	response.sendError(HttpStatus.FORBIDDEN.value());
				response.setStatus(HttpStatus.FORBIDDEN.value());
				Map<String, String> error = new HashMap<>();
				error.put("error_message", e.getMessage());
				response.setContentType(MediaType.APPLICATION_JSON_VALUE);
				new ObjectMapper().writeValue(response.getOutputStream(), error);
			}				
		} else {
			throw new RuntimeException("Refresh token is missing");
		}
	}
}
