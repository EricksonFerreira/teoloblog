package com.example.teoloblog.convert.autor;


import java.util.List;
import java.util.stream.Collectors;

import com.example.teoloblog.domain.autor.Autor;
import com.example.teoloblog.dto.autor.AutorDTO;
import com.example.teoloblog.dto.autor.AutorFormDTO;

public class AutorConvert {
	
	private AutorConvert() {
	}
	
	public static List<AutorDTO> autorDomainListToDTOlist(List<Autor> domainList) {
			return domainList.stream().map(AutorConvert::autorDomainToDTO).collect(Collectors.toList());
	}

	public static AutorDTO autorDomainToDTO(Autor domain) {
		return AutorDTO.builder().codigo(domain.getCodigo())
								 .nome(domain.getNome())
								 .descricao(domain.getDescricao())
								 .imagem(domain.getImagem())
								 .build();
	}
	
	public static Autor autorFormToAutorEntity(AutorFormDTO autorForm) {
		return Autor.builder().nome(autorForm.getNome())
							  .descricao(autorForm.getDescricao())
							  .imagem(autorForm.getImagem())
							  .build();
	}

}