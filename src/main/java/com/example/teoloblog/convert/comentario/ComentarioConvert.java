package com.example.teoloblog.convert.comentario;

import com.example.teoloblog.convert.publicacao.PublicacaoConvert;
import com.example.teoloblog.convert.usuario.UsuarioConvert;
import com.example.teoloblog.domain.comentario.Comentario;
import com.example.teoloblog.dto.comentario.ComentarioDTO;
import com.example.teoloblog.dto.comentario.ComentarioFormDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ComentarioConvert {
    private ComentarioConvert() {
	}

	public static List<ComentarioDTO> comentarioDomainListToDTOlist(List<Comentario> domainList) {
			return domainList.stream().map(ComentarioConvert::comentarioDomainToDTO).collect(Collectors.toList());
	}

	public static ComentarioDTO comentarioDomainToDTO(Comentario domain) {
		return ComentarioDTO.builder().codigo(domain.getCodigo())
								 .texto(domain.getTexto())
								 .data(domain.getData())
								 .usuario(UsuarioConvert.usuarioDomainToDTO(domain.getUsuario()))
								 .publicacao(PublicacaoConvert.publicacaoDomainToDTO(domain.getPublicacao()))
								 .build();
	}
}
