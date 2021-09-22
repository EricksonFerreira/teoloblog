package com.example.teoloblog.domain.usuario;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import com.example.teoloblog.domain.comentario.Comentario;
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
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    private String nome;
    private String username;
    private String password;

    @OneToMany(mappedBy = "usuario")
    private Set<Comentario> comentario;

    @ManyToOne
    private Funcao funcao;

    
}