package com.example.apiGarbageSimulation.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.apiGarbageSimulation.entities.Usuario;


public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
	Usuario findByUsername(String username);
}
