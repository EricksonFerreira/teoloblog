package com.example.teoloblog.convert.referencia;

import java.util.List;
import java.util.stream.Collectors;

import com.example.teoloblog.convert.publicacao.PublicacaoConvert;
import com.example.teoloblog.domain.referencia.Referencia;
import com.example.teoloblog.dto.publicacao.PublicacaoDTO;
import com.example.teoloblog.dto.referencia.ReferenciaDTO;
import com.example.teoloblog.dto.referencia.ReferenciaFormDTO;

public class ReferenciaConvert {
    private ReferenciaConvert(){

    }

    public static List<ReferenciaDTO> referenciaDomainListToDTOlist(List<Referencia> domainList){
        return domainList.stream().map(ReferenciaConvert::referenciaDomainToDTO).collect(Collectors.toList());
    }

    public static ReferenciaDTO referenciaDomainToDTO(Referencia domain) {
        return ReferenciaDTO.builder().codigo(domain.getCodigo())
                                   .texto(domain.getTexto())
                                   .publicacao(PublicacaoConvert.publicacaoDomainToDTO(domain.getPublicacao()))
                                   .build();
    }
}
