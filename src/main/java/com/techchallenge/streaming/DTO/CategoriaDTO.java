package com.techchallenge.streaming.DTO;

import com.techchallenge.streaming.entities.Categoria;

public class CategoriaDTO {

	private Long id;
	private String nome;

	public CategoriaDTO() {
	}
	
	public CategoriaDTO(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	// METODO PARA ENTIDADE
	public static Categoria toEntity(CategoriaDTO dto) {
		return new Categoria(dto);
	}


	// METODO DA ENTIDADE
	public static CategoriaDTO fromEntity(Categoria entity) {
		return new CategoriaDTO(
				entity.getId(),
				entity.getNome()
		);
	}

    // Criando o Metodo Mapper para utilização no update 
	public static Categoria mapperDtoToEntity(CategoriaDTO dto, Categoria entity) {
		entity.setNome(dto.getNome());
		return entity;
	}
	

}

