package com.example.teoloblog.domain.etiquetapublicacao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class EtiquetaPublicacao implements Serializable {

    private static final long serialVersionUID = 1;

    @EmbeddedId
    private EtiquetaPublicacaoPK id;

}
