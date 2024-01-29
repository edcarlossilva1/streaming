package com.techchallenge.streaming.entities;

import com.techchallenge.streaming.DTO.CategoriaDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
//    @OneToMany(mappedBy = "categoria"/*, cascade = CascadeType.ALL*/)
//    private List<Filme> filmes = new ArrayList<>();

	
	public Categoria() {

	}

	public Categoria(Long id, String nome) {

		this.id = id;
		this.nome = nome;
	}
	
	public Categoria(CategoriaDTO dto) {
		this.id = dto.getId();
		this.nome = dto.getNome();
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

}

