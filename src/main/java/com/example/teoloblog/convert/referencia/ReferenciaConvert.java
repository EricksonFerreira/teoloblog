package com.example.teoloblog.convert.referencia;

import java.util.List;
import java.util.stream.Collectors;

import com.example.teoloblog.domain.referencia.Referencia;
import com.example.teoloblog.dto.referencia.ReferenciaDTO;
import com.example.teoloblog.dto.referencia.ReferenciaFormDTO;

public class ReferenciaConvert {
    private ReferenciaConvert(){

    }

    public static List<ReferenciaDTO> p(List<Referencia> domainList){
        return domainList.stream().map(ReferenciaConvert::referenciaDomainToDTO).collect(Collectors.toList());
    }

    public static ReferenciaDTO referenciaDomainToDTO(Referencia domain) {
        return ReferenciaDTO.builder().codigo(domain.getCodigo())
                                   .texto(domain.getTexto())
                                   .publicacao(domain.getPublicacao())
                                   .build();
    }
}
