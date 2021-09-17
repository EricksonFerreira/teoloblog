package com.example.teoloblog.domain.etiquetapublicacao;
import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class EtiquetaPublicacao implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private EtiquetaPublicacaoPK id;
}
