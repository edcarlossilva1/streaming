package com.techchallenge.streaming.DTO;

import java.time.LocalDate;

import com.techchallenge.streaming.entities.Categoria;
import com.techchallenge.streaming.entities.Filme;


public class FilmeDTO  {
	
	
	 // Lista por causa da repetição
	private Long id;
	private String nome;
	private String descricao; 
	private String url;
	private LocalDate dataLancamento;
	private Categoria categoria;
	

	//1º Construitor da classe DTO vazio
	public FilmeDTO() {
	}

	//2º Construtor da classe DTO populado
	   public FilmeDTO(Long id, String nome, String descricao, String url, LocalDate dataLancamento) {
			this.id = id;
			this.nome = nome;
			this.descricao = descricao;
			this.url = url;
			this.dataLancamento = dataLancamento;
		}

	// 3º Construtor para mapeamento da minha entidade para a DTO
	public FilmeDTO(Filme entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.nome = entity.getDescricao();
		this.dataLancamento = entity.getDataLancamento();
	}
	
	public Long getId() {
		return id;
	}
	
	

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}
	
	

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	// METODO PARA ENTIDADE
	public static Filme toEntity(FilmeDTO dto) {
		return new Filme(dto);
	}
	
	

	// METODO DA ENTIDADE
	public static FilmeDTO fromEntity(Filme filme) {
		return new FilmeDTO(
				filme.getId(), 
				filme.getNome(), 
				filme.getDescricao(),
				filme.getUrl(),
				filme.getDataLancamento()
		);
	}

    // Criando o Metodo Mapper para utilização no update 
	public static Filme mapperDtoToEntity(FilmeDTO dto, Filme entity) {
		entity.setNome(dto.getNome());
		entity.setDescricao(dto.getDescricao());
		entity.setUrl(dto.getUrl());
		return entity;
	}
	
}
