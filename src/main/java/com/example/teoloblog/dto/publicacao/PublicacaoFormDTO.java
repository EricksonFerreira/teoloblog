package com.example.teoloblog.dto.publicacao;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PublicacaoFormDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    private String nome;
    private String titulo;
    // fazer correcoes nos tipos
    private String texto;
    private String data;

    // @JsonProperty("autor_id")
    private Integer autorId;
    private List<Integer> listaEtiquetaId;

}
