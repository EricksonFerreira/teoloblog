package com.example.teoloblog.dto.usuario;

import java.io.Serializable;

import com.example.teoloblog.domain.funcao.Funcao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer codigo;
    private String nome;
    private String username;
    private String password;

    private Funcao funcao;
}