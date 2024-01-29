package com.techchallenge.streaming.entities;

import java.time.LocalDate;

import com.techchallenge.streaming.DTO.FilmeDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_filme")
public class Filme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String descricao;
	private String url;
	private LocalDate dataLancamento;

	@ManyToOne
	@JoinColumn(name = "cd_ategoria")
	private Categoria categoria;

	public Filme() {
	}

	public Filme(Long id, String nome, String descricao, String url, LocalDate dataLancamento) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.url = url;
		this.dataLancamento = dataLancamento;
	}

	public Filme(FilmeDTO dto) {
		this.id = dto.getId();
		this.nome = dto.getNome();
		this.descricao = dto.getDescricao();
		this.url = dto.getUrl();
		this.dataLancamento = dto.getDataLancamento();
	}

	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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

	public void setCategoria(Long id2) {
		// TODO Auto-generated method stub
		
	}

}
