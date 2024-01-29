package com.techchallenge.streaming.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techchallenge.streaming.DTO.FilmeDTO;
import com.techchallenge.streaming.entities.Titulo;
import com.techchallenge.streaming.services.FilmeService;

@RestController
@RequestMapping("/filme")
public class FilmeController extends Titulo {

	private final FilmeService service;

	public FilmeController(FilmeService service) {
		this.service = service;
	}

	// Metodo de listar todos os registros
	@GetMapping
 
    public ResponseEntity<Page<FilmeDTO>> findAll(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "10") Integer linesPerPage,
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataPublicacao
    ) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage);
        var filme = service.findAll(pageRequest);
        return ResponseEntity.ok(filme);
    }

	// Metodo de listar registros pelo Id
	@GetMapping("/{id}")
	public ResponseEntity<FilmeDTO> findById(@PathVariable Long id) {
		var filme = service.findById(id);
		return ResponseEntity.ok(filme);
	}

	@PostMapping("/adicionar-com-categoria/{categoriaId}")
	public ResponseEntity<FilmeDTO> adicionarFilmeComCategoria(@RequestBody FilmeDTO filmeDTO,
			@PathVariable Long categoriaId) {

		FilmeDTO novoFilme = service.adicionarFilmeComCategoria(filmeDTO, categoriaId);

		return ResponseEntity.status(HttpStatus.CREATED).body(novoFilme);
	}

//    @PostMapping("/adicionar/{categoriaId}")
//    public ResponseEntity<FilmeDTO> adicionarFilmeComCategoria(@RequestBody FilmeDTO filmeDTO, @PathVariable Long categoriaId) {
//        Filme novoFilme = service.adicionarFilmeComCategoria(filmeDTO, categoriaId);
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(FilmeDTO.fromEntity(novoFilme));
//    }

	@GetMapping("/por-categoria/{categoriaId}")
	public ResponseEntity<List<FilmeDTO>> listarFilmesPorCategoria(@PathVariable Long categoriaId) {
		List<FilmeDTO> filmes = service.listarFilmesPorCategoria(categoriaId);

		return ResponseEntity.ok(filmes);
	}

//    @PutMapping("/{filmeId}/categoria/{categoriaId}")
//    public ResponseEntity<FilmeDTO> atualizarFilmeComCategoria(
//            @PathVariable Long filmeId,
//            @RequestBody FilmeDTO filmeDTO,
//            @PathVariable Long categoriaId) {
//
//        FilmeDTO filmeAtualizado = service.atualizarFilme(filmeId, filmeDTO, categoriaId);
//        return ResponseEntity.ok(filmeAtualizado);
//    }
//    
    @PutMapping("/{filmeId}/categoria/{categoriaId}")
    public ResponseEntity<FilmeDTO> atualizarFilme(
            @PathVariable Long id,
            @RequestBody FilmeDTO filmeDTO,
            @PathVariable Long novaCategoriaId) {
        FilmeDTO filmeAtualizado = service.atualizarFilme(id, filmeDTO, novaCategoriaId);
        return ResponseEntity.ok(filmeAtualizado);
    }

	@DeleteMapping("/{filmeId}")
	public ResponseEntity<Void> deletarFilmeComCategoria(@PathVariable Long filmeId) {
		service.deletarFilmeComCategoria(filmeId);
		return ResponseEntity.noContent().build();
	}
}
