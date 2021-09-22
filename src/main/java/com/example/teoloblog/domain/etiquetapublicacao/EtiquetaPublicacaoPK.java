package com.example.teoloblog.domain.etiquetapublicacao;

import com.example.teoloblog.domain.etiqueta.Etiqueta;
import com.example.teoloblog.domain.publicacao.Publicacao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EtiquetaPublicacaoPK implements Serializable {

    private static final long serialVersionUID = 1;

    @ManyToOne
    private Etiqueta etiqueta;

    @ManyToOne
    private Publicacao publicacao;

}
