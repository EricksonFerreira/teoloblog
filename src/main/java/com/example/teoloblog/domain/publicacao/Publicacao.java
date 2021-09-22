package com.example.teoloblog.domain.publicacao;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.example.teoloblog.domain.autor.Autor;
import com.example.teoloblog.domain.comentario.Comentario;
import com.example.teoloblog.domain.etiquetapublicacao.EtiquetaPublicacao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Publicacao implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer codigo;
    private String titulo;
    // fazer correcoes nos tipos
    // fazer correcoes nos tipos
    private String texto;
    private String data;
    
    @OneToMany(mappedBy = "publicacao")
    private Set<EtiquetaPublicacao> etiquetaPublicacao;

    @ManyToOne
    private Autor autor;

    @OneToMany(mappedBy = "publicacao")
    private Set<Comentario> comentario;

    
}