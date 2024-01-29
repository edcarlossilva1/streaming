package com.techchallenge.streaming.DTO;

import com.techchallenge.streaming.entities.Usuario;

public class UsuarioDTO {

	// Atributos
	private Long id;
	private String username;
    private String email;
	private String password;

	// Construtor vazio
	public UsuarioDTO() {

	}

	 //Construtor populado
	public UsuarioDTO(Long id, String username, String email, String password) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
	public UsuarioDTO(Usuario entity) {
		this.id = entity.getId();
		this.username = entity.getUsername();
		this.email = entity.getEmail();
		this.password = entity.getPassword();
	}

	// Getters e Setters
	public Long getId() {
		return id;
	}


	public String getUsername() {
		return username;
	}


	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}


	// METODO PARA ENTIDADE
	public static Usuario toEntity(UsuarioDTO usuarioDto) {
		return new Usuario(usuarioDto);
	}


	// METODO DA ENTIDADE
	public static UsuarioDTO fromEntity(Usuario usuario) {
		return new UsuarioDTO(
		usuario.getId(), 
		usuario.getUsername(), 
		usuario.getEmail(),
		usuario.getPassword()
		);
	}

    // Criando o Metodo Mapper para utilização no update 
	public static Usuario mapperDtoToEntity(UsuarioDTO Dto, Usuario entity) {
		entity.setUsername(Dto.getUsername());
		entity.setEmail(Dto.getEmail());
		return entity;
	}
}
