package com.example.teoloblog.dto.etiquetapublicacao;

import java.io.Serializable;

import com.example.teoloblog.domain.etiqueta.Etiqueta;
import com.example.teoloblog.domain.publicacao.Publicacao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EtiquetaPublicacaoDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer codigo;
    private Etiqueta etiqueta;
    private Publicacao publicacao;
}