package com.example.apiGarbageSimulation.services.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import com.example.apiGarbageSimulation.entities.Usuario;
import com.example.apiGarbageSimulation.repositories.UsuarioRepository;
import com.example.apiGarbageSimulation.services.IAuthenticationService;

@Service
@Configurable
public class AuthenticationService implements IAuthenticationService{
	
	@Autowired
	UsuarioRepository usuarioRepo;
	
	public Usuario searchUserBD(String username) {
		return usuarioRepo.findByUsername(username);
	}

	public String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username)
				/*.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))*/
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}
}
