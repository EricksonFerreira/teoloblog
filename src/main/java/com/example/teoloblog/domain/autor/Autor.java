package com.example.teoloblog.domain.autor;

import java.io.Serializable;

import javax.persistence.*;

import com.example.teoloblog.domain.funcao.Funcao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Autor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    private String nome;
    private String descricao;
    private String imagem;
}