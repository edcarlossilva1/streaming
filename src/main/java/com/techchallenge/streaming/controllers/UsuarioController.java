package com.techchallenge.streaming.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.techchallenge.streaming.DTO.UsuarioDTO;
import com.techchallenge.streaming.services.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/usuario")
//
public class UsuarioController {
    
	//Atributo 
	
	@Autowired
	private final UsuarioService usuarioService;

	//Cosntrutor 
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    
    //Metodo de listar todos os registros
    @GetMapping
    public ResponseEntity<Page<UsuarioDTO>> findAll(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "10") Integer linesPerPage
    ) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage);
        var usuarios = usuarioService.findAll(pageRequest);
        return ResponseEntity.ok(usuarios);
    }

    //Metodo de listar registros pelo Id
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable Long id) {
        var usuario = usuarioService.findById(id);
        return ResponseEntity.ok(usuario);
    }

    //Metodos de salvar registros 
    @PostMapping
    public ResponseEntity<UsuarioDTO> save(@Valid @RequestBody UsuarioDTO dto) {
    	var usuario = usuarioService.save(dto);                                   
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand((usuario.getId())).toUri();
        return ResponseEntity.created(uri).body(usuario);
    }
 
    
    //Metodos de atualizar registros
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> update(
            @RequestBody UsuarioDTO dto,
            @PathVariable Long id) {
        var usuario = usuarioService.update(id, dto);
        return ResponseEntity.ok(usuario);
    }
    
    //Metodo de deletar registros 
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
