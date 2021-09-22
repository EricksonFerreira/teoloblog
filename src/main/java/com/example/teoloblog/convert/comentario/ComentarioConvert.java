package com.example.teoloblog.convert.comentario;

import com.example.teoloblog.domain.comentario.Comentario;
import com.example.teoloblog.dto.comentario.ComentarioDTO;
import com.example.teoloblog.dto.comentario.ComentarioFormDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ComentarioConvert {
    private ComentarioConvert() {
	}

	public static List<ComentarioDTO> autorDomainListToDTOlist(List<Comentario> domainList) {
			return domainList.stream().map(ComentarioConvert::autorDomainToDTO).collect(Collectors.toList());
	}

	public static ComentarioDTO autorDomainToDTO(Comentario domain) {
		return ComentarioDTO.builder().codigo(domain.getCodigo())
								 .texto(domain.getTexto())
								 .data(domain.getData())
								 .usuario(UsuarioConvert.usuarioDomainToDTO(domain.getUsuario()))
								 .imagem(domain.getImagem())
								 .build();
	}

	public static Comentario autorFormToAutorEntity(ComentarioFormDTO autorForm) {
		return Comentario.builder().nome(autorForm.getNome())
							  .descricao(autorForm.getDescricao())
							  .imagem(autorForm.getImagem())
							  .build();
	}
}
