package com.example.teoloblog.convert.publicacao;

import java.util.List;
import java.util.stream.Collectors;

import com.example.teoloblog.domain.publicacao.Publicacao;
import com.example.teoloblog.dto.publicacao.PublicacaoDTO;
import com.example.teoloblog.dto.publicacao.PublicacaoFormDTO;


public class PublicacaoConvert {
    private PublicacaoConvert(){

    }

    public static List<PublicacaoDTO> publicacaoDomainListToDTOlist(List<Publicacao> domainList){
        return domainList.stream().map(PublicacaoConvert::publicacaoDomainToDTO).collect(Collectors.toList());
    }

    public static PublicacaoDTO publicacaoDomainToDTO(Publicacao domain) {
        return PublicacaoDTO.builder().codigo(domain.getCodigo())
                                   .titulo(domain.getTitulo())
                                   .texto(domain.getTexto())
                                   .data(domain.getData())
                                   .autor(domain.getAutor())
                                   .build();
    }

}
