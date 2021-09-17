package com.example.teoloblog.domain.etiquetapublicacao;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import com.example.teoloblog.domain.etiqueta.Etiqueta;
import com.example.teoloblog.domain.publicacao.Publicacao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class EtiquetaPublicacaoPK implements Serializable{
    private static final long serialVersionUID = 1L;

    @ManyToOne
    private Publicacao publicacao;
    @ManyToOne
    private Etiqueta etiqueta;
 
}
