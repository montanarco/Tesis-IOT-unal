package com.example.apiGarbageSimulation.services;

import com.example.apiGarbageSimulation.entities.Usuario;

public interface IAuthenticationService {

	String getJWTToken(String username);
	
	Usuario searchUserBD(String username);
}
