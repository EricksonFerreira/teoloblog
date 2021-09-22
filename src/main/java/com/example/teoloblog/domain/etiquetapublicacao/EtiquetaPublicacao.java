package com.example.teoloblog.domain.etiquetapublicacao;

import javax.persistence.*;

import com.example.teoloblog.domain.etiqueta.Etiqueta;
import com.example.teoloblog.domain.publicacao.Publicacao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class EtiquetaPublicacao implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @ManyToOne
    private Etiqueta etiqueta;

    @ManyToOne
    private Publicacao publicacao;

}
