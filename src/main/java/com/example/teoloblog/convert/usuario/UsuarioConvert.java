package com.example.teoloblog.convert.usuario;


import java.util.List;
import java.util.stream.Collectors;

import com.example.teoloblog.domain.usuario.Usuario;
import com.example.teoloblog.dto.usuario.UsuarioDTO;
import com.example.teoloblog.dto.usuario.UsuarioFormDTO;

public class UsuarioConvert {
	
	private UsuarioConvert() {
	}
	
	public static List<UsuarioDTO> usuarioDomainListToDTOlist(List<Usuario> domainList) {
			return domainList.stream().map(UsuarioConvert::usuarioDomainToDTO).collect(Collectors.toList());
	}

	public static UsuarioDTO usuarioDomainToDTO(Usuario domain) {
		return UsuarioDTO.builder().codigo(domain.getCodigo()).nome(domain.getNome()).build();
	}
	
	public static Usuario usuarioFormToUsuarioEntity(UsuarioFormDTO usuarioForm) {
		return Usuario.builder().nome(usuarioForm.getNome()).build();
	}

}