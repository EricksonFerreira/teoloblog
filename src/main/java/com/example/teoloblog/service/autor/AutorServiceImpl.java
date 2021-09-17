package com.example.teoloblog.service.autor;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.teoloblog.convert.autor.AutorConvert;
import com.example.teoloblog.domain.autor.Autor;
import com.example.teoloblog.dto.autor.AutorDTO;
import com.example.teoloblog.dto.autor.AutorFormDTO;
import com.example.teoloblog.repository.autor.AutorRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AutorServiceImpl implements AutorService {

	private final AutorRepository autorRepository;

	@Override
	public List<AutorDTO> listarAutors() {

		List<Autor> autorList = autorRepository.findAll();
		return AutorConvert.autorDomainListToDTOlist(autorList);
	}

	@Override
	public AutorDTO buscarAutorPorId(Integer codigoAutor) throws Exception {
		Optional<Autor> autorOpt = autorRepository.findById(codigoAutor);
		
		if (!autorOpt.isPresent()) {
			throw new Exception("Autor não encontrada");
		}
		
		return AutorConvert.autorDomainToDTO(autorOpt.get());
	}

	@Override
	public AutorDTO adicionarAutor(AutorFormDTO autorForm) {
		
		Autor author = AutorConvert.autorFormToAutorEntity(autorForm);
		autorRepository.save(author);
		
		return AutorConvert.autorDomainToDTO(author);
	}

	@Override
	public AutorDTO editarAutor(Integer codigoAutor, AutorFormDTO autorForm) throws Exception {
		Optional<Autor> autorOpt = autorRepository.findById(codigoAutor);
		
		if (!autorOpt.isPresent()) {
			throw new Exception("Autor não encontrada");
		}
		
		Autor author = autorOpt.get();
		
		author.setNome(autorForm.getNome());
		autorRepository.save(author);
		
		return AutorConvert.autorDomainToDTO(author);
	}

	@Override
	public void excluirAutor(Integer codigoAutor) throws Exception {
		Optional<Autor> autorOpt = autorRepository.findById(codigoAutor);
		
		if (!autorOpt.isPresent()) {
			throw new Exception("Autor não encontrada");
		}
		
		autorRepository.delete(autorOpt.get());
	}

}