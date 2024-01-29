package com.techchallenge.streaming.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techchallenge.streaming.DTO.CategoriaDTO;
import com.techchallenge.streaming.DTO.FavoritoDTO;
import com.techchallenge.streaming.DTO.FilmeDTO;
import com.techchallenge.streaming.entities.Favorito;
import com.techchallenge.streaming.entities.Filme;
import com.techchallenge.streaming.entities.Usuario;
import com.techchallenge.streaming.exception.ControllerNotFoundException;
import com.techchallenge.streaming.repository.IFavoritoRepository;
import com.techchallenge.streaming.repository.IFilmeRepository;
import com.techchallenge.streaming.repository.IUsuarioRepository;


@Service
public class FavoritoService {
	    @Autowired
	    private final IFavoritoRepository favoritoRepository;
	    private final IUsuarioRepository usuarioRepository;
	    private final IFilmeRepository filmeRepository;
	    
		public FavoritoService(IFavoritoRepository favoritoRepository, IUsuarioRepository usuarioRepository,
				IFilmeRepository filmeRepository) {
			this.favoritoRepository = favoritoRepository;
			this.usuarioRepository = usuarioRepository;
			this.filmeRepository = filmeRepository;
		}
	    
//		public void adicionarFilmeAosFavoritos(Long usuarioId, Long filmeId) {
//	        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow();
//	        Filme filme = filmeRepository.findById(filmeId).orElseThrow();
//
//	        Favorito favorito = new Favorito();
//	        favorito.setUsuario(usuario);
//	        favorito.setFilme(filme);
//
//	        favoritoRepository.save(favorito);
//	    }
		//@Transactional
//		public void adicionarFilmeAosFavoritos(FavoritoDTO favoritoDTO) {
//	        Usuario usuario = usuarioRepository.findById(favoritoDTO.getUsuario().getId()).orElseThrow();
//	        Filme filme = filmeRepository.findById(favoritoDTO.getFilme().getId()).orElseThrow();
//
//	        Favorito favorito = new Favorito();
//	        favorito.setUsuario(usuario);
//	        favorito.setFilme(filme);
//
//	        favoritoRepository.save(favorito);
//	    }
		
}
