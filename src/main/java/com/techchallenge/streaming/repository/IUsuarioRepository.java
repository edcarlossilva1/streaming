package com.techchallenge.streaming.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techchallenge.streaming.entities.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long>{
	//Metodo para verificar se existe o email informado no banco
	 Usuario findByEmail(String email);
}

