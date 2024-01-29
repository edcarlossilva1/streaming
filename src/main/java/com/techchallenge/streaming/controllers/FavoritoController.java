package com.techchallenge.streaming.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techchallenge.streaming.DTO.FavoritoDTO;
import com.techchallenge.streaming.entities.Favorito;
import com.techchallenge.streaming.services.FavoritoService;

@RestController
@RequestMapping(value = "/favorito")
public class FavoritoController {

	@Autowired
    private FavoritoService service;
	

public FavoritoController(FavoritoService service) {
		this.service = service;
	}


//	@PostMapping("/adicionar")
//    public ResponseEntity<String> adicionarFilmeAosFavoritos(@RequestParam Long usuarioId, @RequestParam Long filmeId) {
//        favoritoService.adicionarFilmeAosFavoritos(usuarioId, filmeId);
//        return ResponseEntity.ok("Filme adicionado aos favoritos com sucesso.");
//    }
	
	 @PostMapping("/adicionar")
	    public ResponseEntity<FavoritoDTO> adicionarFilmeAosFavoritos(@RequestBody FavoritoDTO dto, @RequestBody Long id) {
	        Favorito salved = service.adicionarFilmeAosFavoritos(dto, id);
	       
	        //return ResponseEntity.ok("Filme adicionado aos favoritos com sucesso.");
	        return ResponseEntity.status(HttpStatus.CREATED).body(FavoritoDTO.fromEntity(salved));
	    }
}
