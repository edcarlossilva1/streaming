package com.techchallenge.streaming.DTO;

import com.techchallenge.streaming.entities.Favorito;
import com.techchallenge.streaming.entities.Filme;
import com.techchallenge.streaming.entities.Usuario;

public class FavoritoDTO {
	
	private Long id;
	private Usuario usuario;
	private Filme filme;
	
	
	public FavoritoDTO() {
	}

	
	public FavoritoDTO(Long id, Filme filme, Usuario usuario) {
		this.id = id;
		this.usuario = usuario;
		this.filme = filme;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}


	public Filme getFilme() {
		return filme;
	}


	// METODO PARA ENTIDADE
	public static Favorito toEntity(FavoritoDTO dto) {
		return new Favorito(dto);
	}


	// METODO DA ENTIDADE
	public static FavoritoDTO fromEntity(Favorito entity) {
		return new FavoritoDTO(
				entity.getId(),
				entity.getFilme(),
				entity.getUsuario()
		);
	}

    // Criando o Metodo Mapper para utilização no update 
	public static Favorito mapperDtoToEntity(FavoritoDTO dto, Favorito entity) {
		entity.setFilme(dto.getFilme());
		entity.setUsuario(dto.getUsuario());
		return entity;
	}


}
