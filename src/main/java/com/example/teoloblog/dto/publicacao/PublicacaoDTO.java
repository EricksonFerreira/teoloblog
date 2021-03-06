package com.example.teoloblog.dto.publicacao;

import java.io.Serializable;
import java.util.List;

import com.example.teoloblog.domain.autor.Autor;

import com.example.teoloblog.dto.autor.AutorDTO;
import com.example.teoloblog.dto.usuario.UsuarioDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PublicacaoDTO implements Serializable{

    private static final long serialVersionUID = 1L;

    private Integer codigo;
    private String titulo;
    // fazer correcoes nos tipos
    private String texto;
    private String data;
    private AutorDTO autor;
    private UsuarioDTO usuario;
}