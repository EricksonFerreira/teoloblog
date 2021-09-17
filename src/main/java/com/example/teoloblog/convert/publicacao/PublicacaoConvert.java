package com.example.teoloblog.convert.publicacao;

import java.util.List;
import java.util.stream.Collectors;

import com.example.teoloblog.convert.etiqueta.EtiquetaConvert;
import com.example.teoloblog.domain.etiqueta.Etiqueta;
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
        List<Etiqueta> etiquetas = domain.getEtiquetaPublicacaoAgrupamento().stream().map(agrupamento -> agrupamento.getId().getEtiqueta()).collect(Collectors.toList());
        
        return PublicacaoDTO.builder().codigo(domain.getCodigo())
                                   .titulo(domain.getTitulo())
                                   .texto(domain.getTexto())
                                   .data(domain.getData())
                                   .etiquetas(EtiquetaConvert.etiquetaDomainListToDTOlist(etiquetas))
                                   .autor(domain.getAutor())
                                   .build();
    }

    public static Publicacao publicacaoFormToEtiquetaEntity(PublicacaoFormDTO publicacaoForm){
        return Publicacao.builder().titulo(publicacaoForm.getTitulo())
                                .texto(publicacaoForm.getTexto())
                                .data(publicacaoForm.getData())
                                // .etiqueta(publicacaoForm.getEtiquetaId())
                                // .    (publicacaoForm.getAutorId())
                                .build();
    }
}
