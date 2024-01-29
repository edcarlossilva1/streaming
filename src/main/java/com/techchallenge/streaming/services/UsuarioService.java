package com.techchallenge.streaming.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.techchallenge.streaming.DTO.UsuarioDTO;
import com.techchallenge.streaming.entities.Usuario;
import com.techchallenge.streaming.exception.ControllerNotFoundException;
import com.techchallenge.streaming.exception.DatabaseException;
import com.techchallenge.streaming.repository.IUsuarioRepository;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class UsuarioService {
	 
	
	 private IUsuarioRepository repository;
	 
	 @Autowired
	 public UsuarioService(IUsuarioRepository repository) {
		 this.repository = repository;
	 }
	 
	 //Busca todos 
	 @Transactional
	 public Page<UsuarioDTO> findAll(PageRequest pageRequest){
		 var usuario = repository.findAll(pageRequest);
		 return usuario.map(UsuarioDTO::fromEntity);
		 
	 }
	 
	 //Busca por Id
	 @Transactional
	 public UsuarioDTO findById (Long id){
		 var usuario = repository.findById(id).orElseThrow(
				 () -> new ControllerNotFoundException("Usuario não encontrado"));
		 return UsuarioDTO.fromEntity(usuario);
	 }
	 
	 //Salvando
	 @Transactional
	 public UsuarioDTO save (UsuarioDTO dto){
		 var user = repository.findByEmail(dto.getEmail());
		 if (user != null) {
		      throw new ControllerNotFoundException("Usuário com o mesmo email já existe, email: " + dto.getEmail());
		    }
		 Usuario entity = UsuarioDTO.toEntity(dto);
		 var crypta = BCrypt.withDefaults().hashToString(12, entity.getPassword().toCharArray());	
          entity.setPassword(crypta);
		 var saved = repository.save(entity);
		 return UsuarioDTO.fromEntity(saved);
	 }
	 
	 //Atualizando
	 @Transactional
	 public UsuarioDTO update(Long id, UsuarioDTO usuarioDto) {
		 try {
			 Usuario entity = repository.getReferenceById(id);
			 UsuarioDTO.mapperDtoToEntity(usuarioDto, entity);
			 entity = repository.save(entity);
			 return UsuarioDTO.fromEntity(entity); 
		 } catch(EntityNotFoundException e) {
			 throw new ControllerNotFoundException("Usuario não encontrado" + id);
		 }
	 }
	 
	 //Deletando
	 @Transactional
	 public void delete(Long id) {
		 try {
			 repository.deleteById(id);
		 }catch(DataIntegrityViolationException e){
			throw new DatabaseException("Violação de integridade dos dados");
		 }
	 }
}


 
