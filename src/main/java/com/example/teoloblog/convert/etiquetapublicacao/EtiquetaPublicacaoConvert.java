package com.example.teoloblog.convert.etiquetapublicacao;

import com.example.teoloblog.domain.etiquetapublicacao.EtiquetaPublicacao;
import com.example.teoloblog.dto.etiquetapublicacao.EtiquetaPublicacaoDTO;

public class EtiquetaPublicacaoConvert {
    private EtiquetaPublicacaoConvert() {
	}

    public static EtiquetaPublicacaoDTO etiquetaPublicacaoDomainToDTO(EtiquetaPublicacao domain) {
		return EtiquetaPublicacaoDTO.builder()
                                    .etiqueta(domain.getId().getEtiqueta())
                                    .publicacao(domain.getId().getPublicacao())
                                    .build();
	}
}
