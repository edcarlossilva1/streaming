package com.techchallenge.streaming.entities;

import java.util.Set;

import com.techchallenge.streaming.DTO.UsuarioDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String email;
	private String password;
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private Set<Favorito> favoritos;

	// Construtor vazio
	public Usuario() {

	}

	// Construtor populado
	public Usuario(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public Usuario(UsuarioDTO dto) {
		this.id = dto.getId();
		this.username = dto.getUsername();
		this.email = dto.getEmail();
		this.password = dto.getPassword();
	}

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Favorito> getFavoritos() {
		return favoritos;
	}
	

}
