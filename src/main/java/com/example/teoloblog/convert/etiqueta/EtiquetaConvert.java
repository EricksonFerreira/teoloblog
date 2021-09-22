package com.example.teoloblog.convert.etiqueta;


import java.util.List;
import java.util.stream.Collectors;

import com.example.teoloblog.domain.etiqueta.Etiqueta;
import com.example.teoloblog.dto.etiqueta.EtiquetaDTO;
import com.example.teoloblog.dto.etiqueta.EtiquetaFormDTO;

public class EtiquetaConvert {
	
	private EtiquetaConvert() {
	}
	
	public static List<EtiquetaDTO> etiquetaDomainListToDTOlist(List<Etiqueta> domainList) {
			return domainList.stream().map(EtiquetaConvert::etiquetaDomainToDTO).collect(Collectors.toList());
	}

	public static EtiquetaDTO etiquetaDomainToDTO(Etiqueta domain) {
		return EtiquetaDTO.builder().codigo(domain.getCodigo()).nome(domain.getNome()).build();
	}
	
	public static Etiqueta etiquetaFormToEtiquetaEntity(EtiquetaFormDTO etiquetaForm) {
		return Etiqueta.builder().nome(etiquetaForm.getNome()).build();
	}

}