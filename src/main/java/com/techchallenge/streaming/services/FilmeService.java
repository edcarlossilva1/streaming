package com.techchallenge.streaming.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techchallenge.streaming.DTO.CategoriaDTO;
import com.techchallenge.streaming.DTO.FilmeDTO;
import com.techchallenge.streaming.entities.Categoria;
import com.techchallenge.streaming.entities.Filme;
import com.techchallenge.streaming.exception.ControllerNotFoundException;
import com.techchallenge.streaming.repository.IFilmeRepository;

@Service
public class FilmeService {

	@Autowired
	private final IFilmeRepository repository;
	@Autowired
	private CategoriaService categoriaService;

	public FilmeService(IFilmeRepository repository) {
		this.repository = repository;
	}

	// Busca todos
	@Transactional(readOnly = true)
	public Page<FilmeDTO> findAll(PageRequest pageRequest) {
		var usuario = repository.findAll(pageRequest);
		return usuario.map(FilmeDTO::fromEntity);

	}

	// Busca por Id
	@Transactional(readOnly = true)
	public FilmeDTO findById(Long id) {
		var filme = repository.findById(id)
				.orElseThrow(() -> new ControllerNotFoundException("Usuario não encontrado"));
		return FilmeDTO.fromEntity(filme);
	}

	
	@Transactional(readOnly = true) 
	public List<FilmeDTO> listarFilmesPorCategoria(Long id) {
		List<Filme> filmes = repository.findAll(); // Ou qualquer outra lógica de busca que você desejar

		// Filtra os filmes pela categoria
		List<Filme> filmesPorCategoria = filmes.stream()
				.filter(filme -> filme.getCategoria() != null && filme.getCategoria().getId().equals(id))
				.collect(Collectors.toList());

		return filmesPorCategoria.stream().map(FilmeDTO::fromEntity).collect(Collectors.toList());
	}

	//Inserindo
    @Transactional
	public FilmeDTO adicionarFilmeComCategoria(FilmeDTO filmeDTO, Long categoriaId) {
		CategoriaDTO categoriaDTO = categoriaService.findById(categoriaId);

		// Verifique se a categoria foi encontrada
		if (categoriaDTO == null) {
			throw new ControllerNotFoundException("Categoria não encontrada para a ID: " + categoriaId);
		}
		Filme filme = FilmeDTO.toEntity(filmeDTO);
		filme.setCategoria(CategoriaDTO.toEntity(categoriaDTO));

		Filme novoFilme = repository.save(filme);

		return FilmeDTO.fromEntity(novoFilme);
	}
    
 
	//Deletando o filme 
	@Transactional
	public void deletarFilmeComCategoria(Long filmeId) {
		Filme filme = repository.findById(filmeId)
				.orElseThrow(() -> new ControllerNotFoundException("Filme não encontrado para a ID: " + filmeId));

		Categoria categoria = filme.getCategoria();
		if (categoria != null) {
			categoriaService.delete(categoria.getId());
		}

		repository.deleteById(filmeId);
	}
	
//	@Transactional
//	public FilmeDTO atualizarFilme(Long id, FilmeDTO filmeDTO, Long novaCategoriaId) {
//		// Verifica se o filme existe no repositório
//		Filme filmeExistente = repository.findById(id)
//				.orElseThrow(() -> new ControllerNotFoundException("Filme não encontrado para a ID: " + id));
//
//		// Atualiza as informações do filme com base no DTO recebido
//		filmeExistente.setNome(filmeDTO.getNome());
//		filmeExistente.setDescricao(filmeDTO.getDescricao());
//		filmeExistente.setDataLancamento(filmeDTO.getDataLancamento());
//
//		// Verifica se a nova categoria existe
//		CategoriaDTO novaCategoriaDTO = categoriaService.findById(novaCategoriaId);
//		if (novaCategoriaDTO == null) {
//			throw new ControllerNotFoundException("Categoria não encontrada para a ID: " + novaCategoriaId);
//		}
//
//		// Atualiza a categoria do filme
//		filmeExistente.setCategoria(CategoriaDTO.toEntity(novaCategoriaDTO));
//
//		// Salva as alterações no repositório
//		Filme filmeAtualizado = repository.save(filmeExistente);
//
//		return FilmeDTO.fromEntity(filmeAtualizado);
//	}
	 @Transactional
	    public FilmeDTO atualizarFilme(Long filmeId, FilmeDTO filmeDTO, Long id) {
	        Filme filme = repository.findById(filmeId)
	                .orElseThrow(() -> new ControllerNotFoundException("Filme não encontrado para a ID: " + filmeId));

	        // Atualiza os atributos do filme
	        Filme filmeAtualizado = FilmeDTO.mapperDtoToEntity(filmeDTO, filme);
	        filmeAtualizado.setNome(filmeDTO.getNome());
			filmeAtualizado.setDescricao(filmeDTO.getDescricao());
			filmeAtualizado.setDataLancamento(filmeDTO.getDataLancamento());
	        // Obtém a categoria associada ao filme
	        CategoriaDTO categoria = categoriaService.findById(id);

	        // Verifica se a categoria foi encontrada
	        if (categoria == null) {
	            throw new ControllerNotFoundException("Categoria não encontrada para a ID: " + id);
	        }

	        // Atualiza a categoria associada ao filme
	        //filmeAtualizado.setCategoria(categoria.getId());
	        filmeAtualizado.setCategoria(CategoriaDTO.toEntity(categoria));

	        // Salva o filme atualizado
	        Filme filmeSalvo = repository.save(filmeAtualizado);

	        return FilmeDTO.fromEntity(filmeSalvo);
	    }
	
	
	
	
}
