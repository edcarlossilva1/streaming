package com.techchallenge.streaming.entities;

import com.techchallenge.streaming.DTO.FavoritoDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_favorito")
public class Favorito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "filme_id")
    private Filme filme;

    public Favorito() {
		
	}
    
    
	public Favorito(Long id, Usuario usuario, Filme filme) {
		this.id = id;
		this.usuario = usuario;
		this.filme = filme;
	}
	
	public Favorito(FavoritoDTO dto) {
		this.id = dto.getId();
		this.usuario = dto.getUsuario();
		this.filme = dto.getFilme();
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

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}
    
    
	
}