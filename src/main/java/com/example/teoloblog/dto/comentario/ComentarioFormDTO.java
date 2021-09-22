package com.example.teoloblog.dto.comentario;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComentarioFormDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String nome;    
    private String descricao;    
    private String imagem;

    private Integer autorId;
    private Integer PublicacaoId;
}