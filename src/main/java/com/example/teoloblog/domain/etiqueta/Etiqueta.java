package com.example.teoloblog.domain.etiqueta;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

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
public class Etiqueta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    private String nome;

    @OneToMany(mappedBy = "id.etiqueta")
    private List<EtiquetaPublicacao> etiquetaPublicacao;

}