package com.example.teoloblog.dto.comentario;

import java.io.Serializable;

import com.example.teoloblog.domain.autor.Autor;
import com.example.teoloblog.domain.publicacao.Publicacao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComentarioDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer codigo;
    private String texto;
    private String data;
    private Autor autor;
    private Publicacao publicacao;
}