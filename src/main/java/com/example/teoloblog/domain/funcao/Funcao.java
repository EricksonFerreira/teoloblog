package com.example.teoloblog.domain.funcao;

import com.example.teoloblog.domain.comentario.Comentario;
import com.example.teoloblog.domain.usuario.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Funcao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    private String nome;

    @OneToMany(mappedBy = "funcao")
    private Set<Usuario> usuario;

}
