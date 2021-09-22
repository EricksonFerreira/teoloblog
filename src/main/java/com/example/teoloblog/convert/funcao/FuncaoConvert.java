package com.example.teoloblog.convert.funcao;

import com.example.teoloblog.domain.funcao.Funcao;
import com.example.teoloblog.dto.funcao.FuncaoDTO;
import com.example.teoloblog.dto.funcao.FuncaoFormDTO;

import java.util.List;
import java.util.stream.Collectors;

public class FuncaoConvert {
  	private FuncaoConvert() {
	}
	
	public static List<FuncaoDTO> funcaoDomainListToDTOlist(List<Funcao> domainList) {
			return domainList.stream().map(FuncaoConvert::funcaoDomainToDTO).collect(Collectors.toList());
	}

	public static FuncaoDTO funcaoDomainToDTO(Funcao domain) {
		return FuncaoDTO.builder().codigo(domain.getCodigo()).nome(domain.getNome()).build();
	}
	
	public static Funcao funcaoFormToFuncaoEntity(FuncaoFormDTO funcaoForm) {
		return Funcao.builder().nome(funcaoForm.getNome()).build();
	}

}
