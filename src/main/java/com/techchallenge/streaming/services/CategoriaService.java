package com.techchallenge.streaming.services;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techchallenge.streaming.DTO.CategoriaDTO;
import com.techchallenge.streaming.entities.Categoria;
import com.techchallenge.streaming.exception.ControllerNotFoundException;
import com.techchallenge.streaming.exception.DatabaseException;
import com.techchallenge.streaming.repository.ICategoriaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoriaService {

	private final ICategoriaRepository repository;

	// Construtor
	public CategoriaService(ICategoriaRepository repo) {
		this.repository = repo;
	}

	// Não bloqueia o banco de dados na escrita fica mais rapido o banco
	@Transactional(readOnly = true)
	public CategoriaDTO findById(Long id) {
		var categoria = repository.findById(id)
				.orElseThrow(() -> new ControllerNotFoundException("Categoria não encontrada"));
		// return categoria.map(CategoriaDTO::fromEntity);
		return CategoriaDTO.fromEntity(categoria);
	}

	@Transactional(readOnly = true)
	public Page<CategoriaDTO> findAll(PageRequest pageRequest) {
		var categoria = repository.findAll(pageRequest);
		return categoria.map(CategoriaDTO::fromEntity);
	}

	@Transactional
	public CategoriaDTO insert(CategoriaDTO dto) {
		try {
			var entity = CategoriaDTO.toEntity(dto);
			var savedCategoria = repository.save(entity);
			return CategoriaDTO.fromEntity(savedCategoria);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Categoria não encontrada");
		}

	}

	@Transactional
	public CategoriaDTO update(Long id, CategoriaDTO dto) {
		try {
			Categoria entity = repository.getReferenceById(id);
			entity = CategoriaDTO.mapperDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return CategoriaDTO.fromEntity(entity);
		} catch (EntityNotFoundException e) {
			throw new ControllerNotFoundException("Categoria não encontrada, id: " + id);
		}

	}

	@Transactional
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ControllerNotFoundException("Categoria não encontrada" + id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Violação de Integridade");
		}

	}
	
	
}