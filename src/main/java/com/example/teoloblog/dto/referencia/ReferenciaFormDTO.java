package com.example.teoloblog.dto.referencia;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReferenciaFormDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    private String nome;
    // fazer correcoes nos tipos
    private String texto;
    
//    @JsonProperty("publicacao_id")
    private Integer publicacaoId;
    
}
