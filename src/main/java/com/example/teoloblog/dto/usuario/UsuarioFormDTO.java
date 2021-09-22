package com.example.teoloblog.dto.usuario;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioFormDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String nome;
    private String username;
    private String password;
    private Integer funcaoId;
    
}