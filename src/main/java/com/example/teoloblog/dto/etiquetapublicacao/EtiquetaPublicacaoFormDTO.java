package com.example.teoloblog.dto.etiquetapublicacao;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EtiquetaPublicacaoFormDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer etiquetaId;
    private Integer publicacaoId;
}