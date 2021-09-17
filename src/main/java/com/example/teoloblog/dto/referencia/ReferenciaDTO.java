package com.example.teoloblog.dto.referencia;

import java.io.Serializable;

import com.example.teoloblog.domain.publicacao.Publicacao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReferenciaDTO implements Serializable{

    private static final long serialVersionUID = 1L;

    private Integer codigo;
    // fazer correcoes nos tipos
    private String texto;
    private Publicacao publicacao;
}