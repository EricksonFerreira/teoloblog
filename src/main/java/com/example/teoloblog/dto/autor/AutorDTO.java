package com.example.teoloblog.dto.autor;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AutorDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer codigo;
    private String nome;
    private String descricao;
    private String imagem;
}